package com.example.sanghani.expandablerecyclerview;

/**
 * Created by peacock on 12/12/17.
 */



import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;


public class MobileOS extends ExpandableGroup<History> {

    public MobileOS(String title, List<History> items) {
        super(title, items);
    }
}