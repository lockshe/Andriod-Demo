package com.bytedance.i18n.daydayup.day2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.i18n.daydayup.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Params> paramsList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        paramsList = new ArrayList<>();
        paramsList.add(new Params(R.drawable.jojo1, R.string.jojo1, R.string.score1));
        paramsList.add(new Params(R.drawable.jojo2, R.string.jojo2, R.string.score2));
        paramsList.add(new Params(R.drawable.jojo3, R.string.jojo3, R.string.score3));
        adapter = new MyAdapter(paramsList);
        recyclerView.setAdapter(adapter);
    }
}
