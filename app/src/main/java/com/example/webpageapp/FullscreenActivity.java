package com.example.webpageapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class FullscreenActivity extends AppCompatActivity implements View.OnClickListener {
    FrameLayout mainFrame;

    Button bb;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        mainFrame = findViewById(R.id.main_frame);
        bb= findViewById(R.id.bb);
        bb.setOnClickListener(this);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
                WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
    }

    public void startWakeup() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                mainFrame.setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_LOW_PROFILE |
                                View.SYSTEM_UI_FLAG_FULLSCREEN |
                                View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                );
            }
        });
    }

    public void stopWakeup() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

                mainFrame.setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_VISIBLE
                );
            }
        });
    }

    @Override
    public void onClick(View view) {
        Calendar c= Calendar.getInstance() ;

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent= new Intent(this.getApplicationContext(), AlarmMan.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1,intent,0);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+3000,pendingIntent);
    }
}