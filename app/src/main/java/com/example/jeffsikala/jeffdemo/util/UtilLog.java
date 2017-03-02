package com.example.jeffsikala.jeffdemo.util;

import android.util.Log;

/**
 * Created by Jeff on 3/1/17.
 */

public class UtilLog {



    private static boolean Debug = false;

    // Methods must be static to get access

    public static void setDebug(boolean b){
        Debug = b;
    }

    public static void logD(String key, String value){
        if (Debug){
            Log.d(key, value);
        }
    }

}
