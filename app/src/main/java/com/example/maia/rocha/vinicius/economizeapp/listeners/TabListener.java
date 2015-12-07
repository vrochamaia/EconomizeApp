package com.example.maia.rocha.vinicius.economizeapp.listeners;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;

import com.example.maia.rocha.vinicius.economizeapp.R;

/**
 * Created by vinicius on 04/08/15.
 */
public class TabListener implements ActionBar.TabListener {

    private Fragment fragment;

    public TabListener(Fragment fragment) {
        this.fragment = fragment;

    }
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

        ft.replace(R.id.fragment_container,fragment);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        ft.remove(fragment);
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
