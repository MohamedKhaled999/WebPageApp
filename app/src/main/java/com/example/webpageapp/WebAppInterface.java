package com.example.webpageapp;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebAppInterface {
    Context mContext ;
 WebAppInterface(Context c){
mContext =c;
 }

 
 @JavascriptInterface
 public  void showToast(String toast){
     Toast.makeText(mContext, "hi", Toast.LENGTH_SHORT).show();
}

}

