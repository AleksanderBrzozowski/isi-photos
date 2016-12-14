package com.aleksander.isiphotos.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * @author Aleksander
 */

public class SquareHeightImageView extends ImageView {

    public SquareHeightImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredHeight());
    }
}
