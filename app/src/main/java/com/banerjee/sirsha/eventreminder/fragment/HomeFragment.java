package com.banerjee.sirsha.eventreminder.fragment;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.banerjee.sirsha.eventreminder.R;
import com.banerjee.sirsha.eventreminder.model.EventData;

import java.util.ArrayList;

/**
 * Created by indianic on 15/2/18.
 */

public class HomeFragment extends BaseFragment {

    private RecyclerView rvEventList;

    private ArrayList<EventData> arrEventList;


    @Override
    protected void initializeComponent(View view) {
        rvEventList = view.findViewById(R.id.fragment_home_rvEventList);
        FloatingActionButton fabAddEvent = view.findViewById(R.id.fragment_home_fabAddEvent);

        fabAddEvent.setOnClickListener(this);

        rvEventList.setHasFixedSize(true);
        rvEventList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    protected int defineLayoutResource() {
        return R.layout.fragment_home;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_home_fabAddEvent:
               final AddEventFragment addEventFragment = new AddEventFragment();
               addFragment(R.id.activity_home_flContainer, this, addEventFragment, false, false);
                break;
            default:
                break;
        }
    }
}
