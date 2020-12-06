package com.jeem.benefit.exercise;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jeem.benefit.exercise.main_menu.MainMenuActivity;

import static com.jeem.benefit.exercise.main_menu.MainMenuActivity.USERNAME;
import static com.jeem.benefit.exercise.sharedpreferences.PersistenceManager.storeUser;
import static com.jeem.benefit.exercise.sharedpreferences.PersistenceManager.storeUserTest;
import static com.jeem.benefit.exercise.utilities.BenefitComponents.ViewAnimator.showSplashScreen;

public class SignInActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_activity);

        final EditText usernameET = findViewById(R.id.username_editText);
        final Button signInButton = findViewById(R.id.signInButton);

        final RelativeLayout container = findViewById(R.id.splash_container);
        showSplashScreen(container);

        signInButton.setOnClickListener(v -> {
            final String username = usernameET.getText().toString();
            signInButton(username);
        });
    }

    private void signInButton(final String username) {
        if (username.equals("")) {
            Toast.makeText(getApplicationContext(), "You must add username", Toast.LENGTH_SHORT).show();
            return;
        }

        navigateToMainMenu(username);
        writeToSharedPrefs(username);
    }

    private void navigateToMainMenu(final String username) {
        final Intent intent = new Intent(this, MainMenuActivity.class);
        intent.putExtra(USERNAME, username);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        startActivity(intent);
        finish();
    }

    private void writeToSharedPrefs(String username) {
        storeUserTest(this, username);
    }
}