package com.jeem.benefit.exercise.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeem.benefit.exercise.utilities.model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import static com.jeem.benefit.exercise.utilities.BenefitComponents.CalendarHelper.getDate;
import static com.jeem.benefit.exercise.utilities.BenefitComponents.PersistenceManager.saveToSharedPref;
import static com.jeem.benefit.exercise.utilities.BenefitComponents.Utils.formatName;

public class PersistenceManager {

    private static final String PREFERENCE_KEY_SUFFIX = "preferences";

    private static SharedPreferences preferences;

    public static List<User> getUserData(Context ctx) {
        List<User> list;
        preferences = PreferenceManager.getDefaultSharedPreferences(ctx);

        String userList = preferences.getString(hashCode(ctx), null);

        final Gson gson = new Gson();
        Type userListType = new TypeToken<List<User>>() {}.getType();
        list = gson.fromJson(userList, userListType);

        return list;
    }

    private static List<User> getUserDataFromSharedPref(Context ctx) {
        final Gson gson = new Gson();

        preferences = PreferenceManager.getDefaultSharedPreferences(ctx);

        String userPrefs = preferences.getString(hashCode(ctx), null);

        final Type userTypeList = new TypeToken<List<User>>() {
        }.getType();

        return gson.fromJson(userPrefs, userTypeList);
    }

    private static void addInJSONArray(Context ctx, User user) {
        preferences = PreferenceManager.getDefaultSharedPreferences(ctx);

        final Gson gson = new Gson();

        final String userSaveFromPref = preferences.getString(hashCode(ctx), null);
        final String jsonNewUserToAdd = gson.toJson(user);

        JSONArray array = new JSONArray();

        try {
            if (userSaveFromPref.length() != 0) {
                array = new JSONArray(userSaveFromPref);
            }
            array.put(new JSONObject(jsonNewUserToAdd));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(hashCode(ctx), jsonNewUserToAdd).apply();
    }

    private static String hashCode(Context ctx) {
        return ctx.getPackageName() + "." + PREFERENCE_KEY_SUFFIX;
    }

    public static void storeUser(Context ctx, String username) {
        saveToSharedPref(ctx, username);
    }

//    private static void saveToSharedPref(final Context ctx, final String user) {
//        preferences = PreferenceManager.getDefaultSharedPreferences(ctx);
//        SharedPreferences.Editor editor = preferences.edit();
//
//        final Gson gson = new Gson();
//        final String username = formatName(user);
//        List<User> userList = getUsers(ctx);
//
//        if (userList != null) {
//            userList.add(new User(username, getDate()));
//        } else {
//            userList = Collections.singletonList(new User(username, getDate()));
//        }
//
//        final String serializeObject = gson.toJson(userList);
//        editor.putString(hashCode(ctx), serializeObject).apply();
//    }
//
//    public static List<User> getUsers(Context ctx) {
//        preferences = PreferenceManager.getDefaultSharedPreferences(ctx);
//
//        String listUsers = preferences.getString(hashCode(ctx), null);
//
//        if (listUsers != null) {
//            Gson gson = new Gson();
//            Type userType = new TypeToken<List<User>>() {
//            }.getType();
//
//            return gson.fromJson(listUsers, userType);
//        }
//        return null;
//    }

}
