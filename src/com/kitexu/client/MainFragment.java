package com.kitexu.client;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.kitexu.common.LocationCaculator;
import com.kitexu.ring.R;

public class MainFragment extends Fragment{

	private Context context;
	
	private SensorManager mSensorManager;
	private RelativeLayout shadowLayout;
	private ImageView reddotImage;
	
	private MySensorEventListener mSensorEventListener;
	
	private float prevDegree = 0f;
	
	private float curLng = 120.12127f, curLat = 30.25967f;
	private float relatedLng = 120.12398f, relatedLat = 30.26595f;
//	private float relatedLng = 120.12127f, relatedLat = 30.25967f;
//	private float curLng = 120.12398f, curLat = 30.26595f;
//	private float curLng = 120.12127f, curLat = 30.25967f;
//	private float relatedLng = 120.12993f, relatedLat = 30.25431f;
//	private float curLng = 10f, curLat = 40f;
//	private float relatedLng = 100f, relatedLat = 40f;
	private double azimuth;
	private double distance;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		context = MainFragment.this.getActivity();
		
		mSensorManager = (SensorManager) context.getSystemService(Activity.SENSOR_SERVICE);
		mSensorEventListener = new MySensorEventListener();
	}

	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		

		View mainView = inflater.inflate(R.layout.invitation_main_fragment, null);
		shadowLayout = (RelativeLayout) mainView.findViewById(R.id.shadowLayout);
		shadowLayout.setVisibility(View.GONE);

		reddotImage = (ImageView) mainView.findViewById(R.id.reddotImage);
		
		azimuth = LocationCaculator.computeAzimuth(curLng, curLat, relatedLng, relatedLat);
		distance = LocationCaculator.getDistance(curLng, curLat, relatedLng, relatedLat);
		
		return mainView;
	}



	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		mSensorManager.unregisterListener(mSensorEventListener);
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onPause();
		
		Log.v("@@@@@@", "MainActivity resumed.");
		mSensorManager.registerListener(mSensorEventListener,
				mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
				SensorManager.SENSOR_DELAY_NORMAL);
	}

	class MySensorEventListener implements SensorEventListener
	{
		@Override
		public void onAccuracyChanged(Sensor arg0, int arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onSensorChanged(SensorEvent event) {
			// TODO Auto-generated method stub
			if (event.sensor.getType() == Sensor.TYPE_ORIENTATION) {
				// 获取绕Z轴转过的角度
				float degree = event.values[0];
				// 创建旋转动画（反向转过degree度）
				float targetDegree = (float) (azimuth - degree + 360) % 360;
//				Log.v("@@@@@@", "distance: " + distance);
//				Log.v("@@@@@@", "azimuth: " + azimuth + " degree: " + degree);
//				Log.v("@@@@@@", "currentDegree: " + prevDegree + " targetDegree: " + targetDegree);
				if(Math.abs(prevDegree - targetDegree)>180)
				{
					float midDegreeEnd, midDegreeStart;
					if(prevDegree>targetDegree)
					{
						midDegreeEnd = 360;
						midDegreeStart = 0;
					}
					else
					{
						midDegreeEnd = 0;
						midDegreeStart = 360;
					}
					RotateAnimation ra = new RotateAnimation(prevDegree, midDegreeEnd,
							Animation.RELATIVE_TO_SELF, 0.5f,
							Animation.RELATIVE_TO_SELF, 0.5f);
					// 设置动画的持续时间
					ra.setDuration(100);
					// 设置动画结束后的保留状态
					ra.setFillAfter(true);
					// 启动动画
					reddotImage.startAnimation(ra);
					
					ra = new RotateAnimation(midDegreeStart, targetDegree,
							Animation.RELATIVE_TO_SELF, 0.5f,
							Animation.RELATIVE_TO_SELF, 0.5f);
					// 设置动画的持续时间
					ra.setDuration(100);
					// 设置动画结束后的保留状态
					ra.setFillAfter(true);
					// 启动动画
					reddotImage.startAnimation(ra);
				}
				else
				{
					Log.v("@@@@@@", "prevDegree: " + prevDegree + " targetDegree: " + targetDegree);
					RotateAnimation ra = new RotateAnimation(prevDegree, targetDegree,
							Animation.RELATIVE_TO_SELF, 0.5f,
							Animation.RELATIVE_TO_SELF, 0.5f);
					// 设置动画的持续时间
					ra.setDuration(200);
					// 设置动画结束后的保留状态
					ra.setFillAfter(true);
					// 启动动画
					reddotImage.startAnimation(ra);
				}
				
				prevDegree = targetDegree;
			}
		}
	
	}
}
