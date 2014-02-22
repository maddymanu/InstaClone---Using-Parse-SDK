package com.example.instaclone;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

public class FriendFeed extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feed_own);
		
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Follow");
		query.include("User.username");
		query.whereEqualTo("from", ParseUser.getCurrentUser());
		
		 
		// execute the query
		query.findInBackground(new FindCallback<ParseObject>() {
		    public void done(List<ParseObject> followList, ParseException e) {
		    	for (ParseObject obj : followList) {
					ParseUser usr = ((Follow) obj).getTo();
					try {
						usr.fetchIfNeeded();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Log.i("Friend Feed" , " " + usr.getUsername());
				}
		    }
		});
	}
}
