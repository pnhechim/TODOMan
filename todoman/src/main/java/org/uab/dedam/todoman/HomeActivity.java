package org.uab.dedam.todoman;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {

    TextView taskTitle;
    TextView taskDescription;
    TextView taskCompleted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        taskTitle = (TextView) findViewById(R.id.title);
        taskDescription = (TextView) findViewById(R.id.description);
        taskCompleted = (TextView) findViewById(R.id.completed);

        Button gotoSubactivity = (Button) findViewById(R.id.newTask);
        gotoSubactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, NewTaskActivity.class);
                //Comentamos para iniciar la activity con una alarma dentro de 10 segundos
                // startActivity(intent);
                PendingIntent pendingIntent = PendingIntent
                        .getActivity(HomeActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.set(AlarmManager.ELAPSED_REALTIME, 10000, pendingIntent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences("TASK_PREFS", MODE_PRIVATE);
        taskTitle.setText(
                preferences.getString("task_title", "No title yet")
        );
        taskDescription.setText(
                preferences.getString("task_description", "No description yet")
        );
        taskCompleted.setText(
                preferences.getBoolean("task_completed", false) ? "Task completed" : "Task not completed"
        );
    }
}
