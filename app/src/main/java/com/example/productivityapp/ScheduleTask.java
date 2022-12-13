package com.example.productivityapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class ScheduleTask extends AppCompatActivity {

    public TimePicker timePicker;
    public TextView timeView;
    public EditText taskName;
    public Button scheduleButton;
    public NumberPicker hourPicker;
    public NumberPicker minutePicker;
    public NumberPicker secondPicker;
    public static int hoursToConvert;
    public static int minutesToConvert;
    public static int secondsToConvert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_task);

        timePicker = (TimePicker) findViewById(R.id.timePicker);
        timeView = (TextView) findViewById(R.id.time_view);
        taskName = (EditText) findViewById(R.id.taskName);
        scheduleButton = (Button) findViewById(R.id.notification_button);
        hourPicker = (NumberPicker) findViewById(R.id.hour_picker);
        minutePicker = (NumberPicker) findViewById(R.id.minute_picker);
        secondPicker = (NumberPicker) findViewById(R.id.second_picker);

        int minute = timePicker.getCurrentMinute();
        int hour = timePicker.getCurrentHour();

        hourPicker.setMaxValue(10);
        minutePicker.setMaxValue(59);
        secondPicker.setMaxValue(59);

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int minute) {
                hour = timePicker.getCurrentHour();
                minute = timePicker.getCurrentMinute();

                String hourString = String.valueOf(hour);
                StringBuilder minuteString = new StringBuilder().append(minute);

                if (minute < 10)
                    minuteString = new StringBuilder().append("0").append(minute);

                timeView.setText(new StringBuilder().append("Schedule task for ").append(hourString).append(":").append(minuteString));
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("ScheduleNotification", "ScheduleNotification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hour = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();
                hoursToConvert = hourPicker.getValue();
                minutesToConvert = minutePicker.getValue();
                secondsToConvert = secondPicker.getValue();

                String hourString = String.valueOf(hour);
                StringBuilder minuteString = new StringBuilder().append(minute);
                if (minute < 10)
                    minuteString = new StringBuilder().append("0").append(minute);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(ScheduleTask.this, "ScheduleNotification");
                builder.setContentTitle("You Have A Task");
                builder.setContentText(new StringBuilder().append("Your task ").append(taskName.getText()).append(" is scheduled for ").append(hourString).append(":").append(minuteString));
                builder.setSmallIcon(R.drawable.ic_notifications_black_24dp);
                builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(ScheduleTask.this);
                managerCompat.notify(1,builder.build());
            }
        });


    }
}