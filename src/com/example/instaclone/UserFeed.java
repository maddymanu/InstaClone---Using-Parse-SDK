package com.example.instaclone;

import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

public class UserFeed extends Activity {
	
	ImageView iv;
	
	@Override
	 public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feed_own);
		
		iv = (ImageView) findViewById(R.id.photo_view);
		
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Pic");
		query.whereEqualTo("author", ParseUser.getCurrentUser());
		
		query.findInBackground(new FindCallback<ParseObject>() {

			@Override
			public void done(List<ParseObject> picList, ParseException e) {
				if(e==null) {
					
					ParseFile file = (ParseFile)picList.get(2).get("photo");
		            file.getDataInBackground(new GetDataCallback() {

						@Override
						public void done(byte[] picBytes, ParseException arg1) {
							Bitmap bitmap=BitmapFactory.decodeByteArray(picBytes, 0, picBytes.length);
							iv.setImageBitmap(bitmap);
						}
		            	
		            });
				}
			}
			
		});
	}
}
