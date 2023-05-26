package com.example.dpapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

class RegistrationActivity extends AppCompatActivity {

    private RadioGroup userTypeRadioGroup;
    private RadioButton playerRadioButton;
    private RadioButton coachRadioButton;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        userTypeRadioGroup = findViewById(R.id.userTypeRadioGroup);
        playerRadioButton = findViewById(R.id.playerRadioButton);
        coachRadioButton = findViewById(R.id.coachRadioButton);
        registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = userTypeRadioGroup.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    // No user type selected
                    Toast.makeText(RegistrationActivity.this, "Please select a user type", Toast.LENGTH_SHORT).show();
                } else {
                    RadioButton selectedRadioButton = findViewById(selectedId);

                    if (selectedRadioButton == playerRadioButton) {
                        // Player selected
                        String doctorId = assignDoctorId();
                        // Call registration method for player with doctorId
                        registerPlayer(doctorId);
                    } else if (selectedRadioButton == coachRadioButton) {
                        // Coach selected
                        // Call registration method for coach
                        registerCoach();
                    }
                }
            }
        });
    }

    private String assignDoctorId() {
        // Replace this with your logic to assign a doctor's ID to the player
        String doctorId = "XYZ123";
        return doctorId;
    }

    private void registerPlayer(String doctorId) {
        // Replace this with your logic to register a player with the assigned doctorId
        // You can use the 'doctorId' parameter to store the mapping between the player and the doctor
        Toast.makeText(RegistrationActivity.this, "Player registered with doctorId: " + doctorId, Toast.LENGTH_SHORT).show();
    }

    private void registerCoach() {
        // Replace this with your logic to register a coach
        Toast.makeText(RegistrationActivity.this, "Coach registered", Toast.LENGTH_SHORT).show();
    }
}
