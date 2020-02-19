package com.sykent.uidemo.xfermode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

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

    public XFermodeView(Context context) {
        super(context);
        init();
    }

    public XFermodeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mRoundRect.set(getLeft(), 0, getWidth(), getHeight());
        int layerCount = canvas.saveLayer(mRoundRect, mRoundCornerPaint, Canvas.ALL_SAVE_FLAG);
        if (BitmapHelper.isInvalid(mBmp)) {
            mBmp = EBitmapFactory.decodeResource(getContext(), R.drawable.test
                    , new ImageSize(getWidth(), getHeight()), ImageScaleType.FIT_XY);
        }
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
