package com.example.navbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    private Button breakfastButton, lunchButton, snacksButton, dinnerButton, btnTrackTrip;
    private LinearLayout fooditem1, fooditem2;
    private LinearLayout linearLayoutSphere, linearLayoutIce, linearLayoutWeather, linearLayoutExp,
            linearLayoutJar, linearLayoutBarrier, linearLayoutEnvironment;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_home_fragment, container, false);

        // Initialize views from the layout
        breakfastButton = view.findViewById(R.id.breakfast_button);
        lunchButton = view.findViewById(R.id.lunch_button);
        snacksButton = view.findViewById(R.id.snacks_button);
        dinnerButton = view.findViewById(R.id.dinner_button);
        btnTrackTrip = view.findViewById(R.id.btnTrackTrip); // Initialize the Track Trip button

        // Initialize the LinearLayouts for food items
        fooditem1 = view.findViewById(R.id.fooditem1);
        fooditem2 = view.findViewById(R.id.fooditem2);

        // Initialize the LinearLayouts for other clickable items
        linearLayoutSphere = view.findViewById(R.id.linearLayoutSphere);
        linearLayoutIce = view.findViewById(R.id.linearLayoutIce);
        linearLayoutWeather = view.findViewById(R.id.linearLayoutWeather);
        linearLayoutExp = view.findViewById(R.id.linearLayoutExp);
        linearLayoutJar = view.findViewById(R.id.linearLayoutJar);
        linearLayoutBarrier = view.findViewById(R.id.linearLayoutBarrier);
        linearLayoutEnvironment = view.findViewById(R.id.linearLayoutEnvironment);

        // **Single Click Listener for Buttons**
        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;

                // Navigate to the appropriate activity based on the button clicked
                if (v.getId() == R.id.breakfast_button) {
                    intent = new Intent(getContext(), BreakfastFragment.class);
                } else if (v.getId() == R.id.lunch_button) {
                    intent = new Intent(getContext(), LunchFragment.class);
                } else if (v.getId() == R.id.snacks_button) {
                    intent = new Intent(getContext(), SnacksFragment.class);
                } else if (v.getId() == R.id.dinner_button) {
                    intent = new Intent(getContext(), DinnerFragment.class);
                } else if (v.getId() == R.id.btnTrackTrip) {
                    intent = new Intent(getContext(), TransportationFragment.class); // Ensure this class exists
                }

                if (intent != null) {
                    startActivity(intent);
                }
            }
        };

        // Assign listener to buttons
        breakfastButton.setOnClickListener(buttonClickListener);
        lunchButton.setOnClickListener(buttonClickListener);
        snacksButton.setOnClickListener(buttonClickListener);
        dinnerButton.setOnClickListener(buttonClickListener);
        btnTrackTrip.setOnClickListener(buttonClickListener);

        // Set click listeners for food items to navigate to specific activities
        fooditem1.setOnClickListener(v -> startActivity(new Intent(getContext(), FoodOneFragment.class)));
        fooditem2.setOnClickListener(v -> startActivity(new Intent(getContext(), FoodTwoFragment.class)));

        // Set click listeners for LinearLayouts to navigate to different activities
        linearLayoutSphere.setOnClickListener(v -> startActivity(new Intent(getContext(), Sphere.class)));
        linearLayoutIce.setOnClickListener(v -> startActivity(new Intent(getContext(), Ice.class)));
        linearLayoutWeather.setOnClickListener(v -> startActivity(new Intent(getContext(), Weather.class)));
        linearLayoutExp.setOnClickListener(v -> startActivity(new Intent(getContext(), Exp.class)));
        linearLayoutJar.setOnClickListener(v -> startActivity(new Intent(getContext(), Jar.class)));
        linearLayoutBarrier.setOnClickListener(v -> startActivity(new Intent(getContext(), Barrier.class)));
        linearLayoutEnvironment.setOnClickListener(v -> startActivity(new Intent(getContext(), Environment.class)));

        return view;
    }
}
