package com.silicus.recyclerviewcomponent;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjadhav on 4/18/18.
 */

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.DemoViewHolder>{


    private Context mContext;

    private OnMonthClickListener listener;

    private List<String> monthList;

    public DemoAdapter(Context mContext, OnMonthClickListener listener) {
        this.mContext = mContext;
        this.listener = listener;
        monthList = new ArrayList<>();
    }



    @Override
    public DemoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView  = LayoutInflater.from(mContext).inflate(R.layout.row_demo,parent,false);
        return new DemoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DemoViewHolder holder, int position) {

        holder.textViewTitle.setText(monthList.get(position));
    }

    @Override
    public int getItemCount() {
        return monthList.size();
    }


    /**
     * Append all item
     * @param data
     */
    public void addAllData(List<String> data){
        monthList.addAll(data);
        notifyDataSetChanged();
    }


    /**
     * Add Single Item
     * @param data
     */
    public void addSingleItem(String data){
        monthList.add(data);
        notifyDataSetChanged();
    }

    /**
     * Replace all data
     * @param data
     */
    public void updateData(List<String> data){

        monthList.clear();
        monthList.addAll(data);
        notifyDataSetChanged();
    }



    /**
     *
     */
    class DemoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        /**
         *
         */
         private AppCompatTextView textViewTitle;

        /**
         *
         * @param itemView
         */
        public DemoViewHolder(View itemView) {
            super(itemView);

            // Initiliase UI, row_demo
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (listener != null){
                listener.onMonthClick(position, monthList.get(position));
            }
        }
    }
}
