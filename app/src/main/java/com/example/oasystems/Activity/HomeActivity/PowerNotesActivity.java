package com.example.oasystems.Activity.HomeActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.oasystems.Activity.MainActivity;
import com.example.oasystems.R;

public class PowerNotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_notes);
        CalendarView calendarView = (CalendarView) findViewById(R.id.cv);
        calendarView.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() {
            @Override
            public void onChildViewAdded(View parent, View child) {
                Toast.makeText(PowerNotesActivity.this,"onChildViewAdded",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildViewRemoved(View parent, View child) {
                Toast.makeText(PowerNotesActivity.this,"onChildViewRemoved",Toast.LENGTH_SHORT).show();
            }
        });


    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
