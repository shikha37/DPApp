package com.example.dpapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomePageActivity extends AppCompatActivity {

    private TextView userDetailsTextView;
    private Button viewPatientsButton;

    private boolean isPatient;
    private String patientName;
    private String patientDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        userDetailsTextView = findViewById(R.id.userDetailsTextView);
        viewPatientsButton = findViewById(R.id.viewPatientsButton);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            isPatient = extras.getBoolean("isPatient");
            if (isPatient) {
                // Patient logged in
                patientName = extras.getString("patientName");
                patientDetails = extras.getString("patientDetails");

                userDetailsTextView.setText("Welcome, " + patientName);
                userDetailsTextView.append("\n\nPatient Details:\n" + patientDetails);

                viewPatientsButton.setVisibility(View.GONE);
            } else {
                // Doctor logged in
                userDetailsTextView.setText("Welcome, Doctor");
                viewPatientsButton.setVisibility(View.VISIBLE);
            }
        }

        viewPatientsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPatient) {
                    // Doctor viewing patient list
                    viewPatientList();
                }
            }
        });
    }

    private void viewPatientList() {
        // Replace this with your logic to retrieve and display the patient list
        // You can show the patient list in a new activity or a dialog, or implement a custom UI as per your requirement
        Toast.makeText(HomePageActivity.this, "Viewing patient list", Toast.LENGTH_SHORT).show();
    }
}
