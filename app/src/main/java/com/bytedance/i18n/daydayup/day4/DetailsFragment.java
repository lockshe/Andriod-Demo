package com.bytedance.i18n.daydayup.day4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bytedance.i18n.daydayup.R;
import com.bytedance.i18n.daydayup.day2.MovieInfoView;
import com.bytedance.i18n.daydayup.day2.Params;
import com.google.gson.Gson;

public class DetailsFragment extends Fragment {

    ImageView imageView;
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        imageView = view.findViewById(R.id.jojoname);
        textView = view.findViewById(R.id.jojotext);
        Params params = new Gson().fromJson(getActivity().getIntent().getStringExtra("params"), Params.class);

        imageView.setImageResource(params.getImgSrc());
        textView.setText(params.getTitleText());
        return view;
    }
}
