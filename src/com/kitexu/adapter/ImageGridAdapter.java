package com.kitexu.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.kitexu.client.WordActivity;
import com.kitexu.ring.R;

public class ImageGridAdapter extends BaseAdapter{

	private Context context;
	private ArrayList<Integer> imageIds;
	
	public ImageGridAdapter(Context context,ArrayList<Integer> imageIds)
	{
		this.context = context;
		this.imageIds = imageIds;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return imageIds.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return imageIds.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(final int pos, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		
		ViewHolder holder;
		
		if(convertView == null)
		{
			convertView = LayoutInflater.from(context).inflate(R.layout.face_grid_item, null);
			
			holder = new ViewHolder();
			holder.faceGridItemImage = (ImageView)convertView.findViewById(R.id.faceGridItemImage);
			holder.faceGridSelector = (ImageView)convertView.findViewById(R.id.faceGridSelector);
		}
		else
		{
			holder = (ViewHolder)convertView.getTag();
		}
		
		holder.faceGridItemImage.setImageResource(imageIds.get(pos));
		holder.faceGridSelector.setVisibility(View.INVISIBLE);
		final ImageView selector = holder.faceGridSelector;
		
		holder.faceGridItemImage.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				selector.setVisibility(View.VISIBLE);
				
				Intent intent = new Intent(context, WordActivity.class);
				intent.putExtra("faceDrawable", imageIds.get(pos));
				context.startActivity(intent);
				
				selector.setVisibility(View.INVISIBLE);
			}
			
		});
		
		convertView.setTag(holder);
		
		return convertView;
	}

	private class ViewHolder
	{
		ImageView faceGridItemImage;
		ImageView faceGridSelector;
	}
}
