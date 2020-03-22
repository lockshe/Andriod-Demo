package com.bytedance.i18n.daydayup.day4;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import java.util.UUID;

public class DetailsActivity extends SingleFragmentActivity {

    public static final String EXTRA_JOJO_ID = "yangziji@bytedance.com";

    @Override
    protected Fragment createFragment() {
        return new DetailsFragment();
    }

    public static Intent newIntent(Context context, UUID jojoId){
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(EXTRA_JOJO_ID, jojoId);
        return intent;
    }
}
