package com.sykent;

import android.app.Application;

import com.sykent.uidemo.dagger.manual.AppContainer;

public class DemoApplication extends Application {
    public AppContainer mAppContainer;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppContainer = new AppContainer();
    }
}
