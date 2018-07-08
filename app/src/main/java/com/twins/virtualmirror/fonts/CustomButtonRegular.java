package com.twins.virtualmirror.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by anshumanpattnaik on 11/07/16.
 */
public class CustomButtonRegular extends Button {

    public CustomButtonRegular(Context context, AttributeSet attrs,
                               int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public CustomButtonRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomButtonRegular(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/Aller_Rg.ttf");
        setTypeface(tf, Typeface.BOLD);
    }
}