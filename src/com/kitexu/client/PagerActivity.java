package com.kitexu.client;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;

import com.kitexu.adapter.MyFragmentPagerAdapter;
import com.kitexu.ring.R;

public class PagerActivity extends FragmentActivity{

	private ActivityManager mActivityManager;
	public static ViewPager mainViewPager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pager_activity);
		
		mainViewPager = (ViewPager)findViewById(R.id.mainViewPager);
		
		initView();
		
	}
	
	private void initView()
	{
		ArrayList<Fragment> fragments = new ArrayList<Fragment>();
		fragments.add(new VisitMoodFragment());
		fragments.add(new MainFragment());
		fragments.add(new SendMoodFragment());
		
		MyFragmentPagerAdapter mAdapter = new MyFragmentPagerAdapter(PagerActivity.this.getSupportFragmentManager(), fragments);
		mainViewPager.setAdapter(mAdapter);
		
		mainViewPager.setCurrentItem(1);
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		int currentItem = mainViewPager.getCurrentItem();
		
		switch(currentItem)
		{
		case 0:
			mainViewPager.setCurrentItem(1, true);
			
			break;
		case 1:
			super.onBackPressed();
			
			break;
		case 2:
			mainViewPager.setCurrentItem(1, true);
			
			break;
		}
	}
}
