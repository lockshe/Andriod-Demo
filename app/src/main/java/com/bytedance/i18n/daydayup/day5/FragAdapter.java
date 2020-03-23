package com.bytedance.i18n.daydayup.day5;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class FragAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    public FragAdapter(@NonNull FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        fragments = fragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
