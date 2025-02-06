package com.example.navbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DinnerFragment extends AppCompatActivity {  // Fixed potential typo in class name

    private ImageView backButton, insightArrow, recommendationArrow, floatingImageButton;
    private TextView insightText, recommendationText;
    private boolean isInsightVisible = true;
    private boolean isRecommendationVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner_fragment);  // Ensure this matches your XML file name

        // Initialize UI elements
        backButton = findViewById(R.id.backButton);
        insightArrow = findViewById(R.id.insightArrow);
        recommendationArrow = findViewById(R.id.recommendationArrow);
        floatingImageButton = findViewById(R.id.floatingImageButton);
        insightText = findViewById(R.id.insightText);
        recommendationText = findViewById(R.id.recommendationText);

        // Back Button - Navigate Back
        backButton.setOnClickListener(v -> finish());  // Closes the current activity

        // Insight Arrow - Toggle Insight Text
        insightArrow.setOnClickListener(v -> {
            if (isInsightVisible) {
                insightText.setVisibility(View.GONE);
                insightArrow.setImageResource(R.drawable.down_arrow);  // Change to down arrow
            } else {
                insightText.setVisibility(View.VISIBLE);
                insightArrow.setImageResource(R.drawable.up_arrow);  // Change to up arrow
            }
            isInsightVisible = !isInsightVisible;
        });

        // Recommendation Arrow - Toggle Recommendation Text
        recommendationArrow.setOnClickListener(v -> {
            if (isRecommendationVisible) {
                recommendationText.setVisibility(View.GONE);
                recommendationArrow.setImageResource(R.drawable.down_arrow);
            } else {
                recommendationText.setVisibility(View.VISIBLE);
                recommendationArrow.setImageResource(R.drawable.up_arrow);
            }
            isRecommendationVisible = !isRecommendationVisible;
        });

        // Floating Image Button - Click Event
        floatingImageButton.setOnClickListener(v -> onFloatingButtonClick());
    }

    private void onFloatingButtonClick() {
        Toast.makeText(this, "Floating button clicked!", Toast.LENGTH_SHORT).show();
    }
}
