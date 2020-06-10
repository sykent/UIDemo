package com.sykent.uidemo.dagger.mvp;

/**
 * @author laoshuiqiang
 * @version 1.0
 * @date 2020/6/10 13:54
 */
public class UsePresenter {
    private MainPresenter presenter;

    public UsePresenter(MainPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public String toString() {
        return "UsePresenter{" +
                "presenter=" + presenter.toString() +
                '}';
    }
}
