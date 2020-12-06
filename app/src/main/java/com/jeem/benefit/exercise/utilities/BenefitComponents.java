package com.jeem.benefit.exercise.utilities;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jeem.benefit.exercise.R;
import com.jeem.benefit.exercise.utilities.model.Exercises;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import static com.jeem.benefit.exercise.utilities.BenefitComponents.BenefitDialogFragment.DESCRIPTION;
import static com.jeem.benefit.exercise.utilities.BenefitComponents.BenefitDialogFragment.HELP_MESSAGE;

public class BenefitComponents {

    public static class ViewAnimator {

        // Indicates 100 milliseconds delay in sliding menu choices.
        private static final long DELAY = 100L;

        // Indicates 800 milliseconds duration in animating views.
        private static final long DURATION = 500L;

        // Indicates no delay in animating views.
        private static final long NO_DURATION = 0L;

        // Indicates 350 milliseconds delay until the Runnable will be executed.
        private static final long THREAD_DELAY = 350L;

        // Indicates 250 milliseconds delay until the Runnable will be executed.
        private static final long SHORT_DELAY = 250L;

        // Create a message queue which runs on UI thread.
        public static final Handler handler = new Handler(Looper.getMainLooper());

        /**
         * Slide's up the menu choices after signing in.
         *
         * @param container view to animate.
         */
        @MainThread
        public static void animateView(final View container) {
            handler.post(() -> container.animate()
                    .setDuration(NO_DURATION)
                    .translationY(container.getHeight())
                    .start());

            handler.postDelayed(() -> container.animate()
                    .translationY(0)
                    .setStartDelay(DELAY)
                    .setInterpolator(new DecelerateInterpolator())
                    .setDuration(DURATION), THREAD_DELAY);
        }

        /**
         * Show/hide menu choices as slide up or down animation.
         *
         * @param show      determine whether to show slide up animation.
         * @param container view to be animated.
         */
        public static void showMenuChoices(final boolean show, final View container) {

            if (!show) {
                final int height = container.getHeight();
                container.animate()
                        .translationY(height)
                        .setInterpolator(new AccelerateInterpolator())
                        .setDuration(SHORT_DELAY);
                return;
            }

            container.animate()
                    .translationY(0)
                    .setInterpolator(new AccelerateInterpolator())
                    .setDuration(SHORT_DELAY);
        }

        // Indicates 500 milliseconds delay before showing the barbell logo and Benefit title.
        private static final long VISIBILITY_DURATION = 500;

        /**
         * Display splash or loading screen when this app runs.
         *
         * @param splashContainer view to animate.
         */
        public static void showSplashScreen(RelativeLayout splashContainer) {
            handler.postDelayed(() -> splashContainer.animate()
                    .alpha(0f)
                    .setDuration(500)
                    .setInterpolator(new AccelerateInterpolator())
                    .start(), VISIBILITY_DURATION * 10);
        }

        public static void clickBackButton(Fragment f, CardView b) {
            b.setOnClickListener(v -> {
                Timer.cancelTimer();
                f.getActivity().onBackPressed();
            });
        }
    }

    /**
     * Static custom library work around for this Benefit app that extends {@link DialogFragment}
     */

    public static class BenefitDialogBuilder {

        /**
         * Start a series of edit operations on the Fragments
         * associated with this FragmentManager.
         */
        private static FragmentTransaction transaction;

        /**
         * Tag for identifying help dialog in backStack.
         */
        private static final String HELP_DIALOG = "HELP_DIALOG";

        /**
         * Tag for identifying workout description dialog in backStack.
         */
        private static final String MESSAGE_DIALOG = "MESSAGE_DIALOG";

        /**
         * Show question mark / help dialog
         *
         * @param fm The FragmentManager for interacting with fragments associated with this activity.
         */
        public static void showHelpDialog(final FragmentManager fm) {
            benefitDialogBuilder(fm, HELP_MESSAGE, null);
        }

        public static void showDescriptionMessage(final FragmentManager fm, final Object obj) {
            benefitDialogBuilder(fm, DESCRIPTION, obj);
        }

        private static void benefitDialogBuilder(final FragmentManager fm, final int helpMessage, final @Nullable Object obj) {
            final DialogFragment dialog = BenefitDialogFragment.newInstance(helpMessage, obj);

            transaction = fm.beginTransaction();

            final String tag = obj == null ? HELP_DIALOG : MESSAGE_DIALOG;

            findPreviousDialog(fm, tag);

            transaction.addToBackStack(null);

            // add to fragment transaction and show.
            dialog.show(transaction, tag);
        }

