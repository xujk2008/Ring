package com.kitexu.client;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.kitexu.adapter.ImageGridAdapter;
import com.kitexu.ring.R;

public class SendMoodFragment extends Fragment{

	private Context context;
	private View mainView;
	private ImageView sendMoodBackImage;
	private GridView faceGrid;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		sendMoodBackImage = (ImageView)mainView.findViewById(R.id.sendMoodBackImage);
		sendMoodBackImage.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				PagerActivity.mainViewPager.setCurrentItem(1, true);
			}
			
		});
		
		faceGrid = (GridView)mainView.findViewById(R.id.faceGrid);
		
		ArrayList<Integer> imageIds = new ArrayList<Integer>();
		
		imageIds.add(R.drawable.sad_1);
		imageIds.add(R.drawable.sad_2);
		imageIds.add(R.drawable.sad_3);
		imageIds.add(R.drawable.sad_4);
		
		imageIds.add(R.drawable.angry_1);
		imageIds.add(R.drawable.angry_2);
		imageIds.add(R.drawable.angry_3);
		imageIds.add(R.drawable.angry_4);
		
		imageIds.add(R.drawable.neutral_1);
		imageIds.add(R.drawable.neutral_2);
		imageIds.add(R.drawable.neutral_3);
		imageIds.add(R.drawable.neutral_4);
		
		imageIds.add(R.drawable.happy_1);
		imageIds.add(R.drawable.happy_2);
		imageIds.add(R.drawable.happy_3);
		imageIds.add(R.drawable.happy_4);
		
		ImageGridAdapter mAdapter = new ImageGridAdapter(context, imageIds);
		faceGrid.setAdapter(mAdapter);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		
		mainView = inflater.inflate(R.layout.send_mood_fragment, null);
		context = SendMoodFragment.this.getActivity();
		
		return mainView;
	}
	
}
