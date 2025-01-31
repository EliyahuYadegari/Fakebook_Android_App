package com.example.faceapp.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;

import com.example.faceapp.model.PublicUser;
import com.example.faceapp.model.User;
import com.example.faceapp.utilities.Constraints;

public class UserLocalStore {
    public static final String SP_NAME = "userDetails";
    private Constraints constraints;
    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context){
        userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
        constraints = new Constraints();
    }
    public void storeUserData(User user, String token){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putString("username", user.email);
        spEditor.putString("password", user.password);
        spEditor.putString("firstName", user.firstName);
        spEditor.putString("lastName", user.lastName);
        spEditor.putString("jwt_token", token);

        if(user.profilePhoto != null){
            spEditor.putString("profile_picture_uri", user.profilePhoto.toString());
        }
        spEditor.commit();
    }
    public User getLoggedInUser(){
        if(!userLocalDatabase.contains("username"))
            return null;
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

    public PublicUser getLoggedInPublicUser(){
        String username = userLocalDatabase.getString("firstName", "") + " " + userLocalDatabase.getString("lastName", "");

        // Get the URI of the profile picture
        String profilePictureUriString = userLocalDatabase.getString("profile_picture_uri", "");
        Uri profilePictureUri = null;
        if(!profilePictureUriString.isEmpty()){
            profilePictureUri = Uri.parse(profilePictureUriString);
        }

        PublicUser storedUser = new PublicUser(username, profilePictureUri);
        return storedUser;
    }
    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn", loggedIn);
        spEditor.commit();
    }

    public boolean getLoggedIn(){
        return userLocalDatabase.getBoolean("loggedIn", false);
    }

    public void clearUserData(){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }

    public void login(String username, String password) throws Exception{
        //sets current username password of signed user
        String mUsername = userLocalDatabase.getString("username", "");
        String mPassword = userLocalDatabase.getString("password", "");
        // checks if the one trying to log in is signed up
        if (username.equals(mUsername) && password.equals(mPassword)){
            setUserLoggedIn(true);
            return;
        }
        throw new Exception("Invalid username or password");
    }

    public String getToken() {
        return userLocalDatabase.getString("jwt_token", null);
    }
}
