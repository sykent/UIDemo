package com.sykent;

import android.app.Application;

import com.sykent.uidemo.dagger.android.ApplicationComponent;
import com.sykent.uidemo.dagger.android.ApplicationGraph;
import com.sykent.uidemo.dagger.android.DaggerApplicationComponent;
import com.sykent.uidemo.dagger.android.DaggerApplicationGraph;
import com.sykent.uidemo.dagger.manual.AppContainer;

public class DemoApplication extends Application {
    public AppContainer mAppContainer;
    public ApplicationGraph applicationGraph = DaggerApplicationGraph.create();
    public ApplicationComponent applicationComponent = DaggerApplicationComponent.create();

    @Override
    public void onCreate() {
        super.onCreate();
        mAppContainer = new AppContainer();
    }
}
