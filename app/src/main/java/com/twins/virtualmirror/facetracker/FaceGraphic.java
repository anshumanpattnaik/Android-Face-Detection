package com.twins.virtualmirror.facetracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.google.android.gms.vision.face.Face;
import com.twins.virtualmirror.R;
import com.twins.virtualmirror.camera.GraphicOverlay;

public class FaceGraphic extends GraphicOverlay.Graphic {
    private Context mContext;

    private volatile Face mFace;
    private int mFaceId;

    public FaceGraphic(Context mContext, GraphicOverlay overlay) {
        super(overlay);
        this.mContext = mContext;
    }

    public void setId(int id) {
        mFaceId = id;
    }

    public void updateFace(Face face) {
        mFace = face;
        postInvalidate();
    }

    @Override
    public void draw(Canvas canvas) {
        Face face = mFace;
        if (face == null) {
            return;
        }

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        int glasspos = prefs.getInt("glassposition", 0);
        int mustacheposition = prefs.getInt("mustacheposition", 0);

        String glasstype = prefs.getString("glasstype", "");
        String mustachetypetype = prefs.getString("mustachetype", "");

        Log.d("ImagePos", "FacePos :: " + glasspos);

        if (glasstype.contains("glass")) {
            float x = translateX(face.getPosition().x + face.getWidth() / 2);
            float y = translateY(face.getPosition().y + face.getHeight() / 2);

            float xOffset = scaleX(face.getWidth() / 2.5f);
            float yOffset = scaleY(face.getHeight() / 2.5f);
            float left = x - xOffset;
            float top = y - yOffset;
            float right = x + xOffset;
            float bottom = y + yOffset;

            Resources res = mContext.getResources();
            TypedArray icons = res.obtainTypedArray(R.array.glasses);
            Drawable drawable = icons.getDrawable(glasspos);
            drawable.setBounds(Math.round(left), Math.round(top), Math.round(right), Math.round(bottom));
            drawable.draw(canvas);
        }

        if (mustachetypetype.contains("mustache")) {
            float x1 = translateX(face.getPosition().x + face.getWidth() / 2.0f);
            float y1 = translateY(face.getPosition().y + face.getHeight() / 1.25f);

            float xOffset1 = scaleX(face.getWidth() / 3.0f);
            float yOffset1 = scaleY(face.getHeight() / 10.0f);
            float left1 = x1 - xOffset1;
            float top1 = y1 - yOffset1;
            float right1 = x1 + xOffset1;
            float bottom1 = y1 + yOffset1;

            Resources res1 = mContext.getResources();
            TypedArray icons1 = res1.obtainTypedArray(R.array.mustache);
            Drawable drawable1 = icons1.getDrawable(mustacheposition);
            drawable1.setBounds(Math.round(left1), Math.round(top1), Math.round(right1), Math.round(bottom1));
            drawable1.draw(canvas);
        }
    }
}