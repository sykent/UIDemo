package com.sykent.uidemo.dagger;

import dagger.Component;

@Component(modules = CarModule.class)
public interface CarComponent {
    void inject(DaggerActivity activity);
}
