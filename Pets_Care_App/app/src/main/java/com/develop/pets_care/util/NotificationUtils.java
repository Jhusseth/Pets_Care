package com.develop.pets_care.util;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

import androidx.core.app.NotificationCompat;

import com.develop.pets_care.R;

import java.util.Objects;

public class NotificationUtils {

    public static final String CHANNEL_ID ="ChatAndroid";
    public static final String CHANNEL_NAME = "Messages";
    public static final int CHANNEL_IMPORTANCE = NotificationManager.IMPORTANCE_HIGH;
    public static int consecutive =1;

    public static void createNotification(Context context,String mensaje){
        NotificationManager manager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,CHANNEL_IMPORTANCE);
            Objects.requireNonNull(manager).createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder =  new NotificationCompat.Builder(context,CHANNEL_ID)
                .setContentTitle("Nuevo mensaje")
                .setContentText(mensaje)
                .setSmallIcon(R.mipmap.ic_launcher);
        Objects.requireNonNull(manager).notify(consecutive,builder.build());
        consecutive++;
    }
}
