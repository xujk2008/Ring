package com.kitexu.client;

import java.util.ArrayList;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.kitexu.ring.R;

public class MainActivity extends Activity{

	private ViewPager mViewPager;
	private View oneView;
	private View twoView;
	private View threeView;
	private ArrayList<View> views;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		
		views = new ArrayList<View>();
		mViewPager = (ViewPager)findViewById(R.id.mianViewPager);

		mViewPager.setOnPageChangeListener(null);
		initView();
		
		PagerAdapter adapter = new PagerAdapter(){

			@Override
			public void destroyItem(View container, int position, Object object) {
				// TODO Auto-generated method stub
				((ViewPager)container).removeView(views.get(position));
			}

			@Override
			public Object instantiateItem(View container, int position) {
				// TODO Auto-generated method stub
				((ViewPager)container).addView(views.get(position));
				
				return views.get(position);
			}

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return views.size();
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				// TODO Auto-generated method stub
				return (arg0==arg1);
			}
			
		};
		
		mViewPager.setAdapter(adapter);
	}
	
	public void initView()
	{
		Intent intent = new Intent(MainActivity.this, Splash.class);
	}
	
	private View getView(String id, Intent intent) {
		LocalActivityManager manager = new LocalActivityManager(MainActivity.this, true);
        return manager.startActivity(id, intent).getDecorView();
    }

}
