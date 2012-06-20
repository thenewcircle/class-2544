package com.cisco.yamba;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	/** Called first time menu is needed. */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	/** Called every time an options item is selected. */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.item_prefs:
			startActivity( new Intent(this, PrefsActivity.class) );			
			return true;
		case R.id.item_status_update:
			startActivity( new Intent(this, StatusActivity.class) );
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
