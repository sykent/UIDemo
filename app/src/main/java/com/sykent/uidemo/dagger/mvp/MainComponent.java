package com.sykent.uidemo.dagger.mvp;

import android.content.SharedPreferences;

import com.sykent.uidemo.dagger.DaggerActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = MainModule.class)
public interface MainComponent {

    SharedPreferences getSharedPrefs();

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder setMainView(MainView view);

        @BindsInstance
        Builder sharedPre(SharedPreferences preferences);

        MainComponent build();
    }

    void inject(DaggerActivity activity);
}
