package com.jeem.benefit.exercise.utilities;

import com.jeem.benefit.exercise.R;
import com.jeem.benefit.exercise.utilities.model.Exercises;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton object class for retrieving
 * hard-coded values of workout contents.
 */
public class WorkoutContent {

    private static final String UPPER_BODY = "Upper Body";

    public static List<Exercises> exerciseType(String workout) {
        return workout.equals(UPPER_BODY) ? upperBodyWorkoutList() : lowerBodyWorkoutList();
    }

    /**
     * A workout content for Upper Body.
     *
     * @return list of exercises for upper body
     */
    private static List<Exercises> upperBodyWorkoutList() {
        final List<Exercises> list = new ArrayList<>();

        list.add(new Exercises(
                        "Bicep Extension",
                        "This exercise will tone your arms and add strength to your body. " +
                                "Instructions: While holding a dumbbell in one hand, bend your knees " +
                                "forward and arch your torso forward from the waist.",
                        "10 reps, 3 sets", 0L,
                        R.drawable.img_bicep_extension
                )
        );

        list.add(new Exercises(
                        "Tricep push-ups",
                        "In this exercise, your palms will stay closer together with your " +
                                "arms directly at your sides as you lower, which engages your tricep " +
                                "muscles to drive you back to the starting plank position.",
                        "10 reps, 3 sets",
                        0,
                        R.drawable.img_tricep_pushup
                )
        );


        list.add(new Exercises(
                        "Planking",
                        "The plank strengthens your spine, your rhomboids and trapezius, " +
                                "and your abdominal muscles, which naturally result in a strong " +
                                "posture as they grow in strength.The palms of the hands are typically " +
                                "touching the sides of the body and the toes are typically touching the ground.",
                        "30 seconds timer",
                        30000L,
                        R.drawable.img_planking
                )
        );

        list.add(new Exercises(
                        "Jump switch lunge",
                        "To help you move explosively, propel your arms into the air while" +
                                " you jump. Gently land back on the floor in a basic lunge position " +
                                "with the opposite leg forward. Repeat this movement pattern, switching" +
                                " legs on each jump, for the desired amount of time or repetitions.",
                        "15 reps, 3 sets",
                        0L,
                        R.drawable.img_jump_switch_lunge
                )
        );

        list.add(new Exercises(
                        "Sit-ups",
                        "The sit-up is an abdominal endurance training exercise to strengthen, " +
                                "tighten and tone the abdominal muscles.It begins with lying with the " +
                                "back on the floor, typically with the arms across the chest or hands " +
                                "behind the head and the knees bent in an attempt to reduce stress on " +
                                "the back muscles and spine, and then elevating both the upper and " +
                                "lower vertebrae from the floor until everything superior to the " +
                                "buttocks is not touching the ground.",
                        "20 reps, 3 sets",
                        0L,
                        R.drawable.img_sit_ups
                )
        );


        // add

        list.add(new Exercises(
                        "Bicep Extension",
                        "This exercise will tone your arms and add strength to your body. " +
                                "Instructions: While holding a dumbbell in one hand, bend your knees " +
                                "forward and arch your torso forward from the waist.",
                        "10 reps, 3 sets", 0L,
                        R.drawable.img_bicep_extension
                )
        );

        list.add(new Exercises(
                        "Tricep push-ups",
                        "In this exercise, your palms will stay closer together with your " +
                                "arms directly at your sides as you lower, which engages your tricep " +
                                "muscles to drive you back to the starting plank position.",
                        "10 reps, 3 sets",
                        0L,
                        R.drawable.img_tricep_pushup
                )
        );


        list.add(new Exercises(
                        "Planking",
                        "The plank strengthens your spine, your rhomboids and trapezius, " +
                                "and your abdominal muscles, which naturally result in a strong " +
                                "posture as they grow in strength.The palms of the hands are typically " +
                                "touching the sides of the body and the toes are typically touching the ground.",
                        "30 seconds timer",
                        30000L,
                        R.drawable.img_planking
                )
        );

        list.add(new Exercises(
                        "Jump switch lunge",
                        "To help you move explosively, propel your arms into the air while" +
                                " you jump. Gently land back on the floor in a basic lunge position " +
                                "with the opposite leg forward. Repeat this movement pattern, switching" +
                                " legs on each jump, for the desired amount of time or repetitions.",
                        "15 reps, 3 sets",
                        0L,
                        R.drawable.img_jump_switch_lunge
                )
        );

        list.add(new Exercises(
                        "Sit-ups",
                        "The sit-up is an abdominal endurance training exercise to strengthen, " +
                                "tighten and tone the abdominal muscles.It begins with lying with the " +
                                "back on the floor, typically with the arms across the chest or hands " +
                                "behind the head and the knees bent in an attempt to reduce stress on " +
                                "the back muscles and spine, and then elevating both the upper and " +
                                "lower vertebrae from the floor until everything superior to the " +
                                "buttocks is not touching the ground.",
                        "20 reps, 3 sets",
                        0L,
                        R.drawable.img_sit_ups
                )
        );

        list.add(new Exercises(
                        "Bicep Extension",
                        "This exercise will tone your arms and add strength to your body. " +
                                "Instructions: While holding a dumbbell in one hand, bend your knees " +
                                "forward and arch your torso forward from the waist.",
                        "10 reps, 3 sets", 0L,
                        R.drawable.img_bicep_extension
                )
        );

        list.add(new Exercises(
                        "Tricep push-ups",
                        "In this exercise, your palms will stay closer together with your " +
                                "arms directly at your sides as you lower, which engages your tricep " +
                                "muscles to drive you back to the starting plank position.",
                        "10 reps, 3 sets",
                        0L,
                        R.drawable.img_tricep_pushup
                )
        );


        list.add(new Exercises(
                        "Planking",
                        "The plank strengthens your spine, your rhomboids and trapezius, " +
                                "and your abdominal muscles, which naturally result in a strong " +
                                "posture as they grow in strength.The palms of the hands are typically " +
                                "touching the sides of the body and the toes are typically touching the ground.",
                        "30 seconds timer",
                        30000L,
                        R.drawable.img_planking
                )
        );

        list.add(new Exercises(
                        "Jump switch lunge",
                        "To help you move explosively, propel your arms into the air while" +
                                " you jump. Gently land back on the floor in a basic lunge position " +
                                "with the opposite leg forward. Repeat this movement pattern, switching" +
                                " legs on each jump, for the desired amount of time or repetitions.",
                        "15 reps, 3 sets",
                        0L,
                        R.drawable.img_jump_switch_lunge
                )
        );

        list.add(new Exercises(
                        "Sit-ups",
                        "The sit-up is an abdominal endurance training exercise to strengthen, " +
                                "tighten and tone the abdominal muscles.It begins with lying with the " +
                                "back on the floor, typically with the arms across the chest or hands " +
                                "behind the head and the knees bent in an attempt to reduce stress on " +
                                "the back muscles and spine, and then elevating both the upper and " +
                                "lower vertebrae from the floor until everything superior to the " +
                                "buttocks is not touching the ground.",
                        "20 reps, 3 sets",
                        0L,
                        R.drawable.img_sit_ups
                )
        );


        return list;

    }

