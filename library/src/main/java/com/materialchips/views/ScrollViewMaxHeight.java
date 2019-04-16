package com.materialchips.views;


import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.materialchips.R;
import com.materialchips.util.ViewUtil;

import androidx.core.widget.NestedScrollView;

public class ScrollViewMaxHeight extends NestedScrollView {

    private int mMaxHeight;
    private int mWidthMeasureSpec;

    // by default is scrollable
    private boolean scrollable = true;

    public ScrollViewMaxHeight(Context context) {
        super(context);
    }

    public ScrollViewMaxHeight(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.ScrollViewMaxHeight,
                0, 0);

        try {
            mMaxHeight = a.getDimensionPixelSize(R.styleable.ScrollViewMaxHeight_maxHeight, ViewUtil.dpToPx(300));
        } finally {
            a.recycle();
        }
    }

    public void setMaxHeight(int height) {
        mMaxHeight = height;
        int heightMeasureSpec = MeasureSpec.makeMeasureSpec(mMaxHeight, MeasureSpec.AT_MOST);
        measure(mWidthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mWidthMeasureSpec = widthMeasureSpec;
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(mMaxHeight, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return scrollable && super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return scrollable && super.onInterceptTouchEvent(ev);
    }

    public void setScrollingEnabled(boolean enabled) {
        scrollable = enabled;
    }

}
