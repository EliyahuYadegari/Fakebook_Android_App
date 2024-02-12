package com.example.faceapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import java.io.ByteArrayOutputStream;

public class UserLocalStore {
    public static final String SP_NAME = "userDetails";
    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context){
        userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
    }
    public void storeUserData(User user){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putString("username", user.username);
        spEditor.putString("password", user.password);
        spEditor.putString("firstName", user.first_name);
        spEditor.putString("lastName", user.last_name);

        if(user.profile_picture != null){
            spEditor.putString("profile_picture_uri", user.profile_picture.toString());
        }
        spEditor.commit();
    }
    public User getLoggedInUser(){
        String firstName = userLocalDatabase.getString("firstName", "");
        String lastName = userLocalDatabase.getString("lastName", "");
        String username = userLocalDatabase.getString("username", "");
        String password = userLocalDatabase.getString("password", "");
        // Get the URI of the profile picture
        String profilePictureUriString = userLocalDatabase.getString("profile_picture_uri", "");
        Uri profilePictureUri = null;
        if(!profilePictureUriString.isEmpty()){
            profilePictureUri = Uri.parse(profilePictureUriString);
        }


        User storedUser = new User(firstName, lastName, username, password, profilePictureUri);
        return storedUser;
    }
    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn", loggedIn);
        spEditor.commit();
    }

    public void clearUserData(){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
}
