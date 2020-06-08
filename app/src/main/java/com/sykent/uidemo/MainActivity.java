package com.sykent.uidemo;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sykent.framework.activity.BaseActivity;
import com.sykent.ipc.Book;
import com.sykent.uidemo.activity.EventTouchTestActivity;
import com.sykent.uidemo.dagger.DaggerActivity;
import com.sykent.uidemo.fragment.TestFragmentActivity;
import com.sykent.uidemo.greendao.GreenDaoActivity;
import com.sykent.uidemo.main.MainItemData;
import com.sykent.uidemo.main.MainPageAdapter;
import com.sykent.uidemo.main.SpaceItemDecoration;
import com.sykent.uidemo.service.TestService;
import com.sykent.uidemo.service.TestService2;
import com.sykent.uidemo.tabpage.TabViewPageActivity;
import com.sykent.uidemo.xfermode.XFermodeActivity;
import com.sykent.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.ll_root)
    LinearLayout mRoot;
    @BindView(R.id.main_page_rv)
    RecyclerView mRecyclerView;

    Book aa = new Book(3, "jkf");

    private MainPageAdapter mMainPageAdapter;

    private GridLayoutManager mGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initListener();
        Handler handler = new Handler(Looper.getMainLooper());
//        handler.postDelayed(this::addWindowView, 100);
    }

    @Override
    public void preInitView() {
        permissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE});
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState, Intent intent) {
        super.initData(savedInstanceState, intent);

        List<MainItemData> datas = new ArrayList<>();
        datas.add(new MainItemData("事件分发"));
        datas.add(new MainItemData("TabLayout ViewPager"));
        datas.add(new MainItemData("XFermode 测试"));
        datas.add(new MainItemData("绑定服务"));
        datas.add(new MainItemData("GreenDao"));
        datas.add(new MainItemData("Fragment"));
        datas.add(new MainItemData("Dagger"));
        datas.add(new MainItemData("探索Demo"));

        int spanCount = 3;
        mGridLayoutManager = new GridLayoutManager(this, spanCount);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        int itemSpace = Utils.getRealPixel(10);
        mRecyclerView.setPadding(itemSpace, itemSpace, 0, 0);
        mRecyclerView.addItemDecoration(new SpaceItemDecoration(itemSpace));

        mMainPageAdapter = new MainPageAdapter(this, itemSpace, spanCount);
        mMainPageAdapter.setItemDatas(datas);
        mRecyclerView.setAdapter(mMainPageAdapter);
        mMainPageAdapter.setItemClickListener(new MainPageAdapter.OnItemClickListener() {
            @Override
            public void onClickItem(int position) {
                jumpPage(position);
            }
        });
    }

    Intent intentService = null;

    private void jumpPage(int position) {
        switch (position) {
            case 0:
                Intent intent = new Intent(this, EventTouchTestActivity.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(this, TabViewPageActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(this, XFermodeActivity.class);
                startActivity(intent);
                break;
            case 3:
//                try {
//                    Thread.sleep(30000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(7000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Intent intentService = new Intent(MainActivity.this, TestService.class);
                        startService(intentService);
//                        startForegroundService(intentService);

//                        intentService = new Intent(MainActivity.this, TestService2.class);
////                        startForegroundService(intentService);
//                        startService(intentService);
                    }
                }).start();

//                bindService(intentService, mServiceConnection, Context.BIND_AUTO_CREATE);
                break;

            case 4:
                intent = new Intent(this, GreenDaoActivity.class);
                startActivity(intent);
                break;
            case 5:
                intent = new Intent(this, TestFragmentActivity.class);
                startActivity(intent);
                break;
            case 6:
                intent = new Intent(this, DaggerActivity.class);
                startActivity(intent);
                break;
            default:
        }
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    public int provideContentViewLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    public int provideTitleViewLayoutResID() {
        return R.layout.main_titile;
    }

    private void initListener() {

    }
}
