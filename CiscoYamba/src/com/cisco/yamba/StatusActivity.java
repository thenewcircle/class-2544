package com.cisco.yamba;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.marakana.android.yamba.clientlib.YambaClient;

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
		final String status = statusText.getText().toString();
		
		new Thread() {
			public void run() {
				try {
					YambaClient yambaClient = new YambaClient("student", "password");
					yambaClient.updateStatus(status);
				} catch (Exception e) {
					Log.e("StatusActivity", "CRASHED!", e);
					e.printStackTrace();
				}
			}
		}.start();
		
		Log.d("StatusActivity", "onUpdateButtonClick'ed with text: "+status);
	}
}