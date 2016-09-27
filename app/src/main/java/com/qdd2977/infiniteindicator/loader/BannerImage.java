package com.qdd2977.infiniteindicator.loader;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by lianjia on 2016/9/27.
 */
public class BannerImage implements ImageLoader {
    @Override
    public void initLoader(Context context) {

    }

    @Override
    public void load(Context context, ImageView targetView, Object res) {
        if (res instanceof Integer){
            targetView.setImageResource((Integer) res);
        }
    }
}
