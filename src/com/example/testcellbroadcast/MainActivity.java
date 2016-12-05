package com.example.testcellbroadcast;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();
    
    MyPagerAdapter mMyPagerAdapter;
    ViewPager mMyViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayout();
        Log.v(TAG, "onCreate");
    }

    private void initLayout() {
        mMyPagerAdapter = new MyPagerAdapter(this);
        mMyViewPager = (ViewPager) findViewById(R.id.my_view_pager);
        mMyViewPager.setAdapter(mMyPagerAdapter);

    }

}
