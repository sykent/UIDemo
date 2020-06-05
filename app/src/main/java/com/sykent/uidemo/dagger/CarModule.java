package com.sykent.uidemo.dagger;

import dagger.Module;
import dagger.Provides;

@Module
public class CarModule {

    @Provides
    public Car getCar() {
        return new Car();
    }
}
