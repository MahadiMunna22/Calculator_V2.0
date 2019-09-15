package com.example.calculator_v20;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<StoreResult> {

    private Activity context;
    private List<StoreResult> resultList;

    public CustomAdapter(Activity context, List<StoreResult> resultList) {
        super(context,R.layout.sample_activity, resultList);
        this.context = context;
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.sample_activity,null,true);

        StoreResult storeResult = resultList.get(position);
        TextView t1 = view.findViewById(R.id.textViewId);

        t1.setText(storeResult.getValue());
        return view;
    }
}
