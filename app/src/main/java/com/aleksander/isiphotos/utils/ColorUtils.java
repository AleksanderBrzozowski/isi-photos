package com.aleksander.isiphotos.utils;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.util.TypedValue;

import com.aleksander.isiphotos.R;

/**
 * @author Aleksander
 */

public class ColorUtils {

    @ColorInt
    public static int getThemeAccentColor(@NonNull final Context context) {
        final TypedValue value = new TypedValue();
        context.getTheme().resolveAttribute (R.attr.colorAccent, value, true);
        return value.data;
    }
}
