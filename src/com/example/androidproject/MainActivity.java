package com.example.androidproject;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//setting the fonts = 
		Typeface font = Typeface.createFromAsset(getAssets(), "Xolonium-Bold.otf");
		Typeface font2 = Typeface.createFromAsset(getAssets(), "Teleindicadores1.ttf");
		//xolonium font =
		Button b = (Button) findViewById(R.id.BTNstart);
		Button b2 = (Button) findViewById(R.id.BTNhighscores);
		Button b3 = (Button) findViewById(R.id.BTNoptions);
		b.setTypeface(font); b2.setTypeface(font); b3.setTypeface(font);
		//teleindicadores font =
		TextView tv = (TextView) findViewById(R.id.TVtitle);
				tv.setTypeface(font2);
								
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void startLv1(View view)
	{
		Intent intent = new Intent(this, Lv1Activity.class);
		startActivity(intent);
	}
}
