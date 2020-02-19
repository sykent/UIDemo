package com.sykent.uidemo.xfermode;

import android.widget.TextView;

import com.sykent.framework.activity.BaseActivity;
import com.sykent.uidemo.R;

/**
 * @author Sykent.Lao e-mail:sykent.lao@gmail.com blog:https://sykent.github.io/
 * @version 1.0
 * @since 2019/11/18
 */
public class XFermodeActivity extends BaseActivity {
    @Override
    public void initView() {
        super.initView();
        // 设置标题
        ((TextView) findViewById(R.id.normal_title_caption)).setText("XFermode 测试");

    }

    @Override
    public int provideContentViewLayoutResID() {
        return R.layout.activity_xfermode_layout;
    }

    @Override
    public int provideTitleViewLayoutResID() {
        return R.layout.normal_title;
    }
}
