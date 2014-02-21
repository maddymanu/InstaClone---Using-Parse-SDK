package com.example.instaclone;

import com.parse.ParseObject;
import com.parse.ParseUser;

public class Follow extends ParseObject{
	
	public Follow() {
		
	}
	
	public ParseUser getFrom() {
		return getParseUser("from");
	}

	public void setFrom() {
		put("from", ParseUser.getCurrentUser());
	}
	
	public ParseUser getTo() {
		return getParseUser("to");
	}

	public void setTo(ParseUser user) {
		put("to", user);
	}
	
	
	
}
