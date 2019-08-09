package com.sykent.uidemo.tabpage;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

/**
 * @author Sykent.Lao e-mail:sykent.lao@gmail.com blog:https://sykent.github.io/
 * @version 1.0
 * @since 2019/08/08
 */
class ViewPagerAdapter extends PagerAdapter {
    private Context mContext;
    private SparseArray<TextView> mPages = new SparseArray<>();
    private List<String> mDatas;

    public ViewPagerAdapter(@NonNull Context context) {
        mContext = context;
    }

    public void setData(List<String> tabList) {
        mDatas = tabList;
    }

    @Override
    public int getCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        TextView view;
        if (position < mPages.size()) {
            view = mPages.get(position);
        } else {
            view = new TextView(mContext);
            mPages.append(position, view);
        }

        view.setText(mDatas.get(position));
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        TextView textView = (TextView) object;
        container.removeView(textView);
    }
}
