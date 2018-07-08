package com.twins.virtualmirror.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by anshumanpattnaik on 11/07/16.
 */
public class CustomTextViewBold extends TextView {

    public CustomTextViewBold(Context context, AttributeSet attrs,
                              int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public CustomTextViewBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomTextViewBold(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/Aller_Bd.ttf");
        setTypeface(tf, Typeface.BOLD);
    }
}