        /**
         * Find previous instance of {@link BenefitDialogFragment} that was shown and remove it.
         *
         * @param fm The FragmentManager for interacting with fragments associated with this activity.
         */
        private static void findPreviousDialog(FragmentManager fm, String tag) throws NullPointerException {
            final String dialogTag = tag == null ? HELP_DIALOG : MESSAGE_DIALOG;
            // check if previous help dialog is added
            final Fragment prevDialog = fm.findFragmentByTag(dialogTag);

            // remove previous dialog, prevent stacking up its instances.
            if (prevDialog != null && prevDialog.isAdded()) {
                transaction.remove(prevDialog);
                Log.e(null, "Removing");
            }
        }
    }

    public static class BenefitDialogFragment extends DialogFragment {

        private static final String CATEGORY = "CATEGORY_ARGS";

        private static final String WORKOUT_TITLE = "WORKOUT_TITLE_ARGS";

        private static final String WORKOUT_DESCRIPTION = "WORKOUT_DESCRIPTION_ARGS";

        public static final int HELP_MESSAGE = 0;

        public static final int DESCRIPTION = 1;

        public BenefitDialogFragment() {
            // required empty constructor
        }

        public static BenefitDialogFragment newInstance(final int category, final Object obj) {
            final BenefitDialogFragment benefitDialogFragment = new BenefitDialogFragment();
            final Bundle args = new Bundle();

            if (obj != null) {
                final Exercises exercises = (Exercises) obj;
                args.putString(WORKOUT_TITLE, exercises.getWorkoutName());
                args.putString(WORKOUT_DESCRIPTION, exercises.getDescription());
            }

            args.putInt(CATEGORY, category);
            benefitDialogFragment.setArguments(args);

            return benefitDialogFragment;
        }

        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            assert getDialog() != null;
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            View view;

            assert getArguments() != null;
            final int category = getArguments().getInt(CATEGORY);

            if (category == 1) {
                view = inflater.inflate(R.layout.description_dialog_fragment, container, false);

                final String title = getArguments().getString(WORKOUT_TITLE);
                ((TextView) view.findViewById(R.id.workout_title)).setText(title);

                final String description = getArguments().getString(WORKOUT_DESCRIPTION);
                ((TextView) view.findViewById(R.id.description_message)).setText(description);

                return view;
            }

