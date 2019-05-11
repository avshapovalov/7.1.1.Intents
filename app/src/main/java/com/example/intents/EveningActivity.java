package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class EveningActivity extends AppCompatActivity {
    private TextView eveningTime;

    @TargetApi(Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evening);

        ZoneId zoneId = ZoneId.of("Europe/Moscow");
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
        LocalTime localTime = zonedDateTime.toLocalTime();

        eveningTime = findViewById(R.id.evening);
        eveningTime.setText("Текущее время: " + localTime.toString());
    }
}
