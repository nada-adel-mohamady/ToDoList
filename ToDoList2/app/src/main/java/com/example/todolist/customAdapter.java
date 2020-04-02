package com.example.todolist;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

// ---------------------custom adpater ---------------//
class customAdpater extends ArrayAdapter<String> {

    private final ArrayList<String> values;
    private Context context;
    private  final ArrayList<String>colors;
    public customAdpater(Context context , ArrayList<String> values, ArrayList<String> colors) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
        this.colors = colors;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

      //  LayoutInflater inflater = (LayoutInflater) context
        //        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      //  View rowView = inflater.inflate(R.layout.list_view_layout, parent, false);
        View rowView = LayoutInflater.from(context).inflate(R.layout.list_view_layout, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.text);
       // Button v = (Button) rowView.findViewById(R.id.view);
        textView.setText(values.get(position));
        LinearLayout l = (LinearLayout) rowView.findViewById(R.id.important);
        l.setBackgroundColor(Color.parseColor(colors.get(position)));
        l.invalidate();
       // v.setVisibility(View.VISIBLE);

        return rowView;
    }
}
//-------------------------end custom adpater ------------------------