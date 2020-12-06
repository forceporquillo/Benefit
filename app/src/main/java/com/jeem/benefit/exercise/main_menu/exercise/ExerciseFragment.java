package com.jeem.benefit.exercise.main_menu.exercise;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.jeem.benefit.exercise.R;
import com.jeem.benefit.exercise.utilities.WorkoutContent;
import com.jeem.benefit.exercise.utilities.model.Exercises;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static com.jeem.benefit.exercise.utilities.BenefitComponents.BenefitDialogBuilder.showDescriptionMessage;
import static com.jeem.benefit.exercise.utilities.BenefitComponents.Timer.setCountDownTimer;
import static com.jeem.benefit.exercise.utilities.BenefitComponents.ViewAnimator.clickBackButton;


public class ExerciseFragment extends Fragment {

    private static final String INDEX_ARGS = "index_args";
    private static final String WORKOUT_TYPE = "workout_type_args";

    private TextView workoutName;
    private TextView workoutDescription;
    private TextView workoutTimer;
    private ImageView workoutImage;
    private CardView countdownContainer;
    private TextView countdownTimer;
    private View check;
    private CardView startButton;
    private FloatingActionButton floatingActionButton;

    public ExerciseFragment() {
        // Required empty public constructor
    }

    public static ExerciseFragment newInstance(int index, String workout) {
        ExerciseFragment fragment = new ExerciseFragment();
        Bundle args = new Bundle();

        args.putInt(INDEX_ARGS, index);
        args.putString(WORKOUT_TYPE, workout);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_exercise, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.bindViews(view);

        if (getArguments() != null) {
            final int index = getArguments().getInt(INDEX_ARGS);
            final String exerciseType = getArguments().getString(WORKOUT_TYPE);
            final Exercises exercises = WorkoutContent.exerciseType(exerciseType).get(index);

            setExerciseContent(exercises);

            if (exercises.getTime() != 0L) {
                startButton.setOnClickListener(v -> {
                    startButton.setVisibility(View.GONE);
                    clickStart(exercises);
                });
            } else {
                startButton.setVisibility(View.GONE);
            }

            viewMessageButton(exercises);
        }
    }

    private void viewMessageButton(Exercises exercises) {
        floatingActionButton.setOnClickListener(v ->
                showDescriptionMessage(getChildFragmentManager(), exercises)
        );
    }

    private void bindViews(View view) {
        workoutName = view.findViewById(R.id.workout_name);
        workoutDescription = view.findViewById(R.id.description);
        workoutTimer = view.findViewById(R.id.timer_category);
        workoutImage = view.findViewById(R.id.image_view);
        countdownContainer = view.findViewById(R.id.countdown_container);
        countdownTimer = view.findViewById(R.id.countdown_timer);
        check = view.findViewById(R.id.check);
        startButton = view.findViewById(R.id.start_container);
        floatingActionButton = view.findViewById(R.id.floating_bar);



        final CardView backButton = view.findViewById(R.id.back_button_container);

        // back press if back button is clicked.
        clickBackButton(this, backButton);
    }

    private void clickStart(Exercises exercises) {
        countdownContainer.setVisibility(View.VISIBLE);

        final long timeMillis = exercises.getTime();

        setCountDownTimer(timeMillis, countdownTimer, check);
        showWorkoutContent();
    }

    private void showWorkoutContent() {
        workoutDescription.setVisibility(View.GONE);
        workoutTimer.setVisibility(View.GONE);
        floatingActionButton.setVisibility(View.GONE);
    }

    private void setExerciseContent(Exercises exercises) {
        // set workout name
        String workoutName = exercises.getWorkoutName();
        setWorkoutName(workoutName);

        // set workout description
        String workoutDescription = exercises.getDescription();
        setWorkoutDescription(workoutDescription);

        // set workout image
        int workoutImage = exercises.getImageId();
        setWorkoutImage(workoutImage);

        // set workout timer
        String workoutTimer = exercises.getTime() == 0
                ? exercises.getSets()
                : (exercises.getTime() / 1000) + " Seconds";
        setWorkoutTimer(workoutTimer);
    }

    private void setWorkoutName(String name) {
        workoutName.setText(name);
    }

    private void setWorkoutDescription(String description) {
        workoutDescription.setText(description);
    }

    private void setWorkoutImage(int image) {
        workoutImage.setBackgroundResource(image);
    }

    private void setWorkoutTimer(String timer) {
        workoutTimer.setText(timer);
    }
}