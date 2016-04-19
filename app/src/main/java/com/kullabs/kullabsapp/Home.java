package com.kullabs.kullabsapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * Created by Ojesh on 1/1/2016.
 */
public class Home extends Fragment {

    static WebView mWeb;
    private View mContentView;
    private ProgressBar spinner;
    CountDownTimer mCountDownTimer;
    int i=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        mContentView = inflater.inflate(R.layout.wsite, container, false);
        mWeb = (WebView)mContentView.findViewById(R.id.webview);

        spinner=(ProgressBar)mContentView.findViewById(R.id.progressBar);

        spinner.setProgress(i);

        mCountDownTimer = new CountDownTimer(3000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                spinner.setProgress(i);

            }

            @Override
            public void onFinish() {
                spinner.setVisibility(View.GONE);
            }
        };
        mCountDownTimer.start();

        WebSettings settings = mWeb.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(false);
        mWeb.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        mWeb.getSettings().setBuiltInZoomControls(false);
        mWeb.setWebViewClient(new ourViewClient());
        mWeb.loadUrl("https://www.kullabs.com/");

        mWeb.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    WebView webView = (WebView) v;

                    switch (keyCode) {
                        case KeyEvent.KEYCODE_BACK:
                            if (webView.canGoBack()) {
                                webView.goBack();
                                return true;
                            }
                            break;
                    }
                }

                return false;
            }
        });
        return mContentView;
    }
    private class ourViewClient extends WebViewClient {

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String url) {
            mWeb.loadDataWithBaseURL("file:///android_res/drawable/", "<img src=\"conntn.png\" height=\"100%\" width=\"100%\"/>", "text/html", "utf-8", null);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}

