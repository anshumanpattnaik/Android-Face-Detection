package com.twins.virtualmirror.fragment;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.twins.virtualmirror.R;
import com.twins.virtualmirror.adapter.GlassAdapter;
import com.twins.virtualmirror.adapter.MustacheAdapter;

import java.util.ArrayList;

public class MustacheFragment extends Fragment {

    private GridView mMustacheGridView;
    private Button mClearButton;

    private MustacheAdapter mAdapter;

    private ArrayList<Drawable> mDrawables;

    public MustacheFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mustache, container, false);

        mMustacheGridView = (GridView) view.findViewById(R.id.mustache_grid);
        mClearButton = (Button) view.findViewById(R.id.clear_btn);

        mDrawables = new ArrayList<Drawable>();

        Drawable mustacheDrawable1 = getActivity().getResources().getDrawable(R.drawable.mustache_one);
        Drawable mustacheDrawable2 = getActivity().getResources().getDrawable(R.drawable.mustache_two);
        Drawable mustacheDrawable3 = getActivity().getResources().getDrawable(R.drawable.mustache_three);
        Drawable mustacheDrawable4 = getActivity().getResources().getDrawable(R.drawable.mustache_four);
        Drawable mustacheDrawable5 = getActivity().getResources().getDrawable(R.drawable.mustache_five);
        Drawable mustacheDrawable6 = getActivity().getResources().getDrawable(R.drawable.mustache_six);
        Drawable mustacheDrawable7 = getActivity().getResources().getDrawable(R.drawable.mustache_seven);
        Drawable mustacheDrawable8 = getActivity().getResources().getDrawable(R.drawable.mustache_eight);
        Drawable mustacheDrawable9 = getActivity().getResources().getDrawable(R.drawable.mustache_nine);
        Drawable mustacheDrawable10 = getActivity().getResources().getDrawable(R.drawable.mustache_ten);

        mDrawables.add(mustacheDrawable1);
        mDrawables.add(mustacheDrawable2);
        mDrawables.add(mustacheDrawable3);
        mDrawables.add(mustacheDrawable4);
        mDrawables.add(mustacheDrawable5);
        mDrawables.add(mustacheDrawable6);
        mDrawables.add(mustacheDrawable7);
        mDrawables.add(mustacheDrawable8);
        mDrawables.add(mustacheDrawable9);
        mDrawables.add(mustacheDrawable10);

        mAdapter = new MustacheAdapter(getActivity(), mDrawables);
        mMustacheGridView.setAdapter(mAdapter);

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());

        mMustacheGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("mustacheposition", i);
                editor.putString("mustachetype", "mustache");
                editor.commit();
            }
        });

        mClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("mustacheposition", 0);
                editor.putString("mustachetype", "");
                editor.commit();
            }
        });

        return view;
    }
}