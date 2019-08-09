package com.sykent.uidemo.tabpage;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.sykent.framework.activity.BaseActivity;
import com.sykent.uidemo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author Sykent.Lao e-mail:sykent.lao@gmail.com blog:https://sykent.github.io/
 * @version 1.0
 * @since 2019/08/08
 */
public class TabViewPageActivity extends BaseActivity {

    @BindView(R.id.tbl_local)
    TabLayout mTabLayout;
    @BindView(R.id.vp_local)
    ViewPager mViewPager;

    @Override
    public void initView() {
        super.initView();
        // 设置标题
        ((TextView) findViewById(R.id.normal_title_caption)).setText("view_page 联动");

        setupViewPager(mViewPager);
        // 设置ViewPager的数据等
        mTabLayout.setupWithViewPager(mViewPager);

        LocalTabItem localUsed = new LocalTabItem(this, R.string.local_tab_item_used);
        TabLayout.Tab localUsedTab = mTabLayout.getTabAt(0);
        localUsedTab.setCustomView(localUsed);
        localUsed.setSelected(true);

        LocalTabItem localDownload = new LocalTabItem(this, R.string.local_tab_item_download);
        TabLayout.Tab localDownloadTab = mTabLayout.getTabAt(1);
        localDownloadTab.setCustomView(localDownload);

        LocalTabItem localDownload2 = new LocalTabItem(this, R.string.local_tab_item_download);
        TabLayout.Tab localDownloadTab2 = mTabLayout.getTabAt(2);
        localDownloadTab2.setCustomView(localDownload2);

        LocalTabItem localDownload3 = new LocalTabItem(this, R.string.local_tab_item_download);
        TabLayout.Tab localDownloadTab3 = mTabLayout.getTabAt(3);
        localDownloadTab3.setCustomView(localDownload3);

        initListener();
    }

    private void initListener() {
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                LocalTabItem localTabItem = (LocalTabItem) tab.getCustomView();
                if (localTabItem != null) {
                    localTabItem.setSelected(true);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                LocalTabItem localTabItem = (LocalTabItem) tab.getCustomView();
                if (localTabItem != null) {
                    localTabItem.setSelected(false);
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        List<String> tabList = new ArrayList<>();
        tabList.add("Tab1");
        tabList.add("Tab2");
        tabList.add("Tab3");
        tabList.add("Tab4");
        adapter.setData(tabList);

        viewPager.setAdapter(adapter);
    }

    @Override
    public int provideContentViewLayoutResID() {
        return R.layout.activity_local_tab_layout;
    }

    @Override
    public int provideTitleViewLayoutResID() {
        return R.layout.normal_title;
    }
}
