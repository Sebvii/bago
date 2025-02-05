package com.example.navbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FoodTwoFragment extends AppCompatActivity {

    private ImageView backArrow;
    private Button captureButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_two_fragment);  // Set the layout for the activity

        // Initialize the Back Button (ImageView)
        backArrow = findViewById(R.id.backArrow);

        // Set the onClickListener for the Back Button
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When the back button is clicked, finish the current activity and go back to the previous activity
                onBackPressed();
            }
        });

        // Initialize the Capture Button
        captureButton = findViewById(R.id.captureButton);

        // Set the onClickListener for the Capture Button
        captureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start a new activity or perform a capture-related task
                // For example, let's assume we're going to open a new activity:
                Intent captureIntent = new Intent(FoodTwoFragment.this, FoodTwoFragment.class);  // Change to the correct activity
                startActivity(captureIntent);
            }
        });
    }
}
