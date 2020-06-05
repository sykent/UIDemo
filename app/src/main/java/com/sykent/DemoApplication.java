package com.sykent;

import android.app.Application;
import android.content.Intent;

import com.sykent.uidemo.service.TestService;

public class DemoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Intent intentService = new Intent(this, TestService.class);
        startService(intentService);
    }
}
