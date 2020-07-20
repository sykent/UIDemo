package com.sykent.uidemo.activity;

import android.app.Activity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.sykent.framework.activity.BaseActivity;
import com.sykent.uidemo.R;
import com.sykent.uidemo.databinding.ActivityEventTouchTestBinding;

import butterknife.OnClick;

/**
 * @author Sykent.Lao e-mail:sykent.lao@gmail.com blog:https://sykent.github.io/
 * @version 1.0
 * @since 2019/08/06
 */
public class EventTouchTestActivity extends BaseActivity {

    @Override
    public void initView() {
        super.initView();
        // 设置标题
        ((TextView) findViewById(R.id.normal_title_caption)).setText("事件分发");
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
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("touch", "EventTouchTestActivity:dispatchTouchEvent MotionEvent.ACTION_DOWN");
                return super.dispatchTouchEvent(event);

            case MotionEvent.ACTION_MOVE:
                Log.d("touch", "EventTouchTestActivity:dispatchTouchEvent MotionEvent.ACTION_MOVE");
                return super.dispatchTouchEvent(event);

            case MotionEvent.ACTION_UP:
                Log.d("touch", "EventTouchTestActivity:dispatchTouchEvent MotionEvent.ACTION_UP");
                return super.dispatchTouchEvent(event);

            default:
                Log.d("touch", "EventTouchTestActivity:dispatchTouchEvent MotionEvent.default");
                return super.dispatchTouchEvent(event);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("touch", "EventTouchTestActivity:onTouchEvent MotionEvent.ACTION_DOWN");
                return super.onTouchEvent(event);

            case MotionEvent.ACTION_MOVE:
                Log.d("touch", "EventTouchTestActivity:onTouchEvent MotionEvent.ACTION_MOVE");
                return super.onTouchEvent(event);

            case MotionEvent.ACTION_UP:
                Log.d("touch", "EventTouchTestActivity:onTouchEvent MotionEvent.ACTION_UP");
                return super.onTouchEvent(event);

            default:
                Log.d("touch", "EventTouchTestActivity:onTouchEvent MotionEvent.default");
                return super.onTouchEvent(event);
        }
    }

    ActivityEventTouchTestBinding binding;

    @Override
    public View provideContentView() {
        binding = ActivityEventTouchTestBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    //    @Override
//    public int provideContentViewLayoutResID() {
//        return R.layout.activity_event_touch_test;
//    }

    @Override
    public int provideTitleViewLayoutResID() {
        return R.layout.normal_title;
    }
}
