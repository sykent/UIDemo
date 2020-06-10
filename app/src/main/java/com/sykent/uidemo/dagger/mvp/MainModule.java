package com.sykent.uidemo.dagger.mvp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

//    private final MainView mView;
//
//    public MainModule(MainView mView) {
//        this.mView = mView;
//    }

    @Singleton
    @Provides
    MainPresenter provideMainView(MainView mView) {
        return new MainPresenter(mView);
    }

//    @Singleton
    @Provides
    UsePresenter provideUserPresenter(MainPresenter presenter){
        return new UsePresenter(presenter);
    }

}
