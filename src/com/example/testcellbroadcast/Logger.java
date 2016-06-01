
package com.example.testcellbroadcast;

import android.text.TextUtils;
import android.util.Log;

public class Logger {

    public static final String GLOBAL_TAG = "Logger";

    private static final String BUILD = "userdebug";

    private static final boolean USER_BUILD = !TextUtils.isEmpty(BUILD)
            && BUILD.equalsIgnoreCase("user");

    public static void v(String tag, String msg) {
        if (USER_BUILD == false && Log.isLoggable(tag, Log.VERBOSE)) {
            Log.v(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (USER_BUILD == false && Log.isLoggable(tag, Log.DEBUG)) {
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (Log.isLoggable(tag, Log.INFO)) {
            Log.i(tag, msg);
        }
    }


}
