package com.example.instaclone;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Follow")
public class Follow extends ParseObject{
	
	public Follow() {
		
	}
	
	public ParseUser getFrom() {
		return getParseUser("from");
	}

	public void setFrom(ParseUser curr) {
		put("from", curr);
	}
	
	public ParseUser getTo() {
		return getParseUser("to");
	}

	public void setTo(ParseUser user) {
		put("to", user);
	}
	
	
	
}
