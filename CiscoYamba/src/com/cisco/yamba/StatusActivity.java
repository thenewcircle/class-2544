package com.cisco.yamba;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StatusActivity extends Activity {
	TextView statusText;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.status);

		// Find the views
		statusText = (TextView) findViewById(R.id.status_update_text);
	}
	
	/** Called when update button is clicked on. */
	public void onUpdateButtonClick(View v) {
		// TODO
	}
}