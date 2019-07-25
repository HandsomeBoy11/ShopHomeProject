package com.xrd.shophomeproject.utils;

import android.graphics.Color;

/**
 * Created by WJ on 2019/5/6.
 */

public class ColorUtitl {

    public static int changeColorAlpha(int color,int alpha){
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        return Color.argb(alpha,red,green,blue);
    }
}
