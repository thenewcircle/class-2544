package com.cisco.yamba;

import android.app.ListFragment;
import android.os.Bundle;

public class TimelineFragment extends ListFragment {

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setEmptyText("Loading data...");
	}

}
