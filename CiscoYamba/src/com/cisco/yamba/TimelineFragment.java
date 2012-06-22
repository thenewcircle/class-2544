package com.cisco.yamba;

import android.app.ListFragment;
import android.database.Cursor;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.widget.SimpleCursorAdapter.ViewBinder;
import android.widget.TextView;

public class TimelineFragment extends ListFragment {
	private static final String[] FROM = { StatusContract.Columns.USER, StatusContract.Columns.TEXT, StatusContract.Columns.CREATED_AT };
	private static final int[] TO = { R.id.text_user, R.id.text_text, R.id.text_created_at };
	private SimpleCursorAdapter adapter;
	private Cursor cursor;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setEmptyText("Loading data...");

		cursor = getActivity().getContentResolver().query(
				StatusContract.CONTENT_URI, null, null, null,
				StatusContract.SORT_ORDER);

		adapter = new SimpleCursorAdapter(getActivity(), R.layout.row, cursor,
				FROM, TO);
		adapter.setViewBinder(new TimelineViewBinder());

		setListAdapter(adapter);
	}

	/** Handles custom binding of data to view. */
	class TimelineViewBinder implements ViewBinder {

		@Override
		public boolean setViewValue(View view, Cursor cursor, int columnIndex) {
			if (view.getId() != R.id.text_created_at)
				return false;

			// Convert timestamp to relative time
			long timestamp = cursor.getLong(columnIndex);
			CharSequence relativeTime = DateUtils
					.getRelativeTimeSpanString(timestamp);
			((TextView)view).setText(relativeTime);
			
			return true;
		}
	}
}