            return inflater.inflate(R.layout.help_dialog_fragment, container, false);
        }
    }

    /**
     * Countdown timer for {@link com.jeem.benefit.exercise.main_menu.exercise.ExerciseFragment}
     */

    public static class Timer {

        // 1 second time interval
        public static final long INTERVAL = 1000L;

        private static CountDownTimer timer;

        public static void setCountDownTimer(long timeMillis, TextView countdownTimer, View check) {
            timer = new CountDownTimer(timeMillis + INTERVAL, INTERVAL) {
                @Override
                public void onTick(long millisUntilFinished) {
                    final String timeMillis = String.valueOf(millisUntilFinished / INTERVAL);
                    countdownTimer.setText(timeMillis);
                }

                @Override
                public void onFinish() {
                    countdownTimer.setText("");
                    check.setVisibility(View.VISIBLE);
                }
            }.start();
        }

        public static void cancelTimer() {
            if (timer != null) {
                timer.cancel();
            }
        }
    }

    public static class ChangeFragment {

        public static void bySlidingAnimation(FragmentManager fm, Fragment fragment, String tag) {
            changeFragment(fm, fragment, tag, false, true);
        }

        public static void byFadingAnimation(FragmentManager fm, Fragment fragment, String tag) {
            changeFragment(fm, fragment, tag, true, true);
        }

        public static void byLeftRightSlideAnimation(FragmentManager fm, Fragment fragment, String tag) {
            changeFragment(fm, fragment, tag, true, true);
        }

        public static void byAddSlidingAnimation(FragmentManager fm, Fragment fragment) {
            changeFragment(fm, fragment, null, false, false);
        }

        private static void changeFragment(FragmentManager fm, Fragment fragment, String tag, boolean defaultAnim, boolean replaceFragment) {
            final FragmentTransaction ft = fm.beginTransaction();

            if (!defaultAnim) {
                ft.setCustomAnimations(
                        R.anim.slide_in_up, R.anim.slide_in_down,
                        R.anim.slide_out_down, R.anim.slide_out_up
                );
            } else {
                ft.setCustomAnimations(
                        android.R.animator.fade_in, android.R.animator.fade_out
                );
            }

            if (replaceFragment) {
                ft.replace(R.id.fragment_container_view, fragment, tag);
            } else {
                ft.add(R.id.fragment_container_view, fragment, tag);
            }

            ft.addToBackStack(null)
                    .commit();
        }
    }

    public static class WorkoutAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private List<Exercises> exercises;

        private List<String> stringList;

        private OnWorkoutItemListener listener;

        private boolean isSetLogin = false;

        private WorkoutAdapter(List<Exercises> exercises, OnWorkoutItemListener listener, RecyclerView recyclerView) {
            this.exercises = exercises;
            this.listener = listener;
            setupWith(recyclerView);
        }

        private WorkoutAdapter(List<String> logs, RecyclerView recyclerView) {
            this.isSetLogin = true;
            this.stringList = logs;
            setupWith(recyclerView);
        }

        public static WorkoutAdapter createUserLogList(List<String> logs, RecyclerView recyclerView) {
            Log.e(null, String.valueOf(logs.size()));
            return new WorkoutAdapter(logs, recyclerView);
        }

        public static WorkoutAdapter createWorkoutExerciseList(String workout, OnWorkoutItemListener listener, RecyclerView recyclerView) {
            final List<Exercises> exercises = WorkoutContent.exerciseType(workout);
            return new WorkoutAdapter(exercises, listener, recyclerView);
        }

        public void setupWith(RecyclerView rv) {
            rv.setAdapter(this);
            rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            final LayoutInflater inflater = LayoutInflater.from(parent.getContext());

            View view;

            if (!isSetLogin) {
                view = inflater.inflate(R.layout.work_out_exercises_item, parent, false);
                return new WorkoutViewHolder(view, listener);
            }

            view = inflater.inflate(R.layout.logs_date, parent, false);
            return new LoginViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            if (!isSetLogin) {
                final Exercises exercises = this.exercises.get(position);
                ((WorkoutViewHolder) holder).bind(exercises.getWorkoutName());
                return;
            }

            final String logs = (String) stringList.get(position);
            ((LoginViewHolder) holder).bindDateLogs(logs);
        }

        @Override
        public int getItemCount() {
            return !isSetLogin ? exercises.size() : stringList.size();
        }

        public static class WorkoutViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            private OnWorkoutItemListener listener;
            private final TextView workoutTitle;

            public WorkoutViewHolder(@NonNull View itemView, @Nullable OnWorkoutItemListener listener) {
                super(itemView);
                if (listener != null) {
                    this.listener = listener;
                }
                workoutTitle = itemView.findViewById(R.id.workout_title);
                itemView.setOnClickListener(this);
            }

            public void bind(String title) {
                workoutTitle.setText(title);
            }

            @Override
            public void onClick(View v) {
                listener.onWorkoutItemClickListener(getAdapterPosition());
                v.setEnabled(false);
                ViewAnimator.handler.postDelayed(() -> v.setEnabled(true), 1000);
            }
        }

        public static class LoginViewHolder extends RecyclerView.ViewHolder {

            private final TextView logs;

            public LoginViewHolder(@NonNull View itemView) {
                super(itemView);
                logs = itemView.findViewById(R.id.date_logs);
            }

            public void bindDateLogs(String dateLogs) {
                logs.setText(dateLogs);
                Log.e(null, "binding " + dateLogs);
            }
        }

        public interface OnWorkoutItemListener {
            void onWorkoutItemClickListener(int index);
        }
    }

    public static class CalendarHelper {

        private static final Calendar calendar = Calendar.getInstance();

        public static String getMonth() {
            final int month = calendar.get(Calendar.MONTH);
            return getMonthByNumber(month);
        }

        private static String getMonthByNumber(int month) {
            final List<String> listOfMonths = new ArrayList<>(
                    Arrays.asList(
                            "January",
                            "February",
                            "March",
                            "April",
                            "May",
                            "June",
                            "July",
                            "August",
                            "September",
                            "October",
                            "November",
                            "December"
                    )
            );

            return listOfMonths.get(month);
        }

        private static String getCurrentTime() {
            final DateFormat format = new SimpleDateFormat("dd, yyyy HH:mm:ss", Locale.getDefault());
            return format.format(calendar.getTime());
        }

        public static String getDate() {
            return getMonth() + " " + getCurrentTime();
        }
    }

    public static class Utils {
        public static String formatName(String username) {
            return username.substring(0, 1).toUpperCase()
                    + username.substring(1).toLowerCase();
        }
    }

}
