package com.kullabs.kullabsapp;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by Ojesh on 2/19/2016.
 */
public class Notes extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes_layoutdemo);

        WebView wb=(WebView)findViewById(R.id.demoweb);
        wb.loadUrl("https://www.kullabs.com/class-9/science-9/physics-9/measurement");
    }
}
