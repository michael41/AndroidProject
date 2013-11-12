package com.example.androidproject;

import java.util.ArrayList;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Lv1Activity extends Activity {

	TextView iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9, iv10, iv11, iv12,
			iv13, iv14, iv15, iv16;
	Animation animation;
	Animation animation2;
	boolean cardOneShowing = false;
	boolean cardTwoShowing = false;
	ArrayList<TextView> imageList = new ArrayList<TextView>();
	ArrayList<TextView> selectedImages = new ArrayList<TextView>();
	private Handler mHandler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lv1);
		// Show the Up button in the action bar.
		setupActionBar();

		animation = AnimationUtils.loadAnimation(this, R.anim.to_middle);
		animation2 = AnimationUtils.loadAnimation(this, R.anim.from_middle);

		iv1 = (TextView) findViewById(R.id.card1);
		iv2 = (TextView) findViewById(R.id.card2);
		iv3 = (TextView) findViewById(R.id.card3);
		iv4 = (TextView) findViewById(R.id.card4);
		iv5 = (TextView) findViewById(R.id.card5);
		iv6 = (TextView) findViewById(R.id.card6);
		iv7 = (TextView) findViewById(R.id.card7);
		iv8 = (TextView) findViewById(R.id.card8);
		iv9 = (TextView) findViewById(R.id.card9);
		iv10 = (TextView) findViewById(R.id.card10);
		iv11 = (TextView) findViewById(R.id.card11);
		iv12 = (TextView) findViewById(R.id.card12);
		iv13 = (TextView) findViewById(R.id.card13);
		iv14 = (TextView) findViewById(R.id.card14);
		iv15 = (TextView) findViewById(R.id.card15);
		iv16 = (TextView) findViewById(R.id.card16);
		imageList.add(iv1);
		imageList.add(iv2);
		imageList.add(iv3);
		imageList.add(iv4);
		imageList.add(iv5);
		imageList.add(iv6);
		imageList.add(iv7);
		imageList.add(iv8);
		imageList.add(iv9);
		imageList.add(iv10);
		imageList.add(iv11);
		imageList.add(iv12);
		imageList.add(iv13);
		imageList.add(iv14);
		imageList.add(iv15);
		imageList.add(iv16);

		for (TextView iv : imageList) {
			iv.setOnClickListener(new ImageView.OnClickListener() {
				public void onClick(View v) {
					if (selectedImages.size() == 0) {
						selectedImages.add((TextView) v);
						v.startAnimation(animation);
					} else if (selectedImages.size() == 1) {
						if (selectedImages.get(0) != v) {
							selectedImages.add((TextView) v);
							v.startAnimation(animation);
						}
					}
				}
			});
		}

		animation.setAnimationListener(new AnimationListener() {
			public void onAnimationEnd(Animation animation) {
				if (selectedImages.size() == 1) {
					selectedImages.get(0).setBackgroundResource(
							R.drawable.playing_card_back);
				}
				if (selectedImages.size() == 2) {
					selectedImages.get(1).setBackgroundResource(0);
					selectedImages.get(1).setText("TestTEST");

					mHandler.postDelayed(new Runnable() {
						public void run() {
							for (TextView iv : selectedImages) {
								iv.startAnimation(animation2);
								iv.setBackgroundResource(R.drawable.ic_launcher);
								iv.setText(null);
							}
							selectedImages.clear();
							;
						}
					}, 1000);
				}
			}

			public void onAnimationStart(Animation animation) {

			}

			public void onAnimationRepeat(Animation animation) {

			}
		});

		animation2.setAnimationListener(new AnimationListener() {
			public void onAnimationEnd(Animation animation) {

			}

			public void onAnimationStart(Animation animation) {

			}

			public void onAnimationRepeat(Animation animation) {

			}
		});
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lv1, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
