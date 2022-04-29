package com.rc.lock.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;

public class ScreenUtil {
    /**
     * 
     *
     * @param context
     * @return
     */
    public static int getPhoneHeight(@NonNull Context context) {
        DisplayMetrics dm = getDisplayMetrics(context);
        return dm.heightPixels;
    }

    /**
     *
     * @param context
     * @return
     */
    public static int getPhoneWidth(@NonNull Context context) {
        DisplayMetrics dm = getDisplayMetrics(context);
        return dm.widthPixels;
    }

    /**
     *
     * @param context
     * @return
     */
    public static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm;
    }

    /**
     * @param context
     * @return ORIENTATION_LANDSCAPE, ORIENTATION_PORTRAIT.
     */
    public static int getDisplayOrient (Context context) {
        return context.getResources().getConfiguration().orientation;
    }

}
