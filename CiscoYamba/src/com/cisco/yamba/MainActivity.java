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
		Intent intent = new Intent(this, FragActivity.class);
		
		switch (item.getItemId()) {
		case R.id.item_prefs:
			intent.putExtra("fragment_id", R.id.fragment_prefs);
			break;
		case R.id.item_status_update:
			intent.putExtra("fragment_id", R.id.fragment_status);
			break;
		default:
			return super.onOptionsItemSelected(item);
		}
		
		startActivity( intent );
		return true;
	}
}
