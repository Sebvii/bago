package com.example.navbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private ImageView profileImg;
    private TextView titleName, titleEmail;
    private Button editButton;
    private View deleteAccountContainer, termsConditionsContainer, logoutContainer;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_profile_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize UI elements
        profileImg = view.findViewById(R.id.profileImg);
        titleName = view.findViewById(R.id.titleName);
        editButton = view.findViewById(R.id.editProfile);
        termsConditionsContainer = view.findViewById(R.id.privacy);
        logoutContainer = view.findViewById(R.id.logoutLayout);

        // Set up event listeners
        setupListeners();
    }

    private void setupListeners() {
        // Edit Profile Button Click Listener
        editButton.setOnClickListener(v -> {
            try {
                // Navigate to Edit Profile Activity
                Intent intent = new Intent(getActivity(), EditProfile.class);
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Delete Account Click Listener
        deleteAccountContainer.setOnClickListener(v -> showDeleteConfirmation());

        // Terms and Conditions Click Listener
        termsConditionsContainer.setOnClickListener(v -> {
            // Navigate to Terms and Conditions Activity
            Intent intent = new Intent(getActivity(), ProfileTermsAndCondition.class);
            startActivity(intent);
        });

        // Logout Click Listener

    }

    private void showDeleteConfirmation() {
        // Show a confirmation dialog for account deletion
        new android.app.AlertDialog.Builder(requireContext())
                .setTitle("Delete Account")
                .setMessage("Are you sure you want to delete your account? This action cannot be undone.")
                .setPositiveButton("Delete", (dialog, which) -> performAccountDeletion())
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .show();
    }

    private void performAccountDeletion() {
        // Simulate account deletion
        titleName.setText("Account Deleted");
        titleEmail.setText("");
    }


}
