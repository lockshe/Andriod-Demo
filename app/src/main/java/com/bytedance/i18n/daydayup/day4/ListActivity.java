package com.bytedance.i18n.daydayup.day4;


import androidx.fragment.app.Fragment;

public class ListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new ListFragment();
    }
}
