package com.bytedance.i18n.daydayup.day5;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bytedance.i18n.daydayup.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MultiFragActivity extends AppCompatActivity {

    private List<Fragment> fragments;
    private BottomNavigationView bottomNavigationView;
    private int lastFragmentId = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.const_layout);
        initFragment();

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
        fm.beginTransaction()
                .replace(R.id.message, homeFrag)
                .show(homeFrag)
                .commit();

        // init the bottom navigation
        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(changeFragment);
    }


    private BottomNavigationView.OnNavigationItemSelectedListener changeFragment = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.navigation_home:
                    if (lastFragmentId != 0){
                        changeFragment(0);
                    }
                    return true;
                case R.id.navigation_search:
                    if (lastFragmentId != 1){
                        changeFragment(1);
                    }
                    return true;
                case R.id.navigation_mine:
                    if (lastFragmentId != 2){
                        changeFragment(2);
                    }
                    return true;
            }

            return false;
        }
    };

    private void changeFragment(int index){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //hide the fragment
        transaction.hide(fragments.get(lastFragmentId));
        if (fragments.get(index).isAdded() == false){
            transaction.replace(R.id.message, fragments.get(index));
        }
        transaction.show(fragments.get(index)).commitAllowingStateLoss();
        lastFragmentId = index;
    }
}
