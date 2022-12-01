package edu.uga.cs.shareride;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class DriverMain extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_main);
        bottomNavigationView = findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.requested_ride);

        // When we open the application first
        // time the fragment should be shown to the user
        // in this case it is home fragment
    }
    Fragment newRideFrag = new NewRideFragment();
    Fragment requestedFrag = new RequestedRideFragment();
    Fragment postedFrag = new PostedRideFragment();
    Fragment confirmedFrag = new ConfirmedRideFragment();


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.requested_ride:
                getSupportFragmentManager().beginTransaction().replace(R.id.Frame, requestedFrag).commit();
                return true;
            case R.id.new_ride:
                getSupportFragmentManager().beginTransaction().replace(R.id.Frame, newRideFrag).commit();
                return true;
            case R.id.confirmed_ride:
                getSupportFragmentManager().beginTransaction().replace(R.id.Frame, confirmedFrag).commit();
                return true;
        }
        return false;
    }
}