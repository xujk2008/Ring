package com.kitexu.client;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.kitexu.adapter.MoodAdapter;
import com.kitexu.ring.R;

public class VisitMoodFragment extends Fragment {
	
	private Context context;
	private View mainView;
	
	private ListView visitMoodList;
	private ArrayList<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

		visitMoodList = (ListView)mainView.findViewById(R.id.visitMoodList);
		
		HashMap<String, Object> temp = new HashMap<String, Object>();
		
		temp.put("time", "22:15");
		temp.put("date", "2014-05-14");
		temp.put("word", "还在实验室写代码啊啊啊...");
		temp.put("faceDrawable", R.drawable.sad_1);
		temp.put("type", 0);
		data.add(temp);
		
		
		temp = new HashMap<String, Object>();
		temp.put("time", "22:16");
		temp.put("date", "2014-05-14");
		temp.put("word", "其实有事情忙倒也不错。");
		temp.put("faceDrawable", R.drawable.neutral_1);
		temp.put("type", 0);
		data.add(temp);

		temp = new HashMap<String, Object>();
		temp.put("time", "22:15");
		temp.put("date", "2014-05-14");
		temp.put("word", "这个家伙一定还在实验室写代码。");
		temp.put("faceDrawable", R.drawable.sad_1);
		temp.put("type", 1);
		data.add(temp);
		
		temp = new HashMap<String, Object>();
		temp.put("time", "22:17");
		temp.put("date", "2014-05-14");
		temp.put("word", "一旦接受这个设定其实觉得也还不错。");
		temp.put("faceDrawable", R.drawable.happy_1);
		temp.put("type", 0);
		data.add(temp);
		
		temp = new HashMap<String, Object>();
		temp.put("time", "22:16");
		temp.put("date", "2014-05-14");
		temp.put("word", "其实这个家伙有事情忙倒也不错。");
		temp.put("faceDrawable", R.drawable.neutral_1);
		temp.put("type", 1);
		data.add(temp);
		
		temp = new HashMap<String, Object>();
		temp.put("time", "22:18");
		temp.put("date", "2014-05-14");
		temp.put("word", "明天我想早点儿去实验室。");
		temp.put("faceDrawable", R.drawable.happy_1);
		temp.put("type", 0);
		data.add(temp);
		
		temp = new HashMap<String, Object>();
		temp.put("time", "22:17");
		temp.put("date", "2014-05-14");
		temp.put("word", "一旦接受这个设定其实觉得也还不错。");
		temp.put("faceDrawable", R.drawable.happy_1);
		temp.put("type", 1);
		data.add(temp);
		
		temp = new HashMap<String, Object>();
		temp.put("time", "22:18");
		temp.put("date", "2014-05-14");
		temp.put("word", "把该干的活儿都干完。");
		temp.put("faceDrawable", R.drawable.happy_1);
		temp.put("type", 0);
		data.add(temp);
		
		temp = new HashMap<String, Object>();
		temp.put("time", "22:18");
		temp.put("date", "2014-05-14");
		temp.put("word", "去实验室前要喝两碗豆腐脑，一碗甜，一碗咸。");
		temp.put("faceDrawable", R.drawable.happy_1);
		temp.put("type", 0);
		data.add(temp);
		
		MoodAdapter mAdapter = new MoodAdapter(context, data);
		visitMoodList.setAdapter(mAdapter);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);

		mainView = inflater.inflate(R.layout.visit_mood_fragment, null);
		context = VisitMoodFragment.this.getActivity();

		return mainView;
	}
}
