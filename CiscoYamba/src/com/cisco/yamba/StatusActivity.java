package com.cisco.yamba;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class StatusActivity extends Activity {
	Button updateButton;
	TextView statusText;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status);
        
        // Find the views
        updateButton = (Button) findViewById(R.id.status_update_button);
        statusText = (TextView) findViewById(R.id.status_update_text);
    }
}