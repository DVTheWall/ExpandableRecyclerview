package com.example.sanghani.expandablerecyclerview;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class MainActivity extends AppCompatActivity {

    /*
    This Expandable Recyclerview Link
        http://www.devexchanges.info/2016/09/expandable-recyclerview-in-android.html

      */
    public String NAMESPACE = "http://tempuri.org/";
    public String URL = "http://naimeshgalsar.com/oakscroll/doctorappservice.asmx?WSDL";
    private RecyclerView recyclerView;
    private ArrayList<MobileOS> mobileOSes;
    private RecyclerAdapter adapter;
    //Submit Button To Click This Service
    private String METHOD_NAME = "UserQuizHistory";
    private String SOAP_ACTION = "http://tempuri.org/UserQuizHistory";

    private ArrayList<History> historyList, mainlist;


    private static String getValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mobileOSes = new ArrayList<>();
        mainlist = new ArrayList<>();

        history_ServiceCall();

        //    setData();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Just Check Important Point Comment

 /*       mainlist = new ArrayList<>();
        for (int i=0;i<2;i++) {
            History history = new History();
            history.setQuestionText("Nexus One");
            history.setAnswerText1("HELLO WORLD");
            history.setAnswerText2("HELLO WORLD");
            history.setAnswerText3("HELLO WORLD");
            history.setAnswerText4("HELLO WORLD");

            history.setQuestionText("Nexus One");
            history.setPercentage1("12");
            history.setPercentage2("12");
            history.setPercentage3("12");
            history.setPercentage4("12");
            mainlist.add(history);

        }*/

        adapter = new RecyclerAdapter(this, mobileOSes);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        adapter.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        adapter.onRestoreInstanceState(savedInstanceState);
    }

    private void setData() {


        ArrayList<Phone> iphones = new ArrayList<>();
        iphones.add(new Phone("iPhone 4"));
        iphones.add(new Phone("iPhone 4S"));
        iphones.add(new Phone("iPhone 5"));
        iphones.add(new Phone("iPhone 5S"));
        iphones.add(new Phone("iPhone 6"));
        iphones.add(new Phone("iPhone 6Plus"));
        iphones.add(new Phone("iPhone 6S"));
        iphones.add(new Phone("iPhone 6S Plus"));

        ArrayList<Phone> nexus = new ArrayList<>();
        Phone phone = new Phone();
        phone.setName("Nexus One");
        phone.setNumber("HELLO WORLD");

        nexus.add(phone);
        nexus.add(new Phone("Nexus S"));
        nexus.add(new Phone("Nexus 4"));
        nexus.add(new Phone("Nexus 5"));
        nexus.add(new Phone("Nexus 6"));
        nexus.add(new Phone("Nexus 5X"));
        nexus.add(new Phone("Nexus 6P"));
        nexus.add(new Phone("Nexus 7"));

        ArrayList<Phone> windowPhones = new ArrayList<>();
        windowPhones.add(new Phone("Nokia Lumia 800"));
        windowPhones.add(new Phone("Nokia Lumia 710"));
        windowPhones.add(new Phone("Nokia Lumia 900"));
        windowPhones.add(new Phone("Nokia Lumia 610"));
        windowPhones.add(new Phone("Nokia Lumia 510"));
        windowPhones.add(new Phone("Nokia Lumia 820"));
        windowPhones.add(new Phone("Nokia Lumia 920"));

        mobileOSes.add(new MobileOS("iOS", mainlist));
//        mobileOSes.add(new MobileOS("Android", nexus));
//        mobileOSes.add(new MobileOS("Window Phone", windowPhones));

    }

    private void history_ServiceCall() {


        class MyTask extends AsyncTask<String, Integer, String> {

            @Override
            protected String doInBackground(String... params) {
                String response = "";
                //Initialize soap request + add parameters
                SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

                //Use this to add parameters
                request.addProperty("userid", 19);

                //Declare the version of the SOAP request
                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                //new MarshalBase64().register(envelope);
                envelope.encodingStyle = SoapEnvelope.ENC;
                envelope.setOutputSoapObject(request);
                envelope.dotNet = true;


                try {
                    HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

                    //this is the actual part that will call the webservice
                    androidHttpTransport.call(SOAP_ACTION, envelope);

                    SoapPrimitive result = (SoapPrimitive) envelope.getResponse();
                    response = result.toString();

                    return response;


                } catch (Exception e) {
                    e.printStackTrace();
                    return "";
                }
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

                if (result != null) {

                    //CommonUtility.Log("UserQuizHistory --> Response", result);
                    parseResult(result);

                } else {

                    // CommonUtility.Log("UserQuizHistory --> Response", result);

                }

            }
        }

        MyTask mt = new MyTask();
        mt.execute();
    }

    private void parseResult(String result) {

        historyList = new ArrayList<>();

        try {
            InputStream is = new ByteArrayInputStream(result.getBytes("UTF-8"));

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);

            Element element = doc.getDocumentElement();
            element.normalize();

            NodeList nList = doc.getElementsByTagName("DA_UserQuizHistory");


            for (int i = 0; i < nList.getLength(); i++) {

                History histo = new History();
                Node node = nList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element2 = (Element) node;

                    histo.setQuestionText(getValue("QuestionText", element2));
                    histo.setAnswerText(getValue("AnswerText", element2));
                    histo.setAnswerId(getValue("AnswerId", element2));
                    histo.setVideoId(getValue("VideoId", element2));
                    histo.setUrl(getValue("Url", element2));
                    histo.setShortDescription(getValue("ShortDescription", element2));
                    histo.setDetails(getValue("Details", element2));
//                    histo.setImage(getValue("Image", element2));
                    histo.setPlaySubmitDateTime(getValue("PlaySubmitDateTime", element2));
                    histo.setSelectdAnswer(getValue("SelectdAnswer", element2));
                    histo.setPercentage(getValue("Percentage", element2));


                    historyList.add(histo);
                }
            }

            SetList(historyList);


            Toast.makeText(this, "History List -- > " + String.valueOf(historyList.size()), Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void SetList(ArrayList<History> historyList) {

//        CommonUtility.Log(" SetList History List -- > ", String.valueOf(historyList.size()));

        int i = 0;

        while (i < 16) {

            History data = new History();

            data.setQuestionText(historyList.get(i).getQuestionText());

            data.setAnswerText1(historyList.get(i).getAnswerText());
            data.setPercentage1(historyList.get(i).getPercentage());

            data.setAnswerText2(historyList.get(i + 1).getAnswerText());
            data.setPercentage2(historyList.get(i + 1).getPercentage());

            data.setAnswerText3(historyList.get(i + 2).getAnswerText());
            data.setPercentage3(historyList.get(i + 2).getPercentage());

            data.setAnswerText4(historyList.get(i + 3).getAnswerText());
            data.setPercentage4(historyList.get(i + 3).getPercentage());


            for (int j = i; j < i + 4; j++) {

                if (historyList.get(j).getAnswerId().equals(historyList.get(i).getSelectdAnswer())) {

                    data.setFinalId(historyList.get(j).getAnswerId());

                }
            }

            mainlist.add(data);


            i = i + 4;
        }

        mobileOSes.add(new MobileOS("iOS", mainlist));


        System.out.println("MainList --> " + mainlist.size());


    }
}