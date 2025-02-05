package com.example.navbar;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private final Stack<Integer> fragmentStack = new Stack<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation_view);

        // Load the default fragment (HomeFragment)
        loadFragment(new HomeFragment(), R.id.nav_home);

        // Handle bottom navigation item selection
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            // Avoid reloading the current fragment
            if (!fragmentStack.isEmpty() && fragmentStack.peek() == itemId) {
                return true;
            }

            Fragment selectedFragment = null;
            if (itemId == R.id.nav_home) {
                selectedFragment = new HomeFragment();
            } else if (itemId == R.id.nav_footprint) {
                selectedFragment = new FootPrintFragment();
            } else if (itemId == R.id.nav_profile) {
                selectedFragment = new ProfileFragment();
            } else if (itemId == R.id.nav_community) {
                selectedFragment = new CommunityFragment();
            } else if (itemId == R.id.nav_games) {
                selectedFragment = new ProfileFragment();
            }
            if (selectedFragment != null) {
                loadFragment(selectedFragment, itemId);
            }

            return true;
        });
    }


    /**
     * Load the selected fragment and update the stack.
     */
    private void loadFragment(Fragment fragment, int itemId) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();

        // Add the selected fragment to the stack
        if (!fragmentStack.isEmpty() && fragmentStack.peek() == itemId) {
            return; // Prevent duplicate entries
        }
        fragmentStack.push(itemId);
    }

    @Override
    public void onBackPressed() {
        // If the stack has more than one fragment, navigate back
        if (fragmentStack.size() > 1) {
            fragmentStack.pop(); // Remove the current fragment
            int previousItemId = fragmentStack.peek();

            // Navigate to the previous fragment
            Fragment previousFragment = null;
            if (previousItemId == R.id.nav_home) {
                previousFragment = new HomeFragment();
            } else if (previousItemId == R.id.nav_footprint) {
                previousFragment = new FootPrintFragment();
            } else if (previousItemId == R.id.nav_profile) {
                previousFragment = new ProfileFragment();
            } else if (previousItemId == R.id.nav_community) {
                previousFragment = new CommunityFragment();
            } else if (previousItemId == R.id.nav_games) {
                previousFragment = new ProfileFragment();
            }

            if (previousFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, previousFragment)
                        .commit();
                bottomNavigationView.setSelectedItemId(previousItemId);
            }
        } else {
            // If no fragments are left in the stack, exit the app
            super.onBackPressed();
        }
    }
}
