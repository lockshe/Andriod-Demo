package com.bytedance.i18n.daydayup.day1;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bytedance.i18n.daydayup.R;

public class JOJOActivity extends AppCompatActivity {

    private Button playButton;
    private View playView1;
    private View playView2;
    private View playView3;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);

        playButton = findViewById(R.id.button1);
        playView1 = findViewById(R.id.view1);
        playView2 = findViewById(R.id.view2);
        playView3 = findViewById(R.id.view3);


        playView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showWarning();
            }
        });

        playView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showWarning();
            }
        });

        playView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showWarning();
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }


    private void showWarning(){
        Toast.makeText(this, R.string.warning, Toast.LENGTH_SHORT).show();
    }


    private void onViewClick(){
        Toast.makeText(this, R.string.warning, Toast.LENGTH_SHORT).show();
    }
}
