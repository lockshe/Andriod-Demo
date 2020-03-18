package com.bytedance.i18n.daydayup;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author wangxiaonan
 */
public class MovieInfoView extends RelativeLayout {

    ImageView coverView;
    TextView movieName;
    TextView movieScore;

    public MovieInfoView(Context context) {
        this(context, null);
    }

    public MovieInfoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MovieInfoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.layout_movie_item, this);
        coverView = findViewById(R.id.iv_cover);
        movieName = findViewById(R.id.tv_name);
        movieScore = findViewById(R.id.tv_score);

    }


    public void bindData(String name, String score) {
        movieName.setText(name);
        movieScore.setText(score);
    }
}
