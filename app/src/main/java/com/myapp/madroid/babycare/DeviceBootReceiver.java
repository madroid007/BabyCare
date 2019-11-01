package com.myapp.madroid.babycare;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;

/**
 * Created by Ahmed on 1/29/2018.
 */

public class DeviceBootReceiver extends BroadcastReceiver {

    // final String ACTION_NEW_WEEK = "new-week-is-here";
    SharedPreferences shrd ;
    String lang ;
    Calendar cal , today , notifyCal ;
    long diff ;
    int selectedYear , selectedMonth , selectedDay , weeeeeeeeks , daaaaaaaays , diff_days , diff_weeks;
    int WEEK_INTERVAL = 7 * 1000 * 60 * 60 * 24 ;
    int PREGNANCY_INTERVAL = 281 * 1000 * 60 * 60 * 24 ;
    int DAY_INTERVAL = 1000 * 60 * 60* 24 ;
    AlarmManager alarmManager ;
    Intent notifyIntent ;
    PendingIntent pendingIntent ;

    @Override
    public void onReceive(Context context, Intent intent) {



        if (intent.getAction().equalsIgnoreCase("android.intent.action.BOOT_COMPLETED") || intent.getAction().equalsIgnoreCase("android.intent.action.REBOOT")) {

            shrd = PreferenceManager.getDefaultSharedPreferences(context);
            lang = shrd.getString("language","ara");
            selectedDay = shrd.getInt("selectedDay",11);
            selectedMonth = shrd.getInt("selectedMonth",1);
            selectedYear = shrd.getInt("selectedYear",2030);

            cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, selectedYear);
            cal.set(Calendar.DAY_OF_MONTH, selectedDay);
            switch (selectedMonth) {
                case 1:
                    cal.set(Calendar.MONTH, Calendar.JANUARY);
                    break;
                case 2:
                    cal.set(Calendar.MONTH, Calendar.FEBRUARY);
                    break;
                case 3:
                    cal.set(Calendar.MONTH, Calendar.MARCH);
                    break;
                case 4:
                    cal.set(Calendar.MONTH, Calendar.APRIL);
                    break;
                case 5:
                    cal.set(Calendar.MONTH, Calendar.MAY);
                    break;
                case 6:
                    cal.set(Calendar.MONTH, Calendar.JUNE);
                    break;
                case 7:
                    cal.set(Calendar.MONTH, Calendar.JULY);
                    break;
                case 8:
                    cal.set(Calendar.MONTH, Calendar.AUGUST);
                    break;
                case 9:
                    cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
                    break;
                case 10:
                    cal.set(Calendar.MONTH, Calendar.OCTOBER);
                    break;
                case 11:
                    cal.set(Calendar.MONTH, Calendar.NOVEMBER);
                    break;
                case 12:
                    cal.set(Calendar.MONTH, Calendar.DECEMBER);
                    break;
            }
            today = Calendar.getInstance();

            //calender_for_begining_of_pregnancy
            notifyCal = Calendar.getInstance();


            long newDiff = cal.getTimeInMillis() - today.getTimeInMillis();
            diff_weeks = (int) (newDiff / (WEEK_INTERVAL));
            weeeeeeeeks = 40 - diff_weeks;

            if (weeeeeeeeks > 0) {

                //set the calender to the first coming week
                notifyCal.set(Calendar.DAY_OF_YEAR,(cal.get(Calendar.DAY_OF_YEAR)-(diff_weeks*7)));
                notifyCal.set(Calendar.HOUR_OF_DAY,12);
                notifyCal.set(Calendar.MINUTE,0);

                notifyIntent = new Intent(context, AlarmReciever.class);
                //           notifyIntent.setAction(ACTION_NEW_WEEK);
                notifyIntent.putExtra("weeeeeeeeks",weeeeeeeeks);
                alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
                pendingIntent = PendingIntent.getBroadcast(context, weeeeeeeeks, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, notifyCal.getTimeInMillis(), 2*24*60*60*1000, pendingIntent);

            }
        }

    }
}

