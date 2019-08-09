package com.sykent.uidemo.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

/**
 * @author Sykent.Lao e-mail:sykent.lao@gmail.com blog:https://sykent.github.io/
 * @version 1.0
 * @since 2019/08/06
 */
public class TouchView2 extends AppCompatTextView {
    public TouchView2(Context context) {
        super(context);
    }

    public TouchView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("touch", "TouchView2:dispatchTouchEvent MotionEvent.ACTION_DOWN");
                return super.dispatchTouchEvent(event);

            case MotionEvent.ACTION_MOVE:
                Log.d("touch", "TouchView2:dispatchTouchEvent MotionEvent.ACTION_MOVE");
                return super.dispatchTouchEvent(event);

            case MotionEvent.ACTION_UP:
                Log.d("touch", "TouchView2:dispatchTouchEvent MotionEvent.ACTION_UP");
                return super.dispatchTouchEvent(event);

            default:
                Log.d("touch", "TouchView2:dispatchTouchEvent MotionEvent.default");
                return super.dispatchTouchEvent(event);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("touch", "TouchView2:onTouchEvent MotionEvent.ACTION_DOWN");
                return true;
//                return super.onTouchEvent(event);

            case MotionEvent.ACTION_MOVE:
                Log.d("touch", "TouchView2:onTouchEvent MotionEvent.ACTION_MOVE");
//                return true;
                return super.onTouchEvent(event);

            case MotionEvent.ACTION_UP:
                Log.d("touch", "TouchView2:onTouchEvent MotionEvent.ACTION_UP");
                return super.onTouchEvent(event);

            default:
                Log.d("touch", "TouchView2:onTouchEvent MotionEvent.default");
                return super.onTouchEvent(event);
        }
    }
}