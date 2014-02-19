package com.example.instaclone;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

public class GridViewAdapter extends BaseAdapter {

	Context context;
	LayoutInflater inflater;
	com.example.instaclone.ImageLoader imageLoader;
	private List<PicList> picarraylist = null;
	private ArrayList<PicList> arraylist;

	public GridViewAdapter(Context context, List<PicList> phonearraylist) {
		this.context = context;
		this.picarraylist = phonearraylist;
		inflater = LayoutInflater.from(context);
		this.arraylist = new ArrayList<PicList>();
		this.arraylist.addAll(phonearraylist);
		imageLoader = new com.example.instaclone.ImageLoader(context);
	}

	public class ViewHolder {
		public ImageView pic;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return picarraylist.size();
	}

	@Override
	public Object getItem(int position) {
		return picarraylist.get(position);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		final ViewHolder holder;
		if (view == null) {
			holder = new ViewHolder();
			view = inflater.inflate(R.layout.gridview_item, null);
			// Locate the ImageView in gridview_item.xml
			holder.pic = (ImageView) view.findViewById(R.id.pic);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}
		// Load image into GridView
		imageLoader.DisplayImage(picarraylist.get(position).getPic(),
				holder.pic);
		// Capture GridView item click
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
//				// Send single item click data to SingleItemView Class
//				Intent intent = new Intent(context, SingleItemView.class);
//				// Pass all data phone
//				intent.putExtra("phone", picarraylist.get(position)
//						.getPhone());
//				context.startActivity(intent);
			}
		});
		return view;
	}

}
