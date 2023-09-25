package com.funix.lab5_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class M000splashFrg extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        initViews();
        View view=inflater.inflate(R.layout.m000_frg_splash,container,false);
        return view;
        //return inflater.inflate(R.layout.m000_frg_splash, container, false);
    }
    private void initViews() {
        new Handler().postDelayed(this::gotoM001Screen, 2000);
    }
    private void gotoM001Screen() {
        ((MainActivity) getActivity()).gotoM001Screen();
    }
}