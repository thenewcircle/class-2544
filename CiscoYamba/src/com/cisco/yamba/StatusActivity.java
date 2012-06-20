package com.cisco.yamba;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.marakana.android.yamba.clientlib.YambaClient;

public class StatusActivity extends Activity {
	private static final int MAX_LENGTH = 140;
	private TextView statusText, counterText;
	private int defaultColor;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.status);

		// Find the views
		statusText = (TextView) findViewById(R.id.status_update_text);
		statusText.addTextChangedListener( new MyTextWatcher() );
		counterText = (TextView) findViewById(R.id.status_update_counter_text);
		counterText.setText( Integer.toString(MAX_LENGTH-statusText.length()) );
		defaultColor = counterText.getTextColors().getDefaultColor();
	}

	/** Called when update button is clicked on. */
	public void onUpdateButtonClick(View v) {
		final String status = statusText.getText().toString();

		new StatusUpdateTask().execute(status);
	}

	/** Posts the status update in a separate task. */
	class StatusUpdateTask extends AsyncTask<String, Void, String> {
		Dialog dialog;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			dialog = new Dialog(StatusActivity.this);
			dialog.setTitle("Posting status update...");
			dialog.show();
		}

		/** Task that happens on a separate thread. */
		@Override
		protected String doInBackground(String... params) {
			try {
				YambaClient yambaClient = new YambaClient("student", "password");
				yambaClient.updateStatus(params[0]); // could take some time
				return "Status update posted successfully";
			} catch (Exception e) {
				Log.e("StatusActivity", "CRASHED!", e);
				e.printStackTrace();
				return "Failed to post the status update";
			}
		}

		/** Called once doInBackground() is complete. */
		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			dialog.dismiss();
			Toast.makeText(StatusActivity.this, result, Toast.LENGTH_LONG)
					.show();
		}

	}

	// --- Part of being TextWatcher --- //
	class MyTextWatcher implements TextWatcher {
		@Override
		public void afterTextChanged(Editable s) {
			int count = MAX_LENGTH - s.length();
			counterText.setText( Integer.toString(count) );
			
			// Change the color
			if(count < 30) {
				counterText.setTextColor( Color.RED );
				counterText.setTextScaleX(2);
			} else {
				counterText.setTextColor( defaultColor );
				counterText.setTextScaleX(1);
			}
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
		}
	}
}