package com.example.sanghani.expandablerecyclerview;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

/**
 * Created by peacock on 12/12/17.
 */


public class PhoneViewHolder extends ChildViewHolder {

    private TextView phoneName, phoneNumber;

    public PhoneViewHolder(View itemView) {
        super(itemView);

        phoneName = (TextView) itemView.findViewById(R.id.phone_name);
        phoneNumber = (TextView) itemView.findViewById(R.id.phone_number);
    }

    public void onBind(Phone phone, ExpandableGroup group) {

        phoneName.setText(phone.getName());
        phoneNumber.setText(phone.getNumber());

        if (group.getTitle().equals("Android")) {
            phoneName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_device, 0, 0, 0);
        } else if (group.getTitle().equals("iOS")) {
            phoneName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_device, 0, 0, 0);
        } else {
            phoneName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_device, 0, 0, 0);
        }
    }
}