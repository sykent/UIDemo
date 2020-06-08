package com.sykent.uidemo.dagger;

public class Car {
    Tyre mTyre;

    public Car() {
        mTyre = new Tyre();
    }

    public Tyre getmTyre() {
        return mTyre;
    }

    public void setmTyre(Tyre mTyre) {
        this.mTyre = mTyre;
    }

    @Override
    public String toString() {
        return "Car{" +
                "mTyre=" + mTyre.toString() +
                '}';
    }
}
