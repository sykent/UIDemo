package com.sykent.uidemo.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.sykent.uidemo.R;

/**
 * @author Sykent.Lao e-mail:sykent.lao@gmail.com blog:https://sykent.github.io/
 * @version 1.0
 * @since 2019/12/24
 */
public class TestService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("TestService", "onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("TestService", "onStartCommand()");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            setForegroundService();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void setForegroundService() {
        String channelId = "666666";
        NotificationChannel notificationChannel = new NotificationChannel(channelId, "简拼", NotificationManager.IMPORTANCE_DEFAULT);
        Notification notification = new NotificationCompat.Builder(this.getApplicationContext(), channelId)
                .setContentText("简拼 正在后台运行")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setAutoCancel(true)
                .setWhen(System.currentTimeMillis())
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }

        startForeground(99999, notification);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("TestService", "onBind()");
        return null;
    }


    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("TestService", "onUnbind()");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.d("TestService", "onDestroy()");
        super.onDestroy();
    }
}
