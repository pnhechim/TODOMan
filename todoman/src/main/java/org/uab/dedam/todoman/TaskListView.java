package org.uab.dedam.todoman;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.CursorAdapter;

public class TaskListView extends ListActivity {
    CursorAdapter cursorAdapter;

    static final String[] PROJECTION = new String[] {
            TaskDatabaseContract.COLUMN_TITLE,
            TaskDatabaseContract.COLUMN_DESCRIPTION,
            TaskDatabaseContract.COLUMN_COMPLETED
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // For the cursor adapter, specify which columns go into which views
        String[] fromColumns = {
                TaskDatabaseContract.COLUMN_TITLE,
                TaskDatabaseContract.COLUMN_DESCRIPTION,
                TaskDatabaseContract.COLUMN_COMPLETED
        };
        int[] toViews = {android.R.id.text1}; // The TextView in simple_list_item_1

    }
}
