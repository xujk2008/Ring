package com.kitexu.client;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;

import com.kitexu.ring.R;

public class SignIn extends Activity{

	ImageView maleImage, femaleImage;
	EditText emailEdit, signinPasswordEdit;
	ImageView signinBackImage, signinSubmitImage;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.singin_activity);
		
		maleImage = (ImageView)findViewById(R.id.maleImage);
		femaleImage = (ImageView)findViewById(R.id.femaleImage);
		
		emailEdit = (EditText)findViewById(R.id.emailEdit);
		signinPasswordEdit = (EditText)findViewById(R.id.signinPasswordEdit);
		
		signinBackImage = (ImageView)findViewById(R.id.signinBackImage);
		signinSubmitImage = (ImageView)findViewById(R.id.signinSubmitImage);
		
		maleImage.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				maleImage.setImageResource(R.drawable.male);
				femaleImage.setImageResource(R.drawable.femaletxt);
			}
			
		});
		
		femaleImage.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				maleImage.setImageResource(R.drawable.maletxt);
				femaleImage.setImageResource(R.drawable.female);
			}
			
		});
		
		signinBackImage.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				SignIn.this.finish();
			}
			
		});
	}

}
