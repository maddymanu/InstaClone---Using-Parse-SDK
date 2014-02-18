package com.example.instaclone;

import java.io.ByteArrayOutputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.parse.ParseFile;
import com.parse.ParseUser;

public class Welcome extends Activity {

	Button clickButton;
	EditText titleText;
	ImageView imageV;
	Pic pic;
	static final int REQUEST_IMAGE_CAPTURE = 1;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);

		ParseUser currentUser = ParseUser.getCurrentUser();

		clickButton = (Button) findViewById(R.id.click);
		titleText = (EditText) findViewById(R.id.title_text);
		imageV = (ImageView) findViewById(R.id.image_view);


		clickButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
			        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
			    }
			}
		});

	}
	
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
	        Bundle extras = data.getExtras();
	        Bitmap imageBitmap = (Bitmap) extras.get("data");
	        imageV.setImageBitmap(imageBitmap);
	        
	        ByteArrayOutputStream stream = new ByteArrayOutputStream();
	        imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] image = stream.toByteArray(); // got the image file
            
            ParseFile file = new ParseFile("androidbegin.png", image);
            pic = new Pic();
    		pic.setTitle(titleText.getText().toString());
    		pic.setAuthor(ParseUser.getCurrentUser());
            pic.setPhotoFile(file);
            pic.saveInBackground();
	        
	    }
	}
	
	
	
}

