package com.twins.virtualmirror.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by anshumanpattnaik on 11/07/16.
 */
public class CustomTextViewRegular extends TextView {

    public CustomTextViewRegular(Context context, AttributeSet attrs,
                        int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public CustomTextViewRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomTextViewRegular(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/Aller_Rg.ttf");
        setTypeface(tf);
    }
}