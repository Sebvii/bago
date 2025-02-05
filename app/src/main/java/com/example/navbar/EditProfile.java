package com.example.navbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class EditProfile extends AppCompatActivity {

    EditText editName, editEmail, editUsername, editPassword;
    Button saveButton;
    String nameUser, emailUser, usernameUser, passwordUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);



        editName = findViewById(R.id.firstNameInput);
        editEmail = findViewById(R.id.emailInput);
        editUsername = findViewById(R.id.lastNameInput);
        saveButton = findViewById(R.id.saveButton);

        // Load user data from Intent
        showData();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check if any field has been updated
                if (isNameChanged() || isEmailChanged() || isPasswordChanged()) {
                    Toast.makeText(EditProfile.this, "Saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EditProfile.this, "No Changes Found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean isNameChanged() {
        if (!nameUser.equals(editName.getText().toString())) {

            nameUser = editName.getText().toString();
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmailChanged() {
        if (!emailUser.equals(editEmail.getText().toString())) { // Fixed comparison

            emailUser = editEmail.getText().toString();
            return true;
        } else {
            return false;
        }
    }

    public boolean isPasswordChanged() {
        if (!passwordUser.equals(editPassword.getText().toString())) {

            passwordUser = editPassword.getText().toString();
            return true;
        } else {
            return false;
        }
    }

    public void showData() {
        // Retrieve data from the Intent
        Intent intent = getIntent();

        nameUser = intent.getStringExtra("name");
        emailUser = intent.getStringExtra("email");
        usernameUser = intent.getStringExtra("username");
        passwordUser = intent.getStringExtra("password");

        // Display the data in the respective EditText fields
        editName.setText(nameUser);
        editEmail.setText(emailUser);
        editUsername.setText(usernameUser); // Optional: Disable editing for username
        editPassword.setText(passwordUser);

        // Make username non-editable, if needed
        editUsername.setEnabled(false);
    }
}