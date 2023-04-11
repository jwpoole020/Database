package com.example.contactsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private String[] localDataSet;
    private String[] localTeams;
    View.OnClickListener listener;


    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final TextView subView;

        public ViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.textView);
            subView= (TextView) view.findViewById(R.id.subView);
            textView.setOnClickListener(listener);
            textView.setTag(this);
        }
        public TextView getTextView() {
            return textView;
        }
        public TextView getSubView(){ return subView;}
    }

    public CustomAdapter(String[] dataSet, String[] teamSet) {
        localDataSet = dataSet;
        localTeams= teamSet;
    }

    public void setOnClickListener(View.OnClickListener listenThing){
        listener= listenThing;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.text_row_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.getTextView().setText(localDataSet[position]);
        viewHolder.getSubView().setText(localTeams[position]);
    }

    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}
