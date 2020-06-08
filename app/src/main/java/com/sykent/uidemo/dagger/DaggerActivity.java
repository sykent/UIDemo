package com.sykent.uidemo.dagger;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.sykent.framework.activity.BaseActivity;
import com.sykent.uidemo.R;
import com.sykent.uidemo.dagger.mvp.DaggerMainComponent;
import com.sykent.uidemo.dagger.mvp.MainPresenter;
import com.sykent.uidemo.dagger.mvp.MainView;

import javax.inject.Inject;

import butterknife.BindView;

public class DaggerActivity extends BaseActivity implements MainView {
    @BindView(R.id.tv_dagger)
    TextView mDagger;

    //    @Inject
//    Car mCar;
//
//    @Inject
//    MainPresenter mPresenter;

    @Override
    public void initView() {
        super.initView();
        // 设置标题
        ((TextView) findViewById(R.id.normal_title_caption)).setText("Dagger TEST");
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState, Intent intent) {
        super.initData(savedInstanceState, intent);
//        mCar = new Car();
//        MainComponent mainComponent= DaggerMainComponent.create();
//        mainComponent.inject(this);
//
//        DaggerMainComponent.builder().mainModule();
//        mDagger.setText(mCar.toString());
    }

    @Override
    public int provideContentViewLayoutResID() {
        return R.layout.activity_dagger;
    }

    @Override
    public int provideTitleViewLayoutResID() {
        return R.layout.normal_title;
    }

    @Override
    public void updateUI() {

    }
}
