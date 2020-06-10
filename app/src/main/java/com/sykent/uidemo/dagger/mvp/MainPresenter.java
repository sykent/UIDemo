package com.sykent.uidemo.dagger.mvp;

import javax.inject.Inject;

public class MainPresenter {
    private MainView mView;
    
    public MainPresenter(MainView mView) {
        this.mView = mView;
    }

    public void loadData() {
        // ....

        // ....

        mView.updateUI();
    }
}
