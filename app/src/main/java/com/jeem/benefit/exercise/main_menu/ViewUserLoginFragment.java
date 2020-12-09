package com.jeem.benefit.exercise.main_menu;

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

import static com.jeem.benefit.exercise.utilities.BenefitComponents.CalendarHelper.getMonth;
import static com.jeem.benefit.exercise.utilities.BenefitComponents.Utils.formatName;
import static com.jeem.benefit.exercise.utilities.BenefitComponents.ViewAnimator.clickBackButton;
import static com.jeem.benefit.exercise.utilities.BenefitComponents.WorkoutAdapter.createUserLogList;

public class ViewUserLoginFragment extends Fragment {

    private static final String USERNAME = "USERNAME_ARGS";

    public ViewUserLoginFragment() {
        // Required empty public constructor
    }

    public static ViewUserLoginFragment newInstance(String username) {
        ViewUserLoginFragment fragment = new ViewUserLoginFragment();
        Bundle args = new Bundle();
        args.putString(USERNAME, username);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view_user_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setViews(view);

        if (getArguments() != null) {
            String username = formatName(getArguments().getString(USERNAME));
            RecyclerView rv = view.findViewById(R.id.date_recyclerview);
            setList(rv, username);
        }
    }

    private void setViews(View view) {
        TextView currentMonth = view.findViewById(R.id.month);
        CardView backButton = view.findViewById(R.id.back_button_container);


        // set current month
        currentMonth.setText(getMonth());

        // back button
        clickBackButton(this, backButton);
    }

    private void setList(RecyclerView rv, String username) {
        createUserLogList(rv, username);
    }
}