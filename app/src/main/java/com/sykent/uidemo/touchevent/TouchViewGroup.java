package com.sykent.uidemo.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * @author Sykent.Lao e-mail:sykent.lao@gmail.com blog:https://sykent.github.io/
 * @version 1.0
 * @since 2019/08/06
 */
public class TouchViewGroup extends RelativeLayout {
    public TouchViewGroup(Context context) {
        super(context);
    }

    public TouchViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("touch", "TouchViewGroup:onInterceptTouchEvent MotionEvent.ACTION_DOWN");
                return super.onInterceptTouchEvent(event);
//                return  true;

            case MotionEvent.ACTION_MOVE:
                Log.d("touch", "TouchViewGroup:onInterceptTouchEvent MotionEvent.ACTION_MOVE");
//                return true;
                return super.onInterceptTouchEvent(event);

            case MotionEvent.ACTION_UP:
                Log.d("touch", "TouchViewGroup:onInterceptTouchEvent MotionEvent.ACTION_UP");
                return super.onInterceptTouchEvent(event);

            default:
                Log.d("touch", "TouchViewGroup:onInterceptTouchEvent MotionEvent.default");
                return super.onInterceptTouchEvent(event);
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("touch", "TouchViewGroup:dispatchTouchEvent MotionEvent.ACTION_DOWN");
                return super.dispatchTouchEvent(event);

            case MotionEvent.ACTION_MOVE:
                Log.d("touch", "TouchViewGroup:dispatchTouchEvent MotionEvent.ACTION_MOVE");
                return super.dispatchTouchEvent(event);

            case MotionEvent.ACTION_UP:
                Log.d("touch", "TouchViewGroup:dispatchTouchEvent MotionEvent.ACTION_UP");
                return super.dispatchTouchEvent(event);

            default:
                Log.d("touch", "TouchViewGroup:dispatchTouchEvent MotionEvent.default");
                return super.dispatchTouchEvent(event);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("touch", "TouchViewGroup:onTouchEvent MotionEvent.ACTION_DOWN");
//                return super.onTouchEvent(event);
                return true;

            case MotionEvent.ACTION_MOVE:
                Log.d("touch", "TouchViewGroup:onTouchEvent MotionEvent.ACTION_MOVE");
                return super.onTouchEvent(event);

            case MotionEvent.ACTION_UP:
                Log.d("touch", "TouchViewGroup:onTouchEvent MotionEvent.ACTION_UP");
                return super.onTouchEvent(event);

            default:
                Log.d("touch", "TouchViewGroup:onTouchEvent MotionEvent.default");
                return super.onTouchEvent(event);
        }
    }
}
