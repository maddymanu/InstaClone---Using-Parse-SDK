package com.example.instaclone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_main);
        Parse.initialize(this, "yPLVepda1F0Fut2wVuMsaTwKjafOqAegWZ3JKfnI", "PjHIPdqDeKHmvu7GaoCFnCa48FPq1j45beI2Fxwr");        
        ParseUser currentUser = ParseUser.getCurrentUser();
		if(currentUser == null){
			Intent intent = new Intent(this, LoginActivity.class);
			startActivity(intent);
			finish();
		} else {
			Intent intent = new Intent(MainActivity.this, Welcome.class);
			startActivity(intent);
		}
		

	}

}
