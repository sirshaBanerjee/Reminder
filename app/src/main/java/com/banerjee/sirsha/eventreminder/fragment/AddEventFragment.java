package com.banerjee.sirsha.eventreminder.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.banerjee.sirsha.eventreminder.R;
import com.banerjee.sirsha.eventreminder.database.DatabaseHelper;

/**
 * Created by indianic on 19/2/18.
 */

public class AddEventFragment extends BaseFragment {

    private EditText etName;
    private EditText etTime;
    private EditText etDate;
    private EditText etRepeatMode;

    private Button btnAdd;

    @Override
    protected void initializeComponent(View view) {
        etName = view.findViewById(R.id.fragment_add_event_etName);
        etTime = view.findViewById(R.id.fragment_add_event_etTime);
        etDate = view.findViewById(R.id.fragment_add_event_etDate);
        etRepeatMode = view.findViewById(R.id.fragment_add_event_etRepeatMode);

        btnAdd = view.findViewById(R.id.fragment_add_btnAdd);
        btnAdd.setOnClickListener(this);
    }

    @Override
    protected int defineLayoutResource() {
        return R.layout.fragment_add_event;
    }

    /**
     * method inserts all the data in the database
     */
    private void insertInDatabase(){

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_add_btnAdd:
                DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());
                databaseHelper.insertData(etName.getText().toString().trim(),
                        etTime.getText().toString().trim(), etDate.getText().toString().trim(),
                        etRepeatMode.getText().toString().trim());
                databaseHelper.getAllEventData();
                break;
            default:
                break;
        }
    }
}
