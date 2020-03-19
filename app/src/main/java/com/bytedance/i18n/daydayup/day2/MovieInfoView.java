package com.bytedance.i18n.daydayup.day2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bytedance.i18n.daydayup.R;

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
        inflate(context, R.layout.activity_rel, this);
        coverView = findViewById(R.id.img1);
        movieName = findViewById(R.id.text1);
        movieScore = findViewById(R.id.score1);

    }

    public void bindData(Params params) {
        coverView.setImageResource(params.getImgSrc());
        movieName.setText(params.getTitleText());
        movieScore.setText(params.getScoreText());
    }

}
