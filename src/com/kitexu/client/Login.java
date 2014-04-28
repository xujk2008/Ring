package com.kitexu.client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;

import com.kitexu.ring.R;

public class Login extends Activity{

	private ImageView loginImage, signinImage;
	private EditText userEdit, loginPasswordEdit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_activity);
		
		userEdit = (EditText)findViewById(R.id.userNameEdit);
		loginPasswordEdit = (EditText)findViewById(R.id.loginPasswordEdit);
		
		loginImage = (ImageView)findViewById(R.id.loginImage);
		signinImage = (ImageView)findViewById(R.id.signinImage);
		
		signinImage.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent();
				intent.setClass(Login.this, SignIn.class);
				
				Login.this.startActivity(intent);
			}
			
		});
	}
	
}
