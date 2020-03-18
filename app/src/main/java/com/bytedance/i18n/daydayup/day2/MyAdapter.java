package com.bytedance.i18n.daydayup.day2;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.i18n.daydayup.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<MyJOJOView> viewList;

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;
        public MyViewHolder(TextView v){
            super(v);
            textView = v;
        }
    }

    public MyAdapter(List<MyJOJOView> viewList){
        this.viewList = viewList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        TextView v = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view, parent, false);
        MyViewHolder vh  = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return viewList.size();
    }

}
