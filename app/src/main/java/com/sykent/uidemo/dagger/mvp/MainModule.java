package com.sykent.uidemo.dagger.mvp;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private final MainView mView;

    public MainModule(MainView mView) {
        this.mView = mView;
    }

    @Provides
    MainView provideMainView() {
        return mView;
    }
}
