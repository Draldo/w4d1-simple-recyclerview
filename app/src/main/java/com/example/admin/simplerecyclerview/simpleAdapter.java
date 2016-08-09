package com.example.admin.simplerecyclerview;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by admin on 8/8/2016.
 */
public class simpleAdapter extends RecyclerView.Adapter<simpleAdapter.ViewHolder> {

    private ArrayList<String> mArrayStr;
    private Context mContext;

    public simpleAdapter(Context context,ArrayList<String> strings) {
        mContext = context;
        mArrayStr = strings;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener{

        public TextView textViewName;
        public ItemClickListener clickListener;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            textViewName = (TextView) itemView.findViewById(R.id.list_text);
        }

        public void setClickListener(ItemClickListener itemClickListener){
            this.clickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getAdapterPosition(), false);
        }

        @Override
        public boolean onLongClick(View view) {
            clickListener.onClick(view, getAdapterPosition(), true);
            return true;
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

        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(isLongClick){
                    Toast.makeText(mContext, mArrayStr.get(position) + " (Long click)", Toast.LENGTH_SHORT).show();
                } else {
                    Snackbar.make(view, mArrayStr.get(position), Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mArrayStr == null ? 0 : mArrayStr.size();
    }

}
