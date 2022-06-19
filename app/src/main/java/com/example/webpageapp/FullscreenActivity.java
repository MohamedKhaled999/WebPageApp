package com.example.webpageapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class FullscreenActivity extends AppCompatActivity implements View.OnClickListener {
    FrameLayout mainFrame;
    private AlarmManager alarmManager  = null;
    private PendingIntent pendingIntent  = null;
    Button bb;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        mainFrame = findViewById(R.id.main_frame);
        bb= findViewById(R.id.bb);
        bb.setOnClickListener(this);

//        // Check if Android M or higher
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
//            // Show alert dialog to the user saying a separate permission is needed
//            // Launch the settings activity if the user prefers
//            Intent myIntent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
//            startActivity(myIntent);
//        }

        if (!Settings.canDrawOverlays(this)) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:" + getPackageName()));
            startActivityForResult(intent, 0);
        }
    }


    @Override
    public void onClick(View view) {
       // Intent openWakeup = new Intent(this, WakeupAlarmActivity.class);
        // startActivity(openWakeup);

        setupAlarm();

    }
    private void setupAlarm() {
        //--------< setupAlarm() >--------
        // AlarmManager instance from the system services
        alarmManager = (AlarmManager)   this.getSystemService(Context.ALARM_SERVICE);

        // Intent: this is responsible to prepare the android component what PendingIntent will start when the alarm is triggered. That component can be anyone (activity, service, broadcastReceiver, etc)
        // Intent to start the Broadcast Receiver
        Intent intent =new  Intent(this, AlarmMan.class);

        // PendingIntent: this is the pending intent, which waits until the right time, to be called by AlarmManager
        // The Pending Intent to pass in AlarmManager
        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

        //< create Alarm >
        setAlarm();
        //</ create Alarm >
        //--------</ setupAlarm() >--------
    }

    private void setAlarm() {
        //--------< setup() >--------
        AlarmManager am = (AlarmManager)   this.getSystemService(Context.ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+ 2000, pendingIntent);
        //--------</ setup() >--------
    }
    //========</ Methods >===========
    //------------</ MainActivity >------------
}
