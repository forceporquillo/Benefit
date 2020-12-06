package com.jeem.benefit.exercise.main_menu.workout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.jeem.benefit.exercise.R;
import com.jeem.benefit.exercise.main_menu.exercise.ExerciseFragment;
import com.jeem.benefit.exercise.utilities.BenefitComponents.WorkoutAdapter;
import com.jeem.benefit.exercise.utilities.BenefitComponents.ChangeFragment;

import static com.jeem.benefit.exercise.utilities.BenefitComponents.ViewAnimator.clickBackButton;
import static com.jeem.benefit.exercise.utilities.BenefitComponents.WorkoutAdapter.createWorkoutExerciseList;

public class WorkoutFragment extends Fragment implements WorkoutAdapter.OnWorkoutItemListener {

    private static final String TITLE_ARGS = "TITLE_ARGS";

    private String workout;

    public WorkoutFragment() {
        // Required empty public constructor
    }

    public static WorkoutFragment newInstance(final String title) {
        WorkoutFragment fragment = new WorkoutFragment();
        Bundle args = new Bundle();
        args.putString(TITLE_ARGS, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_workout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            workout = getArguments().getString(TITLE_ARGS);
            setWorkoutTitle(view);
        }

        final RecyclerView rv = view.findViewById(R.id.recycler_view);
        setupListExercises(rv);

        final CardView backButton = view.findViewById(R.id.back_button_container);

        clickBackButton(this, backButton);
    }

    private void setWorkoutTitle(View view) {
        TextView workoutTitle = view.findViewById(R.id.workout_title);
        workoutTitle.setText(workout);
    }

    private void setupListExercises(RecyclerView recyclerView) {
        createWorkoutExerciseList(workout, this, recyclerView);
    }

    @Override
    public void onWorkoutItemClickListener(int index) {
        final Fragment exerciseFragment = ExerciseFragment.newInstance(index, workout);
        ChangeFragment.byAddSlidingAnimation(getParentFragmentManager(), exerciseFragment);
    }
}