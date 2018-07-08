package com.twins.virtualmirror.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.twins.virtualmirror.fragment.GlassesFragment;
import com.twins.virtualmirror.fragment.MustacheFragment;

/**
 * Created by anshumanpattnaik on 19/08/16.
 */
public class ItemAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public ItemAdapter(Context mContext, FragmentManager fm) {
        super(fm);
        this.mContext = mContext;
    }

    @Override
    public Fragment getItem(int index) {
        switch (index) {
            case 0:
                return new GlassesFragment();
            case 1:
                return new MustacheFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return "GLASSES";
            case 1:
                return "MOUSTACHE";
            default:
                break;
        }
        return "";
    }
}