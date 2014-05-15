package com.kitexu.adapter;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class MyFragmentPagerAdapter extends FragmentPagerAdapter{

	ArrayList<Fragment> fragments = new ArrayList<Fragment>();
	
	public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
		super(fm);
		// TODO Auto-generated constructor stub
		
		this.fragments = fragments;
	}

	@Override
	public Fragment getItem(int pos) {
		// TODO Auto-generated method stub
		return fragments.get(pos);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return fragments.size();
	}



}
