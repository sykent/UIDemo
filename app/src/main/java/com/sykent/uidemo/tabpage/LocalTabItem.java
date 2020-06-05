package com.sykent.uidemo.tabpage;

import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.StringRes;

import com.sykent.utils.Utils;

/**
 * @author Sykent.Lao e-mail:sykent.lao@gmail.com blog:https://sykent.github.io/
 * @version 1.0
 * @since 2019/08/08
 */
public class LocalTabItem extends LinearLayout {
    private TextView mTextView;

    public LocalTabItem(Context context, @StringRes int resid) {
        super(context);
        initView(resid);
        setSelected(false);
    }

    private void initView(@StringRes int resid) {
        setOrientation(VERTICAL);

        LinearLayout.LayoutParams lParams;
        lParams = new LayoutParams(Utils.getRealPixel(150),
                ViewGroup.LayoutParams.WRAP_CONTENT);
        lParams.gravity = Gravity.CENTER;
        mTextView = new TextView(getContext());
        addView(mTextView, lParams);
        mTextView.setGravity(Gravity.CENTER);
//        mTextView.setTextColor(0xffffffff);
        mTextView.setText(resid);
    }

    public void setSelected(boolean isSelected) {
        if (isSelected) {
            mTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 17);
        } else {
            mTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);
        }
        mTextView.getPaint().setFakeBoldText(isSelected);
    }
}
