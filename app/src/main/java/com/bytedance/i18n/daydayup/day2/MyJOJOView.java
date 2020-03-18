package com.bytedance.i18n.daydayup.day2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyJOJOView extends RelativeLayout {

    private ImageView imageView;
    private TextView titleTextView;
    private TextView scoreTextView;

    public MyJOJOView(Context context, int imgSrcId, int titleId, int scoreId) {
        super(context);
        initView(imgSrcId, titleId, scoreId);
    }

    public MyJOJOView(Context context) {
        super(context, null);
    }

    public MyJOJOView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public MyJOJOView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private void initView(int imgSrcId, int titleId, int scoreId){
        //init ViewGroup's params
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                120);
        this.setLayoutParams(layoutParams);

        // init the widget
        imageView = new ImageView(getContext());
        titleTextView = new TextView(getContext());
        scoreTextView = new TextView(getContext());

        // init the widgets'params
        RelativeLayout.LayoutParams imgParams = new RelativeLayout.LayoutParams(100, 120);
        RelativeLayout.LayoutParams titleParams = new RelativeLayout.LayoutParams(250,40);
        RelativeLayout.LayoutParams scoreTextView = new RelativeLayout.LayoutParams(250, 20);

        imgParams.setMargins(20, 30, 0, 10);
        imageView.setImageResource(imgSrcId);
        imageView.setLayoutParams(imgParams);

//        titleParams.
//        titleTextView.setText(titleId);
//        scoreTextView.setText(scoreId);
        this.addView(imageView);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }
}
