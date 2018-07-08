package com.twins.virtualmirror.applications;

import android.app.Application;
import android.content.Context;

/**
 * Created by anshumanpattnaik on 19/08/16.
 */
public class Applications extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        Applications.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return Applications.context;
    }
}
