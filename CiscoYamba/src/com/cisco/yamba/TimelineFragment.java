package com.cisco.yamba;

import android.app.ListFragment;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;

public class TimelineFragment extends ListFragment {
	private static final String[] FROM = { StatusContract.Columns.USER, StatusContract.Columns.TEXT };
	private static final int[] TO = { android.R.id.text1, android.R.id.text2 };
	private SimpleCursorAdapter adapter;
	private Cursor cursor;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setEmptyText("Loading data...");

		cursor = getActivity().getContentResolver().query(
				StatusContract.CONTENT_URI, null, null, null,
				StatusContract.SORT_ORDER);

		adapter = new SimpleCursorAdapter(getActivity(),
				android.R.layout.simple_list_item_2, cursor, FROM, TO);
		
		setListAdapter(adapter);
	}
}
