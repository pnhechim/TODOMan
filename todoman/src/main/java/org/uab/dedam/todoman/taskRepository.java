package org.uab.dedam.todoman;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TaskRepository {
    private TaskDatabase taskDatabase;
    private SQLiteDatabase databaseObject;

    public TaskRepository(Context context) {
        this.taskDatabase = new TaskDatabase(context);
        this.databaseObject = this.taskDatabase.getWritableDatabase();
    }

    public Cursor getTasks() {
        return this.databaseObject.query(TaskDatabaseContract.TABLE_TASK,
                null,
                null,
                null,
                null,
                null,
                null);
    }

    public void save(String title, String description) {
        ContentValues values = new ContentValues();
        values.put(TaskDatabaseContract.COLUMN_TITLE, title);
        values.put(TaskDatabaseContract.COLUMN_DESCRIPTION, description);
        this.databaseObject.insert(
                TaskDatabaseContract.TABLE_TASK,
                null,
                values);
    }
}
