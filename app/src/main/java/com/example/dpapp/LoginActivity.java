package com.example.dpapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private RadioGroup userTypeRadioGroup;
    private RadioButton patientRadioButton;
    private RadioButton doctorRadioButton;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userTypeRadioGroup = findViewById(R.id.userTypeRadioGroup);
        patientRadioButton = findViewById(R.id.patientRadioButton);
        doctorRadioButton = findViewById(R.id.doctorRadioButton);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = userTypeRadioGroup.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    // No user type selected
                    Toast.makeText(LoginActivity.this, "Please select a user type", Toast.LENGTH_SHORT).show();
                } else {
                    RadioButton selectedRadioButton = findViewById(selectedId);

                    if (selectedRadioButton == patientRadioButton) {
                        // Patient selected
                        loginPatient();
                    } else if (selectedRadioButton == doctorRadioButton) {
                        // Doctor selected
                        loginDoctor();
                    }
                }
            }
        });
    }

    private void loginPatient() {
        // Replace this with your logic for patient login
        Toast.makeText(LoginActivity.this, "Patient Login", Toast.LENGTH_SHORT).show();
    }

    private void loginDoctor() {
        // Replace this with your logic for doctor login
        Toast.makeText(LoginActivity.this, "Doctor Login", Toast.LENGTH_SHORT).show();
    }
}
