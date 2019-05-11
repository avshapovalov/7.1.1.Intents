package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class AfternoonActivity extends AppCompatActivity {
    private TextView afternoonTime;

    @TargetApi(Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afternoon);

        ZoneId zoneId = ZoneId.of("Europe/Moscow");
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
        LocalTime localTime = zonedDateTime.toLocalTime();

        afternoonTime = findViewById(R.id.afternoon);
        afternoonTime.setText("Текущее время: " +  localTime.toString());
    }
}
