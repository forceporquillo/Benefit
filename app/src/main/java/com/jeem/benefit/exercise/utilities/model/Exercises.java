package com.jeem.benefit.exercise.utilities.model;

import androidx.annotation.DrawableRes;

public class Exercises {

    private final String workoutName;

    private final String description;

    private final String sets;

    private final @DrawableRes int imageId;

    private final long time;

    public Exercises(String workoutName, String description, String sets, long timeInSecs, int imageId) {
        this.workoutName = workoutName;
        this.description = description;
        this.sets = sets;
        this.time = timeInSecs;
        this.imageId = imageId;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public String getDescription() {
        return description;
    }

    public String getSets() {
        return sets;
    }

    public long getTime() {
        return time;
    }
    
    public int getImageId() {
        return imageId;
    }
}
