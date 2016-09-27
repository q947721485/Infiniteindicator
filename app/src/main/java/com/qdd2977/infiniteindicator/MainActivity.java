package com.qdd2977.infiniteindicator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.qdd2977.infiniteindicator.loader.GlideLoader;
import com.qdd2977.infiniteindicator.page.OnPageClickListener;
import com.qdd2977.infiniteindicator.page.Page;
import com.qdd2977.infiniteindicator.transformer.DepthPageTransformer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnPageClickListener {
    private ArrayList<Page> pageViews;
    private InfiniteIndicator mAnimCircleIndicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        pageViews = new ArrayList<>();
        pageViews.add(new Page("A ", "https://raw.githubusercontent.com/lightSky/InfiniteIndicator/master/res/a.jpg",this));
        pageViews.add(new Page("B ", "https://raw.githubusercontent.com/lightSky/InfiniteIndicator/master/res/b.jpg",this));
        pageViews.add(new Page("C ", "https://raw.githubusercontent.com/lightSky/InfiniteIndicator/master/res/c.jpg",this));
        pageViews.add(new Page("D ", "https://raw.githubusercontent.com/lightSky/InfiniteIndicator/master/res/d.jpg",this));
        testAnimCircleIndicator();
    }

    private void testAnimCircleIndicator() {
        mAnimCircleIndicator = (InfiniteIndicator)findViewById(R.id.infinite_anim_circle);
        mAnimCircleIndicator.setImageLoader(new GlideLoader());
        mAnimCircleIndicator.addPages(pageViews);
        mAnimCircleIndicator.setPosition(InfiniteIndicator.IndicatorPosition.Center);
        mAnimCircleIndicator.setInterval(4000);
        mAnimCircleIndicator.setScrollDurationFactor(10);
        mAnimCircleIndicator.setPageTransformer(true,new DepthPageTransformer());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAnimCircleIndicator.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mAnimCircleIndicator.stop();
    }

    @Override
    public void onPageClick(int position, Page page) {
        Toast.makeText(this,position+"",Toast.LENGTH_LONG).show();
    }
}
