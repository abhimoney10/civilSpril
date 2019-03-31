package com.civilspril.app.com.civilspril.utilsFunctions;

import android.app.SearchManager;
import android.content.Context;
import android.content.SharedPreferences;

public class SaveDataManager {
    private Context context;
    public static final String SPIRAL_PREF="spiral_pref";
    public static final String USER_ID="id";
    public static final String USER_NAME="name";
    public static final String USER_EMAIL="email";
    public static final String TOKEN="token";
    private SharedPreferences sharedpreferences;
    private static SaveDataManager mInstance;
    public SaveDataManager(Context context){
        this.context = context;
         sharedpreferences = context.getSharedPreferences(SPIRAL_PREF, Context.MODE_PRIVATE);

    }

    public static SaveDataManager getInstance(Context context) {
        if (mInstance == null)
            mInstance = new SaveDataManager(context);
        return mInstance;
    }


    public String getUserId(){
       String user_id = sharedpreferences.getString(USER_ID, null);
        return user_id;
    }

    public void setUserId(String id){
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(USER_ID, id);
        editor.commit();

    }

    public String getUserName(){
        String user_name = sharedpreferences.getString(USER_NAME, null);
        return user_name;
    }

    public void setUserName(String name){
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(USER_NAME, name);
        editor.commit();

    }

    public String getUserEmail(){
        String user_email = sharedpreferences.getString(USER_EMAIL, null);
        return user_email;

    }

    public void setUserEmail(String email){
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(USER_EMAIL, email);
        editor.commit();
    }

    public String getToken(){

        String token = sharedpreferences.getString(TOKEN, null);
        return token;
    }

    public void setToken(String token){
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(TOKEN, token);
        editor.commit();
    }
}
