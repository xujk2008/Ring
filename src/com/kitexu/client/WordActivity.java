package com.kitexu.client;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.kitexu.ring.R;

public class WordActivity extends Activity{

	private ImageView wordCancelImage, wordSendImage;
	private ImageView wordFaceImage;
	private EditText wordEdit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.word_activity);
		
		wordCancelImage = (ImageView)findViewById(R.id.wordCancelImage);
		wordSendImage = (ImageView)findViewById(R.id.wordSendImage);
		wordFaceImage = (ImageView)findViewById(R.id.wordFaceImage);
		wordEdit = (EditText)findViewById(R.id.wordEdit);
		
		wordCancelImage.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				WordActivity.this.finish();
				
			}
			
		});
		
		wordSendImage.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				if(wordEdit.getText().toString().equals(""))
				{
					Toast.makeText(WordActivity.this, "说点儿什么吧，我在听呢", Toast.LENGTH_LONG).show();
					return;
				}
				
				Toast.makeText(WordActivity.this, "你写的每一个字儿，我都会认真看", Toast.LENGTH_LONG).show();
				WordActivity.this.finish();
				
			}
			
		});
		
		Integer faceDrawable = WordActivity.this.getIntent().getIntExtra("faceDrawable", R.drawable.happy_1);
		wordFaceImage.setImageResource(faceDrawable);
		
		wordEdit.addTextChangedListener(new TextWatcher(){

			private CharSequence temp;
			private boolean isEdit = true;
			private int selectionStart, selectionEnd;
			
			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				selectionStart = wordEdit.getSelectionStart();
				selectionEnd = wordEdit.getSelectionEnd();
				
				if(temp.length() > 14)
				{
					Toast.makeText(WordActivity.this, "写这么长，人家才不会看呢~", Toast.LENGTH_LONG).show();
					
					arg0.delete(selectionStart-1, selectionEnd);
					int tempSelection = selectionStart;
					wordEdit.setText(arg0);
					wordEdit.setSelection(tempSelection);
				}
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
				
				temp = arg0;
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

}
