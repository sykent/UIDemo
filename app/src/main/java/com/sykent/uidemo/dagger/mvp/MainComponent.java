package com.sykent.uidemo.dagger.mvp;

import com.sykent.uidemo.dagger.DaggerActivity;

import dagger.Component;

@Component(modules = MainModule.class)
public interface MainComponent {
    void inject(DaggerActivity activity);
}
