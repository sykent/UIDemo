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
public class TouchView1 extends AppCompatTextView {

    public TouchView1(Context context) {
        super(context);
    }

    public TouchView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("touch", "TouchView1:dispatchTouchEvent MotionEvent.ACTION_DOWN");
//                return true;
                return super.dispatchTouchEvent(event);

            case MotionEvent.ACTION_MOVE:
                Log.d("touch", "TouchView1:dispatchTouchEvent MotionEvent.ACTION_MOVE");
                return super.dispatchTouchEvent(event);

            case MotionEvent.ACTION_UP:
                Log.d("touch", "TouchView1:dispatchTouchEvent MotionEvent.ACTION_UP");
                return super.dispatchTouchEvent(event);

            default:
                Log.d("touch","TouchView1:dispatchTouchEvent MotionEvent.default");
                return super.dispatchTouchEvent(event);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("touch", "TouchView1:onTouchEvent MotionEvent.ACTION_DOWN");
                return super.onTouchEvent(event);

            case MotionEvent.ACTION_MOVE:
                Log.d("touch", "TouchView1:onTouchEvent MotionEvent.ACTION_MOVE");
                return super.onTouchEvent(event);

            case MotionEvent.ACTION_UP:
                Log.d("touch", "TouchView1:onTouchEvent MotionEvent.ACTION_UP");
                return super.onTouchEvent(event);

            default:
                Log.d("touch","TouchView1:onTouchEvent MotionEvent.default");
                return super.onTouchEvent(event);
        }
    }
}
