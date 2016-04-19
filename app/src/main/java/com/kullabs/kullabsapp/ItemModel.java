package com.kullabs.kullabsapp;

import android.animation.TimeInterpolator;

/**
 * Created by Ojesh on 2/16/2016.
 */
public class ItemModel {
    public final String description;
    public final int colorId1;
    public final TimeInterpolator interpolator;

    public ItemModel(String description,int colorId1, TimeInterpolator interpolator) {
        this.description = description;
        this.colorId1 = colorId1;
        this.interpolator = interpolator;
    }
}
