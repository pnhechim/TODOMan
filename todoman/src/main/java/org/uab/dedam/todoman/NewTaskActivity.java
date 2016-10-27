package org.uab.dedam.todoman;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
                TaskRepository taskRepository = new TaskRepository(NewTaskActivity.this);
                taskRepository.save(taskTitle.getText().toString(), taskDescription.getText().toString());

                finish();
            }
        });

    }

    @Override
    public void onDateSelected(String date) {
        taskEndDate.setText(date);
    }
}
