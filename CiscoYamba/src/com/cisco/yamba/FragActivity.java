package com.cisco.yamba;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class FragActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_with_fragment);

		if (savedInstanceState == null) {
			FragmentManager fragmentManager = getFragmentManager();
			FragmentTransaction transaction = fragmentManager
					.beginTransaction();

			switch (getIntent().getIntExtra("fragment_id", -1)) {
			case R.id.fragment_prefs:
				transaction.add(R.id.fragment_container, new PrefsFragment() );
				this.setTitle(R.string.preferences);
				break;
			case R.id.fragment_status:
				transaction.add(R.id.fragment_container, new StatusFragment() );
				this.setTitle(R.string.status_update);
				break;
			}
			
			transaction.commit();

		}
	}

}
