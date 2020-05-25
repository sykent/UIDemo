package com.sykent.uidemo.xfermode;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

import androidx.annotation.Nullable;

import com.sykent.imagedecode.BitmapHelper;
import com.sykent.imagedecode.EBitmapFactory;
import com.sykent.imagedecode.core.ImageScaleType;
import com.sykent.imagedecode.core.ImageSize;
import com.sykent.uidemo.R;

/**
 * @author Sykent.Lao e-mail:sykent.lao@gmail.com blog:https://sykent.github.io/
 * @version 1.0
 * @since 2019/11/18
 */
public class XFermodeView extends View {
    private Bitmap mBmp;
    private Paint mRoundCornerPaint = new Paint();
    private PorterDuffXfermode mRoundCornerMode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    private RectF mRoundRect = new RectF();
    private Scroller mScroller;

    public XFermodeView(Context context) {
        super(context);
        init();
    }

    public XFermodeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void init() {
        mScroller = new Scroller(getContext());
        this.setOnTouchListener(
                new OnTouchListener() {
                    float lastX = 0;

                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                if (!mScroller.isFinished()) {
                                    mScroller.abortAnimation();
                                }
                                lastX = event.getX();
                                break;

                            case MotionEvent.ACTION_MOVE:
                                int dx = (int) (event.getX() - lastX);
//                                mScroller.startScroll(getScrollX(),
//                                        mScroller.getStartY(), -dx, 0);
                                XFermodeView.this.scrollBy(-dx, 0);
                                lastX = event.getX();
                                postInvalidate();
//                                Log.d("scrolltest", "mScrollX: " + getScrollX() + "  dx: " + dx);
                                break;
                            case MotionEvent.ACTION_UP:
                                smoothScrollTo(0, 0);
                                break;
                        }
                        return true;
                    }
                }
        );
    }

    private void smoothScrollTo(int destX, int destY) {
        int scrollX = getScrollX();
        int dx = destX - scrollX;
        mScroller.startScroll(scrollX, 0, dx, 0, 1000);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getStartY());
            postInvalidate();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (BitmapHelper.isInvalid(mBmp)) {
            mBmp = EBitmapFactory.decodeResource(getContext(), R.drawable.test
                    , new ImageSize(getWidth() + 100, getHeight()), ImageScaleType.FIT_XY);
        }

        mRoundRect.set(getLeft(), 0, mBmp.getWidth(), getHeight());
        int layerCount = canvas.saveLayer(mRoundRect, mRoundCornerPaint, Canvas.ALL_SAVE_FLAG);

        int scrollX = getScrollX();
        canvas.clipRect(20, 0, mBmp.getWidth(), getHeight());
        Log.d("scrolltest", "mScrollX: " + getScrollX());

        Bitmap bitmap = Bitmap.createBitmap((int) mRoundRect.width(),
                (int) mRoundRect.height(), Bitmap.Config.ARGB_8888);
        Canvas canvas1 = new Canvas(bitmap);
        mRoundCornerPaint.setColor(Color.BLACK);
        mRoundCornerPaint.setStyle(Paint.Style.FILL);
        canvas1.drawRoundRect(mRoundRect, 50, 50, mRoundCornerPaint);

        canvas.drawBitmap(mBmp, 0, 0, null);
        mRoundCornerPaint.setXfermode(mRoundCornerMode);
        canvas.drawBitmap(bitmap, 0, 0, mRoundCornerPaint);
        mRoundCornerPaint.setXfermode(null);
        canvas.restoreToCount(layerCount);
    }

}
