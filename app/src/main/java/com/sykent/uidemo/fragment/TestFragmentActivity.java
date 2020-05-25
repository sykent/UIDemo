package com.sykent.uidemo.fragment;

import android.view.View;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.sykent.framework.activity.BaseActivity;
import com.sykent.uidemo.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Sykent.Lao e-mail:sykent.lao@gmail.com blog:https://sykent.github.io/
 * @version 1.0
 * @since 2020/05/24
 */
public class TestFragmentActivity extends BaseActivity {

    @BindView(R.id.frag_container)
    ConstraintLayout mContainer;

    @Override
    public void initView() {
        super.initView();
        // 设置标题
        ((TextView) findViewById(R.id.normal_title_caption)).setText("Fragment");

        getSupportFragmentManager().beginTransaction()
                .add(R.id.frag_container,
                        Fragment1.newInstance("hello world1"), "f1")
                .commit();
    }

    @OnClick({R.id.normal_back_icon})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.normal_back_icon:
                finish();
                break;
        }
    }

    @Override
    public int provideContentViewLayoutResID() {
        return R.layout.activity_test_fragment;
    }

    @Override
    public int provideTitleViewLayoutResID() {
        return R.layout.normal_title;
    }
}
