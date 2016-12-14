package com.aleksander.isiphotos.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import lombok.Setter;

/**
 * @author Aleksander
 */

@Setter
public class WidthRatioImageView extends ImageView {

    private float ratio = 1;

    public WidthRatioImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), (int)(getMeasuredWidth() * ratio));
    }
}
