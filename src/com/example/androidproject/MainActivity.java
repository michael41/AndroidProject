package com.example.androidproject;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/*
		 *******************************	RETRO LOOK  ***************************
		 *- You can choose the option of 'Retro', 'Cloud' or 'Plain' in the options part as to which background you want 
		//variables
		LinearLayout ll_retro = (LinearLayout) findViewById(R.id.LLactivity_main);
		Button b_start = (Button) findViewById(R.id.BTNstart);
		Button b_highscores = (Button) findViewById(R.id.BTNhighscores);
		Button b_options = (Button) findViewById(R.id.BTNoptions);
		Typeface font_xb = Typeface.createFromAsset(getAssets(), "Xolonium-Bold.otf");
		Typeface font_tele = Typeface.createFromAsset(getAssets(), "Teleindicadores1.ttf");	
		
		//setting the background image =
		ll_retro.setBackgroundResource(R.drawable.background_image_retro);	
		
		//setting the background image for the buttons = 
		b_start.setBackgroundResource(R.drawable.btnback_nova);
		b_highscores.setBackgroundResource(R.drawable.btnback_bluestar);b_options.setBackgroundResource(R.drawable.btnback_bluestar);
		
		//setting the fonts = 			
		//xolonium font for the three buttons = 		
		b_start.setTypeface(font_xb); b_highscores.setTypeface(font_xb); b_options.setTypeface(font_xb);
		//teleindicadores font for the title = 
		TextView tv = (TextView) findViewById(R.id.TVtitle);
		tv.setTypeface(font_tele);
		*/
		
		// *******************************	CLOUD LOOK ***************************
		//variables
				LinearLayout ll_retro = (LinearLayout) findViewById(R.id.LLactivity_main);
				Button b_start = (Button) findViewById(R.id.BTNstart);
				Button b_highscores = (Button) findViewById(R.id.BTNhighscores);
				Button b_options = (Button) findViewById(R.id.BTNoptions);
				Typeface font_xb = Typeface.createFromAsset(getAssets(), "DK Crayon Crumble.ttf");
				Typeface font_tele = Typeface.createFromAsset(getAssets(), "KBDunkTank.ttf");	
				
				//setting the background image =
				ll_retro.setBackgroundResource(R.drawable.background_image_cloud);	
				
				//setting the background image for the buttons = 
				b_start.setBackgroundResource(R.drawable.btnback_telebubble);
				b_highscores.setBackgroundResource(R.drawable.btnback_greenbox);b_options.setBackgroundResource(R.drawable.btnback_greenbox);
				
				//setting the fonts = 			
				//xolonium font for the three buttons = 		
				b_start.setTypeface(font_xb); b_highscores.setTypeface(font_xb); b_options.setTypeface(font_xb);
				//teleindicadores font for the title = 
				TextView tv = (TextView) findViewById(R.id.TVtitle);
				tv.setTextSize(30.0f);
				tv.setTextColor(Color.BLUE);
				tv.setTypeface(font_tele);
		
								
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
	
	public void startOptions(View view)
	{
		Intent intent = new Intent(this, OptionsActivity.class);
		startActivity(intent);
	}
}
