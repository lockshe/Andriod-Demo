package com.bytedance.i18n.daydayup;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * @author wangxiaonan
 */
public class MovieInfoView extends RelativeLayout {
    public MovieInfoView(Context context) {
        this(context,null);
    }

    public MovieInfoView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MovieInfoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context,R.layout.layout_movie_item,this);
    }
}
