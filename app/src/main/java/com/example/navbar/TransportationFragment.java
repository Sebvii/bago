package com.example.navbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TransportationFragment extends Fragment {
    private EditText fromLocation, toLocation;
    private Button startButton, stopButton;
    private boolean isTracking = false;

    public TransportationFragment() {
        // Required empty public constructor
    }

    @SuppressLint("WrongViewCast")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_transportation_fragment, container, false);

        // Initialize UI components using 'view.findViewById()'
        ImageView backButton = view.findViewById(R.id.back_arrow);  // ImageView
        fromLocation = view.findViewById(R.id.location_input);  // EditText
        toLocation = view.findViewById(R.id.destination_input);  // EditText
        startButton = view.findViewById(R.id.start_button);  // Button
        stopButton = view.findViewById(R.id.stop_button);  // Button

        // Ensure stop button is disabled initially
        stopButton.setEnabled(false);

        // Set click listeners
        backButton.setOnClickListener(v -> requireActivity().onBackPressed());
        startButton.setOnClickListener(v -> startTracking());
        stopButton.setOnClickListener(v -> stopTracking());

        return view;
    }

    private void startTracking() {
        if (!isTracking) {
            isTracking = true;
            startButton.setEnabled(false);
            stopButton.setEnabled(true);
        }
    }

    private void stopTracking() {
        if (isTracking) {
            isTracking = false;
            double distance = calculateDistance();
            // You can update the UI with the calculated distance here if needed
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
        }
    }

    private double calculateDistance() {
        return Math.random() * 10 + 1;
    }
}
