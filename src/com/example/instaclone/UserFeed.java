package com.example.instaclone;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

public class UserFeed extends Activity {

	ImageView iv;
	GridView gridView;
	ListView imageListView;
	Bitmap[] imageBitmaps;
	ImageLoader imageLoader;
	GridViewAdapter adapter;

	private List<PicList> picarraylist = null;

	int i = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feed_own);

		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				getApplicationContext()).build();
		imageLoader = ImageLoader.getInstance();
		imageLoader.init(config);

		iv = (ImageView) findViewById(R.id.photo_view);
		gridView = (GridView) findViewById(R.id.images_gridview);

		ParseQuery<ParseObject> query = ParseQuery.getQuery("Pic");
		query.whereEqualTo("author", ParseUser.getCurrentUser());

		query.findInBackground(new FindCallback<ParseObject>() {

			@Override
			public void done(List<ParseObject> picList, ParseException e) {

				picarraylist = new ArrayList<PicList>();
				imageBitmaps = new Bitmap[picList.size() + 1];
				// get the entire list of fucking bitmaps
				if (e == null) {

					for (i = 0; i < picList.size(); i++) {

						ParseFile file = (ParseFile) picList.get(i)
								.get("photo");
						PicList map = new PicList();
						map.setPic(file.getUrl());
						picarraylist.add(map);
						file.getDataInBackground(new GetDataCallback() {

							@Override
							public void done(byte[] picBytes,
									ParseException arg1) {
								Bitmap bitmap = BitmapFactory.decodeByteArray(
										picBytes, 0, picBytes.length);

								String imageUri = null;
								try {
									imageUri = new String(picBytes, "UTF-8");
									imageLoader.displayImage(
											picBytes.toString(), iv);
								} catch (UnsupportedEncodingException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								imageBitmaps[i] = bitmap;
								// iv.setImageBitmap(bitmap);

							}

						});

					}
					adapter = new GridViewAdapter(UserFeed.this,
							picarraylist);
					// Binds the Adapter to the ListView
					gridView.setAdapter(adapter);
				}

			}

		});
	}
}
