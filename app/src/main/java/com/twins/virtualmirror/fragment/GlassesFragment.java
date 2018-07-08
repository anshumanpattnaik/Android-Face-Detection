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

import com.google.android.gms.vision.Tracker;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;
import com.twins.virtualmirror.R;
import com.twins.virtualmirror.activity.HomeActivity;
import com.twins.virtualmirror.adapter.GlassAdapter;
import com.twins.virtualmirror.applications.Applications;
import com.twins.virtualmirror.camera.GraphicOverlay;
import com.twins.virtualmirror.facetracker.FaceGraphic;

import java.util.ArrayList;

public class GlassesFragment extends Fragment {

    private GridView mGlassesGridView;
    private Button mClearButton;

    private GlassAdapter mAdapter;

    private ArrayList<Drawable> mDrawables;

    private static Drawable mDrawable;

    public GlassesFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_glasses, container, false);

        mGlassesGridView = (GridView) view.findViewById(R.id.glass_grid);
        mClearButton = (Button) view.findViewById(R.id.clear_btn);

        mDrawables = new ArrayList<Drawable>();

        Drawable glassDrawable1 = getActivity().getResources().getDrawable(R.drawable.ray_ban_one);
        Drawable glassDrawable2 = getActivity().getResources().getDrawable(R.drawable.ray_ban_two);
        Drawable glassDrawable3 = getActivity().getResources().getDrawable(R.drawable.ray_ban_three);
        Drawable glassDrawable4 = getActivity().getResources().getDrawable(R.drawable.ray_ban_four);
        Drawable glassDrawable5 = getActivity().getResources().getDrawable(R.drawable.ray_ban_five);
        Drawable glassDrawable6 = getActivity().getResources().getDrawable(R.drawable.ray_ban_six);
        Drawable glassDrawable7 = getActivity().getResources().getDrawable(R.drawable.ray_ban_seven);
        Drawable glassDrawable8 = getActivity().getResources().getDrawable(R.drawable.ray_ban_eight);
        Drawable glassDrawable9 = getActivity().getResources().getDrawable(R.drawable.ray_ban_nine);
        Drawable glassDrawable10 = getActivity().getResources().getDrawable(R.drawable.ray_ban_ten);

        mDrawable = glassDrawable1;

        mDrawables.add(glassDrawable1);
        mDrawables.add(glassDrawable2);
        mDrawables.add(glassDrawable3);
        mDrawables.add(glassDrawable4);
        mDrawables.add(glassDrawable5);
        mDrawables.add(glassDrawable6);
        mDrawables.add(glassDrawable7);
        mDrawables.add(glassDrawable8);
        mDrawables.add(glassDrawable9);
        mDrawables.add(glassDrawable10);

        mAdapter = new GlassAdapter(getActivity(), mDrawables);
        mGlassesGridView.setAdapter(mAdapter);

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());

        mGlassesGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("glassposition", i);
                editor.putString("glasstype", "glass");
                editor.commit();
            }
        });

        mClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("glassposition", 0);
                editor.putString("glasstype", "");
                editor.commit();
            }
        });

        return view;
    }
}