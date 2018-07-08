package com.twins.virtualmirror.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.twins.virtualmirror.R;

import java.util.ArrayList;

/**
 * Created by anshumanpattnaik on 19/08/16.
 */
public class MustacheAdapter extends BaseAdapter {

    public Context mContext;
    private ViewHolder holder = null;

    private ArrayList<Drawable> mDrawables;

    public MustacheAdapter(Context mContext, ArrayList<Drawable> mDrawables) {
        this.mContext = mContext;
        this.mDrawables = mDrawables;
    }

    @Override
    public int getCount() {
        return mDrawables.size();
    }

    @Override
    public Drawable getItem(int i) {
        return mDrawables.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mDrawables.size();
    }

    private class ViewHolder {
        ImageView itemImageView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        holder = new ViewHolder();

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.adapter_mustache, parent, false);

            holder.itemImageView = (ImageView) convertView.findViewById(R.id.item_icon);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final ViewHolder holder1 = holder;

        holder1.itemImageView.setImageDrawable(mDrawables.get(position));

        return convertView;
    }
}
