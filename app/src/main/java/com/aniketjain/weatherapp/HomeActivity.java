package com.aniketjain.weatherapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aniketjain.weatherapp.adapter.DaysAdapter;

import java.util.Arrays;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView daysRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Corrected ID to match XML
        daysRecyclerView = findViewById(R.id.day_rv);
        daysRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<String> days = Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");

        // Pass the context and the list of days to the DaysAdapter
        DaysAdapter adapter = new DaysAdapter(this, days);

        daysRecyclerView.setAdapter(adapter);
    }
}
