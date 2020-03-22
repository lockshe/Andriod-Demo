package com.bytedance.i18n.daydayup.day3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.i18n.daydayup.R;
import com.bytedance.i18n.daydayup.day2.MovieInfoView;
import com.bytedance.i18n.daydayup.day2.Params;

import java.util.List;

public class MultiLayoutAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int FIRST_LAYOUT = 1;
    private static final int SECOND_LAYOUT = 2;
    private static final int THIRD_LAYOUT = 3;

    private List<Params> paramsList;


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private MovieInfoView movieInfoView;

        public MyViewHolder(View v){
            super(v);
            movieInfoView = (MovieInfoView)v;
        }
    }

    public static class SecondViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private ImageView imageView2;
        private ImageView imageView3;


        public SecondViewHolder(View v){
            super(v);
            imageView = v.findViewById(R.id.sec_lay_img);
            imageView2 = v.findViewById(R.id.sec_lay_img2);
            imageView3 = v.findViewById(R.id.sec_lay_img3);
        }

        public void bindData(Params params){
            imageView.setImageResource(params.getImgSrc());
            imageView2.setImageResource(params.getImgSrc());
            imageView3.setImageResource(params.getImgSrc());
        }
    }


    public static class ThridViewHolder extends RecyclerView.ViewHolder{

        public ThridViewHolder(View v){
            super(v);
        }

    }

    public MultiLayoutAdapter(List<Params> list){
        this.paramsList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View v;
        RecyclerView.ViewHolder vh;
        switch (viewType){
            case FIRST_LAYOUT:
                v = new MovieInfoView(parent.getContext());
                vh = new MyViewHolder(v);
                return vh;
            case SECOND_LAYOUT:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_second_view, parent, false);
                vh = new SecondViewHolder(v);
                return vh;
            default:
                return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof MyViewHolder){
            ((MyViewHolder)holder).movieInfoView.bindData(paramsList.get(position), position);
        }else if (holder instanceof  SecondViewHolder) {
            SecondViewHolder secondViewHolder = (SecondViewHolder) holder;
            secondViewHolder.bindData(paramsList.get(position));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MultiLayoutActivity.getContext(),"you are in the position " + position + " now", Toast.LENGTH_SHORT).show();
                removeData(position);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                addData(position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return paramsList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position <= 2){
            return FIRST_LAYOUT;
        }else {
            return SECOND_LAYOUT;
        }
    }

    public void addData(int position) {
        paramsList.add(new Params(R.drawable.jojo6, R.string.jojo6, R.string.score6));
        notifyItemInserted(position);
    }

    public void removeData(int position) {
        paramsList.remove(position);
        notifyItemRemoved(position);
    }

    public void updateData(int position){

    }

}
