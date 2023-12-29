package com.example.publicnewsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    private TextView tvUsername, tvRole;
    private Button btnLogout;

    private FirebaseAuth mAuth;
    private DatabaseReference userRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        // Initialize views
        tvUsername = findViewById(R.id.tv_username);
        tvRole = findViewById(R.id.tv_role);
        btnLogout = findViewById(R.id.btn_logout);

        // Initialize Firebase Authentication
        mAuth = FirebaseAuth.getInstance();

        // Check authentication state in onResume
        checkAuthenticationState();

        // Logout button click listener
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Sign out the user
                mAuth.signOut();
                // Redirect to the login page or wherever needed
                startActivity(new Intent(ProfileActivity.this, Login.class));
                finish();
            }
        });
    }

    // Check authentication state in onResume
    @Override
    protected void onResume() {
        super.onResume();
        checkAuthenticationState();
    }

    private void checkAuthenticationState() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null) {
            // User is not authenticated, redirect to login
            startActivity(new Intent(ProfileActivity.this, Login.class));
            finish();
        } else {
            // User is authenticated, load user details
            loadUserDetails(currentUser.getUid());
        }
    }

    // Load user details from Firebase Realtime Database
    private void loadUserDetails(String userId) {
        userRef = FirebaseDatabase.getInstance().getReference().child("User").child(userId);

        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // Get user details from the dataSnapshot
                    String username = dataSnapshot.child("username").getValue(String.class);
                    String role = dataSnapshot.child("role").getValue(String.class);

                    // Set user details to TextViews
                    tvUsername.setText("Username: " + username);
                    tvRole.setText("Role: " + role);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors
            }
        });
    }
}
