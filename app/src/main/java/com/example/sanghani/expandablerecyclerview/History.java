package com.example.sanghani.expandablerecyclerview;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Dhaval on 11-Dec-17.
 */

public class History implements Parcelable {

    private String QuestionText = "";
    private String AnswerText = "";
    private String AnswerId = "";
    private String VideoId = "";
    private String Url = "";
    private String ShortDescription = "";
    private String Details = "";
    private String Image = "";
    private String PlaySubmitDateTime = "";
    private String SelectdAnswer = "";
    private String Percentage = "";


    private String AnswerText1 = "";
    private String AnswerText2 = "";
    private String AnswerText3 = "";
    private String AnswerText4 = "";
    private String Percentage1 = "";
    private String Percentage2 = "";
    private String Percentage3 = "";
    private String Percentage4 = "";

    private String FinalId = "";

    public History(Parcel in) {

        QuestionText = in.readString();
        ShortDescription = in.readString();

        Details = in.readString();
        Image = in.readString();
        PlaySubmitDateTime = in.readString();

        AnswerText1 = in.readString();
        AnswerText2 = in.readString();
        AnswerText3 = in.readString();
        AnswerText4 = in.readString();

        Percentage1 = in.readString();
        Percentage2 = in.readString();
        Percentage3 = in.readString();
        Percentage4 = in.readString();

    }


    public History() {
    }

    public String getAnswerText1() {
        return AnswerText1;
    }

    public void setAnswerText1(String answerText1) {
        AnswerText1 = answerText1;
    }

    public String getAnswerText2() {
        return AnswerText2;
    }

    public void setAnswerText2(String answerText2) {
        AnswerText2 = answerText2;
    }

    public String getAnswerText3() {
        return AnswerText3;
    }

    public void setAnswerText3(String answerText3) {
        AnswerText3 = answerText3;
    }

    public String getAnswerText4() {
        return AnswerText4;
    }

    public void setAnswerText4(String answerText4) {
        AnswerText4 = answerText4;
    }

    public String getPercentage1() {
        return Percentage1;
    }

    public void setPercentage1(String percentage1) {
        Percentage1 = percentage1;
    }

    public String getPercentage2() {
        return Percentage2;
    }

    public void setPercentage2(String percentage2) {
        Percentage2 = percentage2;
    }

    public String getPercentage3() {
        return Percentage3;
    }

    public void setPercentage3(String percentage3) {
        Percentage3 = percentage3;
    }

    public String getPercentage4() {
        return Percentage4;
    }

    public void setPercentage4(String percentage4) {
        Percentage4 = percentage4;
    }

    public String getFinalId() {
        return FinalId;
    }

    public void setFinalId(String finalId) {
        FinalId = finalId;
    }

    public String getQuestionText() {
        return QuestionText;
    }

    public void setQuestionText(String questionText) {
        QuestionText = questionText;
    }

    public String getAnswerText() {
        return AnswerText;
    }

    public void setAnswerText(String answerText) {
        AnswerText = answerText;
    }

    public String getAnswerId() {
        return AnswerId;
    }

    public void setAnswerId(String answerId) {
        AnswerId = answerId;
    }

    public String getVideoId() {
        return VideoId;
    }

    public void setVideoId(String videoId) {
        VideoId = videoId;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getShortDescription() {
        return ShortDescription;
    }

    public void setShortDescription(String shortDescription) {
        ShortDescription = shortDescription;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getPlaySubmitDateTime() {
        return PlaySubmitDateTime;
    }

    public void setPlaySubmitDateTime(String playSubmitDateTime) {
        PlaySubmitDateTime = playSubmitDateTime;
    }

    public String getSelectdAnswer() {
        return SelectdAnswer;
    }

    public void setSelectdAnswer(String selectdAnswer) {
        SelectdAnswer = selectdAnswer;
    }

    public String getPercentage() {
        return Percentage;
    }

    public void setPercentage(String percentage) {
        Percentage = percentage;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
