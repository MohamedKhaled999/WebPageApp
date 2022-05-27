package com.example.webpageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent= new Intent(this ,FullscreenActivity.class);
        startActivity(intent);
        mWebView = (WebView) findViewById(R.id.activity_main_webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.loadUrl("https://www.google.com/?hl=ar");
       // mWebView.addJavascriptInterface (new WebAppInterface (this),"Android");
        mWebView.setWebViewClient(new WebViewClient());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (( keyCode == KeyEvent.KEYCODE_BACK ) && mWebView.canGoBack ()){
            mWebView.goBack();
        return true;}
        return super.onKeyDown (keyCode ,event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (( keyCode == KeyEvent.KEYCODE_FORWARD ) && mWebView.canGoForward ()){

            mWebView.goForward();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }
}