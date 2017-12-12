package com.example.sanghani.expandablerecyclerview;

/**
 * Created by peacock on 12/12/17.
 */


import android.annotation.SuppressLint;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

@SuppressLint("ParcelCreator")
public class MobileOS extends ExpandableGroup<Phone> {

    public MobileOS(String title, List<Phone> items) {
        super(title, items);
    }
}