    /**
     * A workout content for Lower Body.
     *
     * @return list of exercises for lower body
     */
    private static List<Exercises> lowerBodyWorkoutList() {
        final List<Exercises> list = new ArrayList<>();

        list.add(new Exercises(
                        "Calf Raises",
                        "The calf raise is an excellent place to start. " +
                                "It’s an easy exercise to do anywhere – you can knock out a set " +
                                "while brushing your teeth or waiting for the kettle to boil – " +
                                "and strong calves are essential to strong running." +
                                "\n" +
                                "Stand up straight, then push through the balls of your feet and " +
                                "raise your heel until you are standing on your toes. Then lower " +
                                "slowly back to the start. It’s also suggested to add weight on " +
                                "yourself to get better results.",
                        "30 reps, 3 sets",
                        0L,
                        R.drawable.img_calf_raises
                )
        );

        list.add(new Exercises(
                        "Crossover kicks",
                        "The traditional execution of this exercise is the best for beginners. " +
                                "Focus on form, ensuring the back isn’t sagging and your glute is doing the work.\n" +
                                "Assume the starting position on all fours: knees hip-width apart, " +
                                "hands under your shoulders, neck and spine neutral.Bracing your core, " +
                                "begin to lift your right leg, knee staying bent, foot staying flat, " +
                                "and hinging at the hip.Use your glute to press your foot directly " +
                                "toward the ceiling and squeeze at the top. Ensure your pelvis and " +
                                "working hip stay pointed toward the ground.Return to the starting position",
                        "15 reps and 3 sets",
                        0L,
                        R.drawable.img_crossover_kicks
                )
        );

        list.add(new Exercises(
                        "Squats",
                        "Squats strengthen your lower body and core muscles. " +
                                "Squats mainly work your lower body, specifically your quadriceps and glutes." +
                                "\n" +
                                "To do a basic squat: Start with your feet slightly wider than hip-width apart. " +
                                "Keep your chest up, engage your abdominals, and shift your weight onto" +
                                " your heels as you push your hips back into a sitting position. " +
                                "Lower your hips until your thighs are parallel or almost parallel to the floor.",
                        "30 reps, 3 sets",
                        0L,
                        R.drawable.img_squats
                )
        );

        list.add(new Exercises(
                        "Burpees",
                        "The burpee, a squat thrust with an additional stand between reps, " +
                                "is a full body exercise used in strength training and as an aerobic exercise. " +
                                "Begin in a standing position, Move into a squat position with your hands on the ground, " +
                                "Kick your feet back into a plank position, while keeping your arms extended, " +
                                "Immediately return your feet into squat position, Stand up from the squat position.",
                        "10 reps and 2 sets",
                        0L,
                        R.drawable.img_burpees
                )
        );

        list.add(new Exercises(
                        "Mountain Climb",
                        "The mountain climber is a classic ab exercise, and we love it because " +
                                "it will strengthen your core as you simultaneously work on your cardio " +
                                "and muscular endurance." +
                                "\n" +
                                "Start in a traditional plank with your shoulders directly over your " +
                                "hands and wrists.lift up your right knee, bringing it toward your elbow. " +
                                "Return the right knee back to the starting position as you simultaneously " +
                                "drive your left knee up toward your left elbow. Return to the starting position.\n",
                        "60 seconds",
                        60000L,
                        R.drawable.img_mountain_climber
                )
        );

        // add

        list.add(new Exercises(
                        "Calf Raises",
                        "The calf raise is an excellent place to start. " +
                                "It’s an easy exercise to do anywhere – you can knock out a set " +
                                "while brushing your teeth or waiting for the kettle to boil – " +
                                "and strong calves are essential to strong running." +
                                "\n" +
                                "Stand up straight, then push through the balls of your feet and " +
                                "raise your heel until you are standing on your toes. Then lower " +
                                "slowly back to the start. It’s also suggested to add weight on " +
                                "yourself to get better results.",
                        "30 reps, 3 sets",
                        0L,
                        R.drawable.img_calf_raises
                )
        );

        list.add(new Exercises(
                        "Crossover kicks",
                        "The traditional execution of this exercise is the best for beginners. " +
                                "Focus on form, ensuring the back isn’t sagging and your glute is doing the work.\n" +
                                "Assume the starting position on all fours: knees hip-width apart, " +
                                "hands under your shoulders, neck and spine neutral.Bracing your core, " +
                                "begin to lift your right leg, knee staying bent, foot staying flat, " +
                                "and hinging at the hip.Use your glute to press your foot directly " +
                                "toward the ceiling and squeeze at the top. Ensure your pelvis and " +
                                "working hip stay pointed toward the ground.Return to the starting position",
                        "15 reps and 3 sets",
                        0L,
                        R.drawable.img_crossover_kicks
                )
        );

        list.add(new Exercises(
                        "Squats",
                        "Squats strengthen your lower body and core muscles. " +
                                "Squats mainly work your lower body, specifically your quadriceps and glutes." +
                                "\n" +
                                "To do a basic squat: Start with your feet slightly wider than hip-width apart. " +
                                "Keep your chest up, engage your abdominals, and shift your weight onto" +
                                " your heels as you push your hips back into a sitting position. " +
                                "Lower your hips until your thighs are parallel or almost parallel to the floor.",
                        "30 reps, 3 sets",
                        0L,
                        R.drawable.img_squats
                )
        );

        list.add(new Exercises(
                        "Burpees",
                        "The burpee, a squat thrust with an additional stand between reps, " +
                                "is a full body exercise used in strength training and as an aerobic exercise. " +
                                "Begin in a standing position, Move into a squat position with your hands on the ground, " +
                                "Kick your feet back into a plank position, while keeping your arms extended, " +
                                "Immediately return your feet into squat position, Stand up from the squat position.",
                        "10 reps and 2 sets",
                        0L,
                        R.drawable.img_burpees
                )
        );

        list.add(new Exercises(
                        "Mountain Climb",
                        "The mountain climber is a classic ab exercise, and we love it because " +
                                "it will strengthen your core as you simultaneously work on your cardio " +
                                "and muscular endurance." +
                                "\n" +
                                "Start in a traditional plank with your shoulders directly over your " +
                                "hands and wrists.lift up your right knee, bringing it toward your elbow. " +
                                "Return the right knee back to the starting position as you simultaneously " +
                                "drive your left knee up toward your left elbow. Return to the starting position.\n",
                        "60 seconds",
                        60000L,
                        R.drawable.img_mountain_climber
                )
        );

        list.add(new Exercises(
                        "Calf Raises",
                        "The calf raise is an excellent place to start. " +
                                "It’s an easy exercise to do anywhere – you can knock out a set " +
                                "while brushing your teeth or waiting for the kettle to boil – " +
                                "and strong calves are essential to strong running." +
                                "\n" +
                                "Stand up straight, then push through the balls of your feet and " +
                                "raise your heel until you are standing on your toes. Then lower " +
                                "slowly back to the start. It’s also suggested to add weight on " +
                                "yourself to get better results.",
                        "30 reps, 3 sets",
                        0L,
                        R.drawable.img_calf_raises
                )
        );

        list.add(new Exercises(
                        "Crossover kicks",
                        "The traditional execution of this exercise is the best for beginners. " +
                                "Focus on form, ensuring the back isn’t sagging and your glute is doing the work.\n" +
                                "Assume the starting position on all fours: knees hip-width apart, " +
                                "hands under your shoulders, neck and spine neutral.Bracing your core, " +
                                "begin to lift your right leg, knee staying bent, foot staying flat, " +
                                "and hinging at the hip.Use your glute to press your foot directly " +
                                "toward the ceiling and squeeze at the top. Ensure your pelvis and " +
                                "working hip stay pointed toward the ground.Return to the starting position",
                        "15 reps and 3 sets",
                        0L,
                        R.drawable.img_crossover_kicks
                )
        );

        list.add(new Exercises(
                        "Squats",
                        "Squats strengthen your lower body and core muscles. " +
                                "Squats mainly work your lower body, specifically your quadriceps and glutes." +
                                "\n" +
                                "To do a basic squat: Start with your feet slightly wider than hip-width apart. " +
                                "Keep your chest up, engage your abdominals, and shift your weight onto" +
                                " your heels as you push your hips back into a sitting position. " +
                                "Lower your hips until your thighs are parallel or almost parallel to the floor.",
                        "30 reps, 3 sets",
                        0L,
                        R.drawable.img_squats
                )
        );

        list.add(new Exercises(
                        "Burpees",
                        "The burpee, a squat thrust with an additional stand between reps, " +
                                "is a full body exercise used in strength training and as an aerobic exercise. " +
                                "Begin in a standing position, Move into a squat position with your hands on the ground, " +
                                "Kick your feet back into a plank position, while keeping your arms extended, " +
                                "Immediately return your feet into squat position, Stand up from the squat position.",
                        "10 reps and 2 sets",
                        0L,
                        R.drawable.img_burpees
                )
        );

        list.add(new Exercises(
                        "Mountain Climb",
                        "The mountain climber is a classic ab exercise, and we love it because " +
                                "it will strengthen your core as you simultaneously work on your cardio " +
                                "and muscular endurance." +
                                "\n" +
                                "Start in a traditional plank with your shoulders directly over your " +
                                "hands and wrists.lift up your right knee, bringing it toward your elbow. " +
                                "Return the right knee back to the starting position as you simultaneously " +
                                "drive your left knee up toward your left elbow. Return to the starting position.\n",
                        "60 seconds",
                        60000L,
                        R.drawable.img_mountain_climber
                )
        );


        return list;
    }
}
