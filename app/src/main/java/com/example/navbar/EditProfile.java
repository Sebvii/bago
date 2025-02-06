package com.example.navbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class EditProfile extends AppCompatActivity {

    private EditText editName, editEmail, editUsername;
    private Button saveButton;
    private String nameUser, emailUser, usernameUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile); // Set layout file

        // Initialize UI elements
        editName = findViewById(R.id.firstNameInput);
        editEmail = findViewById(R.id.emailInput);
        editUsername = findViewById(R.id.lastNameInput);
        saveButton = findViewById(R.id.saveButton);

        // Load user data
        showData();

        // Save button click event
        saveButton.setOnClickListener(v -> {
            if (isNameChanged() || isEmailChanged()) {
                // Handle data saving logic (Firebase, SharedPreferences, etc.)
            }
        });
    }

    private void showData() {
        Intent intent = getIntent();

        // Retrieve data safely
        nameUser = intent.getStringExtra("name");
        emailUser = intent.getStringExtra("email");
        usernameUser = intent.getStringExtra("username");

        // Ensure no null values are set to EditText fields
        editName.setText(nameUser != null ? nameUser : "");
        editEmail.setText(emailUser != null ? emailUser : "");
        editEmail.setText(emailUser != null ? emailUser : "");
        editUsername.setText(usernameUser != null ? usernameUser : "");

        // Make username non-editable
        editUsername.setEnabled(false);
    }

    private boolean isNameChanged() {
        return nameUser != null && !nameUser.equals(editName.getText().toString());
    }

    private boolean isEmailChanged() {
        return emailUser != null && !emailUser.equals(editEmail.getText().toString());
    }
}
