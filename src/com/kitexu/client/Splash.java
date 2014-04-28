package com.kitexu.client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.kitexu.ring.R;

public class Splash extends Activity{
	
	ImageView splashImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_activity);
		
		splashImage = (ImageView)findViewById(R.id.splashImage);
		splashImage.setBackgroundResource(R.drawable.splash);
		
		new Thread(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
					sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					Intent intent = new Intent();
					intent.setClass(Splash.this, Login.class);
					Splash.this.startActivity(intent);
					
					Splash.this.finish();
				}
			}
			
		}.start();
	}
	
	

}
