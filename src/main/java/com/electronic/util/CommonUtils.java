package com.electronic.util;

import android.util.Log;

/**
 * 打印工具类
 */
public class CommonUtils {
    public static void log(String msg) {
        Log.i("---", msg);
    }

    public static void logError(String msg) {
        Log.v("---", msg);
    }
}
