package com.myapp.madroid.babycare;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by MaD on 2/8/2018.
 */

public class AlarmReciever extends BroadcastReceiver {

    private static final int NOTIFICATION_ID = 1138;
    /**
     * This pending intent id is used to uniquely reference the pending intent
     */
    private static final int PENDING_INTENT_ID = 3417;
    /**
     * This notification channel id is used to link notifications to this channel
     */
    private static final String NOTIFICATION_CHANNEL_ID = "reminder_notification_channel";


    @Override
    public void onReceive(Context context, Intent intent) {

        /////////////////////////////////////////////////
/*

        int id = intent.getIntExtra("id", 0);

        NotificationCompat.Builder notification;

        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent notificationIntent = new Intent(context, FragActivity.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);


                notification = new NotificationCompat.Builder(context)
                        .setContentTitle("ط°ظژظƒظ‘ظگظ€ط±ظ’ظ†ظگظ€ظٹ")
                        .setContentText("ط§ط°ظƒط§ط± ط§ظ„ط§ط³طھظٹظ‚ط§ط¸")
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                        .setCategory(NotificationCompat.CATEGORY_ALARM)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(bitmap)
                        .setAutoCancel(true)
      //                  .setSound(Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.ringtone))
                        .setVibrate(new long[]{1000, 500, 1000, 500, 1000, 500, 1000 , 500, 1000 , 500, 1000 , 500, 1000 , 500,1000, 500, 1000, 500, 1000, 500})
                        .setContentIntent(PendingIntent.getActivity(context, id, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT));
                //    .build();

                nm.notify(0, notification.build());

*/
        ////////////////////////////////////////////////

        int id = intent.getIntExtra("weeeeeeeeks",1);


        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel(
                    NOTIFICATION_CHANNEL_ID,
                    context.getString(R.string.main_notification_channel_name),
                    NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(mChannel);
        }

        SharedPreferences shrd = PreferenceManager.getDefaultSharedPreferences(context);
        String language = shrd.getString("language","ara") ;


        if (language.equals("eng")){

            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context)
                    .setColor(ContextCompat.getColor(context, R.color.colorPrimary))
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setLargeIcon(largeIcon(context))
                    .setContentTitle(context.getString(R.string.charging_reminder_notification_title))
                    .setContentText((context.getString(R.string.charging_reminder_notification_body)) + id)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText(
                            context.getString(R.string.charging_reminder_notification_body)))
                    .setDefaults(Notification.DEFAULT_VIBRATE)
                    .setContentIntent(contentIntent(context))
                    //    .setSound(Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.ringtone))
                    .setVibrate(new long[]{1000, 500, 1000, 500, 1000, 500, 1000 , 500, 1000})
                    .setAutoCancel(true);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN
                    && Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
                notificationBuilder.setPriority(NotificationCompat.PRIORITY_HIGH);
            }
            notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());


        }else {


            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context)
                    .setColor(ContextCompat.getColor(context, R.color.colorPrimary))
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setLargeIcon(largeIcon(context))
                    .setContentTitle(context.getString(R.string.charging_reminder_notification_titleA))
                    .setContentText((context.getString(R.string.charging_reminder_notification_bodyA))+id)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText(
                            context.getString(R.string.charging_reminder_notification_bodyA)))
                    .setDefaults(Notification.DEFAULT_VIBRATE)
                    .setContentIntent(contentIntent(context))
                    //               .setSound(Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.ringtone))
                    .setVibrate(new long[]{1000, 500, 1000, 500, 1000, 500, 1000 , 500, 1000})
                    .setAutoCancel(true);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN
                    && Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
                notificationBuilder.setPriority(NotificationCompat.PRIORITY_HIGH);
            }
            notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());


        }






    }


    private static PendingIntent contentIntent(Context context) {
        Intent startActivityIntent = new Intent(context, FragActivity.class);
        return PendingIntent.getActivity(
                context,
                PENDING_INTENT_ID,
                startActivityIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
    }

    //make_large_icon_img

    private static Bitmap largeIcon(Context context) {
        Resources res = context.getResources();
        Bitmap largeIcon = BitmapFactory.decodeResource(res, R.mipmap.ic_launcher);
        return largeIcon;
    }


}
