package org.uab.dedam.todoman;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class TaskAdapter extends BaseAdapter {
    private ArrayList<String> taskList;
    private Context context;

    public TaskAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return taskList.size();
    }

    @Override
    public Object getItem(int position) {
        return taskList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.activity_home, parent, false);
        }
        else {
            itemView = convertView;
        }

        itemView.findViewById(R.id.taskTitle);
        return itemView;
    }
}
