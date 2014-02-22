package com.example.instaclone;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class TabsActivity extends TabActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_host);

		TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);

		TabSpec tab1 = tabHost.newTabSpec("First Tab");
		TabSpec tab2 = tabHost.newTabSpec("Second Tab");
		TabSpec tab3 = tabHost.newTabSpec("Third tab");
		TabSpec tab4 = tabHost.newTabSpec("Fourth tab");

		tab1.setIndicator("Welcome");
		tab1.setContent(new Intent(this, Welcome.class));

		tab2.setIndicator("Feed");
		tab2.setContent(new Intent(this, UserFeed.class)); 

		tab3.setIndicator("All Users");
		tab3.setContent(new Intent(this, UserListFeed.class)); 
		
		tab4.setIndicator("Main Feed");
		tab4.setContent(new Intent(this, FriendFeed.class)); 

		tabHost.addTab(tab1);
		tabHost.addTab(tab2);
		tabHost.addTab(tab3);
		tabHost.addTab(tab4);

	}
}
