package com.banerjee.sirsha.eventreminder.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.banerjee.sirsha.eventreminder.R;
import com.banerjee.sirsha.eventreminder.model.EventData;

import java.util.ArrayList;

/**
 * Created by indianic on 16/2/18.
 */

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.EventListViewHolder> {

    private ArrayList<EventData> arrEventList;

    public EventListAdapter(ArrayList arrEventList){
        this.arrEventList = arrEventList;
    }

    @Override
    public EventListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final EventListViewHolder eventListViewHolder;
        final View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_event, parent, false);
        eventListViewHolder = new EventListViewHolder(row);
        return eventListViewHolder;
    }

    @Override
    public void onBindViewHolder(EventListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return arrEventList.size();
    }

    public class EventListViewHolder extends RecyclerView.ViewHolder{

        public EventListViewHolder(View itemView) {
            super(itemView);
        }
    }
}
