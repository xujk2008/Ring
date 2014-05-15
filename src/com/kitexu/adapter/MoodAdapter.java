package com.kitexu.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import com.kitexu.ring.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MoodAdapter extends BaseAdapter{

	private Context context;
	private ArrayList<HashMap<String, Object>> data;
	
	public MoodAdapter(Context context, ArrayList<HashMap<String, Object>> data)
	{
		this.context = context;
		this.data = data;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return data.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		return (Integer)data.get(position).get("type");
	}

	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public View getView(int pos, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		
		ViewHolder holder;
		int type = getItemViewType(pos);
		
		if(convertView == null)
		{
			holder = new ViewHolder();
			switch(type)
			{
			case 0:
				
				convertView = LayoutInflater.from(context).inflate(R.layout.mood_list_male_item_, null);
				holder.moodTimeText = (TextView)convertView.findViewById(R.id.maleMoodTimeText);
				holder.moodDateText = (TextView)convertView.findViewById(R.id.maleMoodDateText);
				holder.moodWordText = (TextView)convertView.findViewById(R.id.maleMoodWordText);
				holder.moodFaceImage = (ImageView)convertView.findViewById(R.id.maleMoodFaceImage);
				
				break;
				
			case 1:
				
				convertView = LayoutInflater.from(context).inflate(R.layout.mood_list_female_item, null);
				holder.moodTimeText = (TextView)convertView.findViewById(R.id.femaleMoodTimeText);
				holder.moodDateText = (TextView)convertView.findViewById(R.id.femaleMoodDateText);
				holder.moodWordText = (TextView)convertView.findViewById(R.id.femaleMoodWordText);
				holder.moodFaceImage = (ImageView)convertView.findViewById(R.id.femaleMoodFaceImage);
				
				break;
			}
			
		}
		else{
			holder = (ViewHolder)convertView.getTag();
		}
		
		holder.moodTimeText.setText((String)data.get(pos).get("time"));
		holder.moodDateText.setText((String)data.get(pos).get("date"));
		holder.moodWordText.setText((String)data.get(pos).get("word"));
		holder.moodFaceImage.setImageResource((Integer)data.get(pos).get("faceDrawable"));
		
		convertView.setTag(holder);
		
		return convertView;
	}

	private class ViewHolder{
		
		TextView moodTimeText;
		TextView moodDateText;
		TextView moodWordText;
		ImageView moodFaceImage;
	
	}
}
