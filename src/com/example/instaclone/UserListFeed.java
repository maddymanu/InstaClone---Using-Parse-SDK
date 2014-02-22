package com.example.instaclone;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

public class UserListFeed extends Activity {

	ParseUser[] users;
	Follow follow;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
 		setContentView(R.layout.feed_user_list);
		
		final ListView yourListView = (ListView) findViewById(R.id.list1);

		ParseQuery<ParseUser> userQuery = ParseUser.getQuery();
		userQuery.findInBackground(new FindCallback<ParseUser>() {

			@Override
			public void done(List<ParseUser> userList, ParseException e) {
				users = new ParseUser[userList.size()];
				if (e == null) {
					for (ParseUser parseUser : userList) {
						//Log.i("USER---", parseUser.getUsername());
						// users.
					}
				}
				yourListView.setAdapter(new UserArrayAdapter(UserListFeed.this, userList));
				
				yourListView.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> adapter, View view,
							int position, long arg3) {
						ParseUser user = (ParseUser) adapter.getItemAtPosition(position);
						
						
						follow = new Follow();
    					follow.setFrom(ParseUser.getCurrentUser());
						follow.setTo(user);
						follow.saveInBackground();
						
					}
				});
			}
		});

	}



}
