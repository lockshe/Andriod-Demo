package com.bytedance.i18n.daydayup.day5;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.bytedance.i18n.daydayup.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {

    ViewPager viewPager;
    List<Fragment> fragments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_pager);
        viewPager = findViewById(R.id.frag_view_page);
        initFragment();
        FragAdapter adapter = new FragAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
    }

    private void initFragment(){
        FragmentManager fm = getSupportFragmentManager();
        fragments = new ArrayList<>();
        Fragment homeFrag = new HomeFragment();
        Fragment searchFrg = new SearchFragment();
        Fragment mineFrag = new MineFragment();
        fragments.add(homeFrag);
        fragments.add(searchFrg);
        fragments.add(mineFrag);
    }
}
