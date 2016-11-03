package org.uab.dedam.todoman;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class NewTaskActivity extends AppCompatActivity
                             implements DatePickerFragment.OnDateSetCallBack{

    Button taskSetDate;
    Button save;
    TextView taskEndDate;

    EditText taskTitle;
    EditText taskDescription;
    CheckBox taskCompleted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newtask);

        taskSetDate = (Button) findViewById(R.id.taskSetDate);
        taskEndDate = (TextView) findViewById(R.id.taskDate);
        taskTitle = (EditText) findViewById(R.id.taskTitle);
        taskDescription = (EditText) findViewById(R.id.taskDescription);
        taskCompleted = (CheckBox) findViewById(R.id.taskComplete);

        taskSetDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerFragment datePickerFragment = new DatePickerFragment();
                datePickerFragment.onAttach(NewTaskActivity.this);
                datePickerFragment.show(getSupportFragmentManager(), "datePickerFragment");
            }
        });

        save = (Button) findViewById(R.id.saveTask);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* Comentamos y en lugar de SharedPreferences usaremos la base de datos
                SharedPreferences preferences = getSharedPreferences("TASK_PREFS", MODE_PRIVATE);
                SharedPreferences.Editor preferenceEditor = preferences.edit();
                preferenceEditor.putString("task_title", taskTitle.getText().toString());
                preferenceEditor.putString("task_description", taskDescription.getText().toString());
                preferenceEditor.putBoolean("task_completed", taskCompleted.isChecked());
                preferenceEditor.commit();
                 */
                /*
                TaskRepository taskRepository = new TaskRepository(NewTaskActivity.this);
                taskRepository.save(taskTitle.getText().toString(), taskDescription.getText().toString());

                finish();

                UpdateAsyncTask backgroundTask = new UpdateAsyncTask();
                backgroundTask.execute("update");
                */

                Intent intent = new Intent(NewTaskActivity.this, HomeActivity.class);
                PendingIntent pendingIntent = PendingIntent
                        .getActivity(NewTaskActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(NewTaskActivity.this);
                builder.setAutoCancel(false)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Notification title")
                        .setContentText("Notification details")
                        .setTicker("I'm a ticker")
                        .setColor(getResources().getColor(R.color.colorAccent))
                        .setProgress(100, 5, true)
                        .setContentIntent(pendingIntent);

                Notification notification = builder.build();
                NotificationManager notificationManager = (NotificationManager)
                        getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(123456, notification);

            }
        });

    }

    @Override
    public void onDateSelected(String date) {
        taskEndDate.setText(date);
    }
}
