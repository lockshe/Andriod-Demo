package com.bytedance.i18n.daydayup.day2;

import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.i18n.daydayup.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Params> paramsList;

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private MovieInfoView movieInfoView;

        public MyViewHolder(MovieInfoView v){
            super(v);
            movieInfoView = v;
        }
    }

    public MyAdapter(List<Params> paramsList){
        this.paramsList = paramsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

//      布局文件根结点是RelativeLayout,因此无法强转
//      MovieInfoView v = (MovieInfoView) LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_rel, parent, false);
        MyViewHolder vh  = new MyViewHolder(new MovieInfoView(parent.getContext()));

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.movieInfoView.bindData(paramsList.get(position));
    }

    @Override
    public int getItemCount() {
        return paramsList.size();
    }

}
