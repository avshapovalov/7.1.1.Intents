package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doSynchronization(View view) {
        Intent intent = new Intent(Intent.ACTION_SYNC);
        if (isCurrentTimeBetween(6,00, 14,00)){
            intent.setData(Uri.parse("http://morning"));
            startActivity(intent);
        } else if (isCurrentTimeBetween(14,00, 15,00)) {
            intent.setData(Uri.parse("http://afternoon"));
            startActivity(intent);
        } else if (isCurrentTimeBetween(14,00, 15,00)) {
            intent.setData(Uri.parse("http://evening"));
            startActivity(intent);
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    private boolean isCurrentTimeBetween(int startHour, int startMinute, int endHour, int endMinute) {
        ZoneId zoneId = ZoneId.of("Europe/Moscow");
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
        LocalTime localTime = zonedDateTime.toLocalTime();

        LocalTime start = LocalTime.of(startHour, startMinute);
        LocalTime stop = LocalTime.of(endHour, endMinute);

        if (localTime.isAfter(start) && localTime.isBefore(stop)) {
            return true;
        } else if (stop.isBefore(start)) {
            return false;
        }
        return false;
    }


}
