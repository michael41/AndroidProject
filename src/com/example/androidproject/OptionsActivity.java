package com.example.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;


public class OptionsActivity extends Activity implements OnClickListener {

	Button bsave, bplay;
	RadioButton rbmuson, rbmusoff;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.options);
		
		rbmuson = (RadioButton) findViewById (R.id.RBmusicon); rbmusoff = (RadioButton) findViewById (R.id.RBmusicoff);
		bsave = (Button) findViewById (R.id.BTNsave); bplay = (Button) findViewById (R.id.BTNplay);
	}
	
		public void onClick(View arg0) {
			
			switch (arg0.getId()) {
			case R.id.BTNsave:
				//put in the code here to save the settings
				Toast.makeText(getApplicationContext(), 
                 "Settings saved", Toast.LENGTH_LONG).show();
				break;
				
			case R.id.BTNplay:
				//put in the code here to save the settings
				Intent i2 = new Intent(getApplicationContext(), Lv1Activity.class);
				startActivity(i2);
				break;
			}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.options, menu);
		return true;
	}



}
