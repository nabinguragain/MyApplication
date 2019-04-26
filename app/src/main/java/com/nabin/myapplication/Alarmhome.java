package com.nabin.myapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;


public class Alarmhome extends AppCompatActivity {

    TimePicker timePicker;
    TextView timeTextView;

    int mHour, mMin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarmhome);

    timePicker = (TimePicker)findViewById(R.id.timePicker);
    timeTextView = (TextView)findViewById(R.id.timeTextView);

    timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
        @Override
        public void onTimeChanged(TimePicker timePicker, int hourOfDay, int minute) {

            mHour = hourOfDay;
            mMin = minute;

            timeTextView.setText(timeTextView.getText().toString()+ " "+mHour+":"+mMin);

        }
    });

    }
    public void setTimer(View v){
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);

        Date date = new Date();
        Calendar cal_alarm = Calendar.getInstance();
        Calendar cal_now = Calendar.getInstance();


        cal_alarm.setTime(date);
        cal_now.setTime(date);


        cal_alarm.set(Calendar.HOUR_OF_DAY,mHour);
        cal_alarm.set(Calendar.MINUTE,mMin);
        cal_alarm.set(Calendar.SECOND,0);

        if(cal_alarm.before(cal_now)){

            cal_alarm.add(Calendar.DATE,1);
        }
        Intent i = new Intent(Alarmhome.this,MyBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(Alarmhome.this,24444,i,0);
        alarmManager.set(AlarmManager.RTC_WAKEUP,cal_alarm.getTimeInMillis(),pendingIntent);

    }


}
