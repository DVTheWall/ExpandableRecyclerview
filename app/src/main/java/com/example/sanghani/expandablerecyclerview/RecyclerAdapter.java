package com.example.sanghani.expandablerecyclerview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by peacock on 12/12/17.
 */

public class RecyclerAdapter extends ExpandableRecyclerViewAdapter<OSViewHolder, PhoneViewHolder> {

    private Activity activity;

    public RecyclerAdapter(Activity activity, List<? extends ExpandableGroup> groups) {
        super(groups);
        this.activity = activity;
    }

    @Override
    public OSViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.group_view_holder, parent, false);

        return new OSViewHolder(view);
    }

    @Override
    public PhoneViewHolder onCreateChildViewHolder(ViewGroup parent, final int viewType) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_child, parent, false);

        return new PhoneViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(PhoneViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final History history = ((MobileOS) group).getItems().get(childIndex);
        holder.onBind(history, group);
    }

    @Override
    public void onBindGroupViewHolder(OSViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setGroupName(group);
    }
}