package com.example.instaclone;

import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

public class UserListFeed extends ListActivity {
	
	ParseUser[] users;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.feed_user_list);
		//ArrayList<String> userNameList
		//setListAdapter(new UserArrayAdapter(this, MOBILE_OS));

		ParseQuery<ParseUser> userQuery = ParseUser.getQuery();
		userQuery.findInBackground(new FindCallback<ParseUser>() {

			@Override
			public void done(List<ParseUser> userList, ParseException e) {
				users = new ParseUser[userList.size()];
				if (e == null) {
					for (ParseUser parseUser : userList) {
 						Log.i("USER---", parseUser.getUsername());
						//users.
					}
				}
				setListAdapter(new UserArrayAdapter(UserListFeed.this, userList));
			}	
		});
		
	}

}
