package com.example.instaclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

public class ParseApplication extends Application {
	
	@Override
    public void onCreate() {
        super.onCreate();
 
        // Add your initialization code here
        Parse.initialize(this, "yPLVepda1F0Fut2wVuMsaTwKjafOqAegWZ3JKfnI", "PjHIPdqDeKHmvu7GaoCFnCa48FPq1j45beI2Fxwr");
 
        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();

        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);
    }
	
}
