package com.bytedance.i18n.daydayup.day4;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.i18n.daydayup.R;
import com.bytedance.i18n.daydayup.day2.MovieInfoView;
import com.bytedance.i18n.daydayup.day2.Params;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    private RecyclerView recyclerView;
    private ListViewAdapter adapter;
    private List<Params> paramsList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_recycle, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }


    private void updateUI(){
        paramsList = new ArrayList<>();
        paramsList.add(new Params(R.drawable.jojo1, R.string.jojo1, R.string.score1));
        paramsList.add(new Params(R.drawable.jojo2, R.string.jojo2, R.string.score2));
        paramsList.add(new Params(R.drawable.jojo3, R.string.jojo3, R.string.score3));
        paramsList.add(new Params(R.drawable.jojo4, R.string.jojo4, R.string.score4));
        paramsList.add(new Params(R.drawable.jojo5, R.string.jojo5, R.string.score5));
        paramsList.add(new Params(R.drawable.jojo6, R.string.jojo6, R.string.score6));
        adapter = new ListViewAdapter(paramsList);
        recyclerView.setAdapter(adapter);
    }


    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private MovieInfoView movieInfoView;

        public ListViewHolder(View view){
            super(view);
            movieInfoView = (MovieInfoView) view;
            movieInfoView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
//            Toast.makeText(getActivity(), "laban", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getActivity(), DetailsActivity.class);
            startActivity(intent);
        }
    }

    private class ListViewAdapter extends RecyclerView.Adapter<ListViewHolder>{

        private List<Params> paramsList;

        public ListViewAdapter(List<Params> params){
            this.paramsList = params;
        }

        @NonNull
        @Override
        public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            ListViewHolder holder = new ListViewHolder(new MovieInfoView(parent.getContext()));
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
            holder.movieInfoView.bindData(paramsList.get(position));
        }

        @Override
        public int getItemCount() {
            return paramsList.size();
        }
    }
}
