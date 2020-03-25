package com.bytedance.i18n.daydayup;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bytedance.i18n.daydayup.day1.JOJOActivity;
import com.bytedance.i18n.daydayup.day2.RecycleActivity;
import com.bytedance.i18n.daydayup.day3.MultiLayoutActivity;
import com.bytedance.i18n.daydayup.day3.multitypeDemo.FooActivity;
import com.bytedance.i18n.daydayup.day4.ListActivity;
import com.bytedance.i18n.daydayup.day5.MultiFragActivity;
import com.bytedance.i18n.daydayup.day5.ViewPagerActivity;
import com.bytedance.i18n.daydayup.day7.WeatherActivity;


/**
 * @author wangxiaonan
 */
public class MainActivity extends AppCompatActivity{

    private Button day1Button;
    private Button day2Button;
    private Button day3Button;
    private Button newDemo;
    private Button day4Button;
    private Button day5Button;
    private Button viewPage;
    private Button day7Button;
    //to remember user's dialog choice, initial value is 1
    private int userChoice = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        day1Button = findViewById(R.id.day1Demo);
        day2Button = findViewById(R.id.day2Demo);
        day3Button = findViewById(R.id.day3Demo);
        day4Button = findViewById(R.id.day4Demo);

        newDemo = findViewById(R.id.newDemo);
        day5Button = findViewById(R.id.day5Demo);
        viewPage =  findViewById(R.id.viewPagerDemo);
        day7Button = findViewById(R.id.weather);

        day1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, JOJOActivity.class);
                startActivity(intent);
            }
        });

        day2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, RecycleActivity.class);
                startActivity(intent);
            }
        });

        day3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLayoutDialog();
            }
        });


        newDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, FooActivity.class);
                startActivity(intent);
            }
        });

        day4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

        viewPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ViewPagerActivity.class);
                startActivity(intent);
            }
        });

        day5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MultiFragActivity.class);
                startActivity(intent);
            }
        });

        day7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, WeatherActivity.class);
                startActivity(intent);
            }
        });
    }

    //choose the RecyclerView's layoutManger
    private void showLayoutDialog(){
        final String[] items = {"LinearLayout", "GridLayout", "StaggerGridLayout"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("choose your view's layout");
        builder.setSingleChoiceItems(items, 0,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        userChoice = which;
                    }
                });

        builder.setPositiveButton("Confirm",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       Intent intent = new Intent();
                       intent.putExtra("choice", userChoice);
                       intent.setClass(MainActivity.this, MultiLayoutActivity.class);
                       startActivity(intent);
                    }
                });

        builder.show();
    }
}
