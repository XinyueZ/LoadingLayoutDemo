package com.weavey.loading.lib;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.hardware.display.DisplayManagerCompat;
import android.support.v7.content.res.AppCompatResources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;

/**
 * create by Weavey
 * on date 2016-01-06
 * TODO
 */

public final class Utils {

    private Utils() {}

    public static Drawable getDrawble(Context conetxt, @DrawableRes int id){
        return AppCompatResources.getDrawable(conetxt, id); //It solves problem when using "vector drawable compat"
    }

    public static int getColor(Context conetxt,@ColorRes int id){
        return  ContextCompat.getColor(conetxt,id);
    }

    public static String getString(Context conetxt,@StringRes int id){
        return  conetxt.getResources().getString(id);
    }

    public static int sp2px(Context context, float spValue) {
        final float fontScale = getDisplayMetrics(context).scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public static int dp2px(Context context, int dip) {
        final float scale = getDisplayMetrics(context).density;
        return (int) (dip * scale + 0.5f);
    }

    @NonNull
    private static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        Display[] displays = DisplayManagerCompat.getInstance(context).getDisplays();
        Display display = displays[0];
        display.getMetrics(displaymetrics);
        return displaymetrics;
    }

    public static <T extends View> T findViewById(View v, int id) {


        return (T) v.findViewById(id);
    }

}