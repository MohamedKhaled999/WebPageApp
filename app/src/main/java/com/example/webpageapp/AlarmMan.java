package com.example.webpageapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmMan extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context.getApplicationContext(), "dkjjkbdcnhj", Toast.LENGTH_SHORT).show();
        //------< onReceive() >--------
        //this event triggers when alarm in Android happens
        //*open Wakeup Alarm Activity
        Intent alarmIntent = new Intent(context, WakeupAlarmActivity.class);
        alarmIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //open Activitiy
        context.startActivity(alarmIntent);
    }
}
