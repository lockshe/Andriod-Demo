package com.bytedance.i18n.daydayup.day1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bytedance.i18n.daydayup.R;

public class JOJOPlusActivity extends AppCompatActivity {

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);
        initView();
    }

    private void initView(){
          linearLayout = findViewById(R.id.dynamic);
          for(int i = 1; i<=3; i++){
              linearLayout.addView(initChild(i));
          }
    }

    private View initChild(int index){
        RelativeLayout relativeLayout = new RelativeLayout(this);
        ImageView imageView = new ImageView(this);

        //relativeLayout.setId(R.id.img1);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                120);
        relativeLayout.setLayoutParams(layoutParams);

        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(100, 120);
        layoutParams2.setMargins(20, 30, 0, 10);
        imageView.setLayoutParams(layoutParams2);
        imageView.setImageResource(R.drawable.jojo1);
        relativeLayout.addView(imageView);

        return relativeLayout;
    }
}
