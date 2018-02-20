package com.banerjee.sirsha.eventreminder.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.banerjee.sirsha.eventreminder.model.EventData;

import java.util.ArrayList;

/**
 * Created by indianic on 19/2/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "myDatabase";    // Database Name
    private static final String TABLE_NAME = "myTable";   // Table Name
    private static final int DATABASE_Version = 1;    // Database Version
    private static final String UID="_id";     // Column I (Primary Key)
    private static final String NAME = "Name";    //Column II
    private static final String TIME = "Time";
    private static final String DATE = "Date";
    private static final String REPEAT_MODE = "RepeatMode";
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
            " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255), "+TIME+" VARCHAR(255)," +
            " "+DATE+" VARCHAR(255), "+REPEAT_MODE+" VARCHAR(255));";
    private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_Version);
        this.context=context;
    }

    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL(CREATE_TABLE);
        } catch (Exception e) {
            Log.e("Error",e.toString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }catch (Exception e) {
            Log.e("Error",e.toString());
        }
    }

    public long insertData(String name, String time, String date, String repeatMode)
    {
        SQLiteDatabase dbb = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(TIME, time);
        contentValues.put(DATE, date);
        contentValues.put(REPEAT_MODE, repeatMode);
        long id = dbb.insert(TABLE_NAME, null , contentValues);
        return id;
    }

    // Getting All Contacts
    public ArrayList<EventData> getAllEventData() {
        ArrayList<EventData> arrEventDataList = new ArrayList<EventData>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                EventData eventData = new EventData();
//                eventData.se(Integer.parseInt(cursor.getString(0)));
                eventData.setEventName(cursor.getString(2));
                eventData.setEventTime(cursor.getString(3));
                eventData.setEventDate(cursor.getString(4));
                eventData.setEventRepeatMode(cursor.getString(5));
                // Adding contact to list
                arrEventDataList.add(eventData);
            } while (cursor.moveToNext());
        }

        // return contact list
        return arrEventDataList;
    }
}
