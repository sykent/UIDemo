package com.sykent.uidemo.greendao;

import android.widget.TextView;

import com.sykent.framework.activity.BaseActivity;
import com.sykent.uidemo.R;

/**
 * @author Sykent.Lao e-mail:sykent.lao@gmail.com blog:https://sykent.github.io/
 * @version 1.0
 * @since 2020/02/19
 */
public class GreenDaoActivity extends BaseActivity {
    @Override
    public void initView() {
        super.initView();
        // 设置标题
        ((TextView) findViewById(R.id.normal_title_caption)).setText("数据库");
    }

    @Override
    public int provideContentViewLayoutResID() {
        return R.layout.activity_green_dao;
    }

    @Override
    public int provideTitleViewLayoutResID() {
        return R.layout.normal_title;
    }
}
