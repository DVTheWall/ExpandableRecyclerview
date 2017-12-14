package com.example.sanghani.expandablerecyclerview;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by peacock on 12/12/17.
 */

public class Phone implements Parcelable {

    public static final Parcelable.Creator<Phone> CREATOR = new Parcelable.Creator<Phone>() {
        @Override
        public Phone createFromParcel(Parcel in) {
            return new Phone(in);
        }

        @Override
        public Phone[] newArray(int size) {
            return new Phone[size];
        }
    };
    private String name, number;

    public Phone(Parcel in) {
        name = in.readString();
        number = in.readString();
    }


    public Phone() {
    }

    public Phone(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(number);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}