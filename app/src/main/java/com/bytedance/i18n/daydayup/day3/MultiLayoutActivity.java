package com.bytedance.i18n.daydayup.day3;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bytedance.i18n.daydayup.R;
import com.bytedance.i18n.daydayup.day2.Params;

import java.util.ArrayList;
import java.util.List;

public class MultiLayoutActivity extends AppCompatActivity {

    private static Context context;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Params> paramsList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        context = getApplicationContext();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        int choice = this.getIntent().getIntExtra("choice", 0);
        switch (choice){
            case 0:
                layoutManager = new LinearLayoutManager(this);
                break;
            case 1:
                layoutManager = new GridLayoutManager(this,2);
                break;
            case 2:
                StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                layoutManager = staggeredGridLayoutManager;
                break;
            default:
                break;
        }

        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        initData();
        adapter = new MultiLayoutAdapter(paramsList);
        recyclerView.setAdapter(adapter);
    }


    public void initData(){
        paramsList = new ArrayList<>();
        paramsList.add(new Params(R.drawable.jojo1, R.string.jojo1, R.string.score1));
        paramsList.add(new Params(R.drawable.jojo2, R.string.jojo2, R.string.score2));
        paramsList.add(new Params(R.drawable.jojo3, R.string.jojo3, R.string.score3));
        paramsList.add(new Params(R.drawable.jojo4, R.string.jojo4, R.string.score4));
        paramsList.add(new Params(R.drawable.jojo5, R.string.jojo5, R.string.score5));
        paramsList.add(new Params(R.drawable.jojo6, R.string.jojo6, R.string.score6));
    }


    public static Context getContext(){
        return context;
    }
}
