package com.example.admin.simplerecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 8/8/2016.
 */
public class simpleAdapter extends RecyclerView.Adapter<simpleAdapter.ViewHolder> {

    private ArrayList<String> mArrayStr;

    public simpleAdapter(ArrayList<String> strings){
        mArrayStr = strings;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewName;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewName = (TextView) itemView.findViewById(R.id.list_text);
        }
    }

    //Create our view
    public simpleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item, parent, false);

        return new ViewHolder(view);
    }

    //Set items
    @Override
    public void onBindViewHolder(simpleAdapter.ViewHolder holder, int position) {
        String str = mArrayStr.get(position);

        TextView textView = holder.textViewName;
        textView.setText(str);

    }

    @Override
    public int getItemCount() {
        return mArrayStr == null? 0 : mArrayStr.size();
    }

}
