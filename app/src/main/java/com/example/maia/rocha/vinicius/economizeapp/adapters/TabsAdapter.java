package com.example.maia.rocha.vinicius.economizeapp.adapters;

import android.app.ActionBar;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.maia.rocha.vinicius.economizeapp.fragments.CentimetroFragment;
import com.example.maia.rocha.vinicius.economizeapp.fragments.GramasFragment;
import com.example.maia.rocha.vinicius.economizeapp.fragments.MililitroFragment;
import com.example.maia.rocha.vinicius.economizeapp.fragments.Tab;

/**
 * Created by vinicius on 04/08/15.
 */
public class TabsAdapter extends FragmentPagerAdapter {


    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "ML", "GM", "CM" };
    private Context context;

    public TabsAdapter(FragmentManager fm,Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = new Fragment();

        switch (position) {

            case 0:
                fragment =  MililitroFragment.newInstance();
                break;

            case 1:
                fragment = GramasFragment.newInstance();
                break;

            case 2:
                fragment = CentimetroFragment.newInstance();
                break;
        }

        return fragment;

    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

}
