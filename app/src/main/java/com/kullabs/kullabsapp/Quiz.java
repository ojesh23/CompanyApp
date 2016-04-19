package com.kullabs.kullabsapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;



/**
 * Created by Ojesh on 2/14/2016.
 */
public class Quiz extends Fragment {
    static WebView mWeb;
    private View mContentView;
    private ProgressBar spinner;
    CountDownTimer mCountDownTimer;
    int i = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContentView = inflater.inflate(R.layout.wsite, container, false);
        mWeb = (WebView) mContentView.findViewById(R.id.webview);

        spinner = (ProgressBar) mContentView.findViewById(R.id.progressBar);
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
        mWeb.setWebChromeClient(new MyWebChromeClient());
        mWeb.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
       /* mWeb.setWebViewClient(new FacebookWebViewClient());
        String url = getFacebookLikeUrl();*/
        mWeb.getSettings().setSupportMultipleWindows(true);

        mWeb.loadUrl("https://www.kullabs.com/sponsored");

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

   /* public String FacebookWebViewClient(){
        return "http://www.facebook.com/plugins/like.php?" + "href=";

    }*/

    final class MyWebChromeClient extends WebChromeClient {


        @Override
        public boolean onCreateWindow(WebView view, boolean dialog,
                                      boolean userGesture, Message resultMsg) {
            WebView childView = new WebView(getContext());
            childView.getSettings().setJavaScriptEnabled(true);
            childView.setWebChromeClient(this);
//            childView.setWebViewClient(new FacebookWebViewClient());
//            childView.setLayoutParams(FILL);
//            mContent.addView(childView);
            WebView.WebViewTransport transport = (WebView.WebViewTransport) resultMsg.obj;
            transport.setWebView(childView);
            resultMsg.sendToTarget();
            return true;
        }


        @Override
        public boolean onJsConfirm(WebView view, String url, String message, final JsResult result) {
            new AlertDialog.Builder(getContext())
                    .setTitle("Kumbio")
                    .setMessage(message)
                    .setPositiveButton(android.R.string.ok,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    result.confirm();
                                }
                            })
                    .setNegativeButton(android.R.string.cancel,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    result.cancel();
                                }
                            })
                    .create()
                    .show();

            return true;
        }
       /* @Override
        public boolean onJsAlert(WebView view, String url, String message, final android.webkit.JsResult result) {
            new AlertDialog.Builder(getContext())
                    .setTitle("Alert")
                    .setMessage(message)
                    .setPositiveButton(android.R.string.ok,
                            new AlertDialog.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    result.confirm();
                                }
                            }).setCancelable(false).create().show();

            return true;
        }*/

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
