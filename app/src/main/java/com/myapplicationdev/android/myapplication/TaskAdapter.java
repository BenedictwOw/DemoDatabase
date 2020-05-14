package com.myapplicationdev.android.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;

public class TaskAdapter extends ArrayAdapter<Task> {

    private ArrayList<Task> task;
    private Context context;
    private TextView tvTaskNo,tvTask,tvDate;

    public TaskAdapter(@NonNull Context context, int resource, ArrayList<Task> objects) {
        super(context, resource, objects);
        task = objects;
        this.context = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvTaskNo = (TextView) rowView.findViewById(R.id.tvTaskNo);
        tvTask = (TextView) rowView.findViewById(R.id.tvTask);
        tvDate = (TextView) rowView.findViewById(R.id.tvDate);

        Task currentTask = task.get(position);
        tvTaskNo.setText(currentTask.getId()+"");
        tvTask.setText(currentTask.getDescription());
        tvDate.setText(currentTask.getDate());
        return rowView;
    }
}
