package com.banerjee.sirsha.eventreminder.application;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by indianic on 19/2/18.
 */

public class Reminder extends Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }

}
