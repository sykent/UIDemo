package com.sykent.uidemo.dagger;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.sykent.framework.activity.BaseActivity;
import com.sykent.uidemo.R;
import com.sykent.uidemo.dagger.mvp.DaggerMainComponent;
import com.sykent.uidemo.dagger.mvp.MainModule;
import com.sykent.uidemo.dagger.mvp.MainPresenter;
import com.sykent.uidemo.dagger.mvp.MainView;
import com.sykent.uidemo.dagger.mvp.UsePresenter;

import javax.inject.Inject;

import butterknife.BindView;

public class DaggerActivity extends BaseActivity implements MainView {
    @BindView(R.id.tv_dagger)
    TextView mDagger;

    // 传参
    @Inject
    MainPresenter mPresenter;
    @Inject
    UsePresenter mUserPresenter;
    @Inject
    SharedPreferences mSharePreference;

    @Override
    public void initView() {
        super.initView();
        // 设置标题
        ((TextView) findViewById(R.id.normal_title_caption)).setText("Dagger TEST");
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState, Intent intent) {
        super.initData(savedInstanceState, intent);
//        CarComponent carComponent = DaggerCarComponent.create();
//        carComponent.inject(this);


        // MainPresenter 的注入
        DaggerMainComponent.builder()
                .setMainView(this)
                .sharedPre(this.getSharedPreferences(
                        "store", Context.MODE_PRIVATE))
                .build().inject(this);
        Log.d("tttt", mPresenter.toString() + "  " + mUserPresenter.toString() + "  mSharePreference: " + mSharePreference.toString());
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
