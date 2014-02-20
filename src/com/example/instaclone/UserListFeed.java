package com.example.instaclone;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

public class UserListFeed extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feed_user_list);

		ParseQuery<ParseUser> userQuery = ParseUser.getQuery();
		userQuery.findInBackground(new FindCallback<ParseUser>() {

			@Override
			public void done(List<ParseUser> userList, ParseException e) {
				if (e == null) {
					for (ParseUser parseUser : userList) {
 						Log.i("USER---", parseUser.getUsername());
					}
				}
				
			}	
		});
		
	}

}
