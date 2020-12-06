package com.jeem.benefit.exercise.main_menu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.card.MaterialCardView;
import com.jeem.benefit.exercise.R;
import com.jeem.benefit.exercise.main_menu.workout.WorkoutFragment;
import com.jeem.benefit.exercise.utilities.BenefitComponents.ChangeFragment;
import com.jeem.benefit.exercise.utilities.BenefitComponents.ViewAnimator;
import com.jeem.benefit.exercise.utilities.model.User;

import java.util.List;

import static com.jeem.benefit.exercise.sharedpreferences.PersistenceManager.getUsers;
import static com.jeem.benefit.exercise.utilities.BenefitComponents.BenefitDialogBuilder.showHelpDialog;

public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView userTextView;

    private MaterialCardView cardView;

    public static final String USERNAME = "username_args";

    private String username;

    private final FragmentManager fm = getSupportFragmentManager();

    private final int[] navigationIds = new int[]{
            R.id.help,
            R.id.lower_body,
            R.id.upper_body,
            R.id.log_ins
    };

    // Change status bar color
    private void changeStatusBarColor() {
        getWindow().setStatusBarColor(
                ContextCompat.getColor(this, R.color.status_bar_color)
        );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        changeStatusBarColor();
        setContentView(R.layout.activity_main_menu);

        bindViews();

        if (getIntent() != null) {
            username = getIntent()
                    .getStringExtra(USERNAME).toUpperCase();
            setUsername();

            List<User> user = getUsers(this);

            if (!user.isEmpty()) {
                for (User users : user) {
                    Log.d(null, "Username" + users.getUsername());
                    Log.d(null, "Date" + users.getDateList());
                }
            }
        }
    }

    private void bindViews() {
        // Add click listener for help, upper body,
        // lower body, and login buttons.
        for (int id : navigationIds) {
            findViewById(id).setOnClickListener(this);
        }

        userTextView = findViewById(R.id.username_textView);
        cardView = findViewById(R.id.material_card_view);

        ViewAnimator.animateView(cardView);
    }

    /**
     * Set the username to {@link TextView}.
     */
    private void setUsername() {
        // find string "Hey!, " from string resource
        // and concatenate to username.
        // eg. Test > Hey!, Test
        final String hey = getString(R.string.hey);

        userTextView.setText(hey.concat(username));
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.help:
                // Display help dialog.
                showHelpDialog(fm);
                break;
            case R.id.upper_body:
                setWorkoutTypeFragment("Upper Body");
                break;
            case R.id.lower_body:
                setWorkoutTypeFragment("Lower Body");
                break;
            case R.id.log_ins:
                setUserLogin();
                break;
        }

        v.setEnabled(false);

        new Handler(getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                v.setEnabled(true);
            }
        }, 1000);
    }

    /**
     * @param workout specifies what type of workout exercises and title.
     */
    private void setWorkoutTypeFragment(final String workout) {
        ViewAnimator.showMenuChoices(false, cardView);
        final Fragment workoutFragment = WorkoutFragment.newInstance(workout);
        ChangeFragment.bySlidingAnimation(fm, workoutFragment, workout);
    }

    private void setUserLogin() {
        ViewAnimator.showMenuChoices(false, cardView);
        final Fragment userLoginFragment = ViewUserLoginFragment.newInstance(username);
        ChangeFragment.bySlidingAnimation(fm, userLoginFragment, "login");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if (fm.getBackStackEntryCount() == 0) {
            ViewAnimator.showMenuChoices(true, cardView);
        }

    }
}