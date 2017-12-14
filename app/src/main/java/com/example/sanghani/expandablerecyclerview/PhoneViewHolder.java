package com.example.sanghani.expandablerecyclerview;

import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

/**
 * Created by peacock on 12/12/17.
 */


public class PhoneViewHolder extends ChildViewHolder {

    AppCompatTextView Question, answer1, answer2, answer3, answer4, Percentage1,
            Percentage2, Percentage3, Percentage4;
    RadioButton radioButton1, radioButton2, radioButton3, radioButton4;

    public PhoneViewHolder(View itemView) {
        super(itemView);

       /* phoneName = (TextView) itemView.findViewById(R.id.phone_name);
        phoneNumber = (TextView) itemView.findViewById(R.id.phone_number);*/

        Question = (AppCompatTextView) itemView.findViewById(R.id.txt_question);

        answer1 = (AppCompatTextView) itemView.findViewById(R.id.txt_answer1);
        answer2 = (AppCompatTextView) itemView.findViewById(R.id.txt_answer2);
        answer3 = (AppCompatTextView) itemView.findViewById(R.id.txt_answer3);
        answer4 = (AppCompatTextView) itemView.findViewById(R.id.txt_answer4);


        Percentage1 = (AppCompatTextView) itemView.findViewById(R.id.txt_percentage1);
        Percentage2 = (AppCompatTextView) itemView.findViewById(R.id.txt_percentage2);
        Percentage3 = (AppCompatTextView) itemView.findViewById(R.id.txt_percentage3);
        Percentage4 = (AppCompatTextView) itemView.findViewById(R.id.txt_percentage4);

        radioButton1 = (RadioButton) itemView.findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) itemView.findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) itemView.findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) itemView.findViewById(R.id.radioButton4);


    }

    public void onBind(History history, ExpandableGroup group) {

      //  phoneName.setText(phone.getName());
        //phoneNumber.setText(phone.getNumber());




        Question.setText(history.getQuestionText());

        answer1.setText(history.getAnswerText1());
        answer2.setText(history.getAnswerText2());
        answer3.setText(history.getAnswerText3());
        answer4.setText(history.getAnswerText4());

        Percentage1.setText(history.getPercentage1());
        Percentage2.setText(history.getPercentage2());
        Percentage3.setText(history.getPercentage3());
        Percentage4.setText(history.getPercentage4());

     /*   int finalid = Integer.parseInt(history.getFinalId());

        if (finalid % 4 == 1) {
            radioButton1.setChecked(true);
        } else if (finalid % 4 == 2) {
            radioButton2.setChecked(true);
        } else if (finalid % 4 == 3) {
            radioButton3.setChecked(true);
        } else if (finalid % 4 == 4) {
            radioButton4.setChecked(true);
        }*/

    /*    if (group.getTitle().equals("Android")) {
            phoneName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_device, 0, 0, 0);
        } else if (group.getTitle().equals("iOS")) {
            phoneName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_device, 0, 0, 0);
        } else {
            phoneName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_device, 0, 0, 0);
        }*/
    }
}