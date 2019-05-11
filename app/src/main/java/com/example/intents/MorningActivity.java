package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class MorningActivity extends AppCompatActivity {
    private TextView morningTime;

    @TargetApi(Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morning);

        ZoneId zoneId = ZoneId.of("Europe/Moscow");
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
        LocalTime localTime = zonedDateTime.toLocalTime();

        morningTime = findViewById(R.id.morning);
        morningTime.setText("Текущее время: " +  localTime.toString());
    }
}
