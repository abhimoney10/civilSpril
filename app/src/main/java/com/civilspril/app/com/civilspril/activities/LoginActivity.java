package com.civilspril.app.com.civilspril.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.civilspril.app.R;
import com.civilspril.app.com.civilspril.beans.CategoryList;
import com.civilspril.app.com.civilspril.beans.LoginData;
import com.civilspril.app.com.civilspril.networkManager.ApiController;
import com.civilspril.app.com.civilspril.networkManager.NetworkCallBack;
import com.civilspril.app.com.civilspril.utilsFunctions.SaveDataManager;
import com.civilspril.app.com.civilspril.utilsFunctions.URLConstant;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.facebook.GraphRequest.newMeRequest;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout rl_fb_login,rl_google_login;
    private GoogleSignInClient mGoogleSignInClient;
    public static final int RC_SIGN_IN = 111;
    private boolean isLoggedIn;
    private TextView tv_skip;
    private CallbackManager callbackManager;
    private ProgressDialog progressDialog;
    private SaveDataManager saveDataManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_options);
        initView();
        initData();
        setListner();
    }

    private void initView(){
        rl_fb_login = findViewById(R.id.rl_fb_login);
        rl_google_login = findViewById(R.id.rl_google_login);
        tv_skip = findViewById(R.id.tv_skip);

    }
    private void initData(){

        saveDataManager = SaveDataManager.getInstance(this);
        if(!TextUtils.isEmpty(saveDataManager.getToken())){
            Intent in = new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(in);
            finish();
        }
        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setMessage("Please wait..");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);

        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        isLoggedIn = accessToken != null && !accessToken.isExpired();
        callbackManager = CallbackManager.Factory.create();
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(final LoginResult loginResult) {

                        loginResult.getAccessToken();
                        GraphRequest graphRequest = newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {
                                try {
                                    String email = object.getString("email");
//                                    String id = object.getString("id");
                                    String name  = object.getString("name");
                                    Log.e("  ===== "+email, "  "+loginResult.getAccessToken());
                                    JSONObject user =new  JSONObject();
                                    user.put("name", name);
                                    user.put("email",email );
                                    user.put("network_type","fb");
                                    user.put("fb_token", loginResult.getAccessToken().getToken());
                                   // user.put("google_token","" );

                                    logRequest(user,null);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            }
                        });

                        Bundle parameters = new Bundle();
                        parameters.putString("fields", "name,email,gender,picture.width(150).height(150)");
                        graphRequest.setParameters(parameters);
                        graphRequest.executeAsync();

                        // App code
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                        Log.e("=============", exception.getMessage());
                    }
                });

    }
    private void setListner(){
        rl_google_login.setOnClickListener(this);
        rl_fb_login.setOnClickListener(this);
        tv_skip.setOnClickListener(this);

    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.rl_google_login:
                signIn();
                break;

            case R.id.rl_fb_login:
                LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile","email"));
                break;

            case R.id.tv_skip:
                Intent in = new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(in);
                finish();
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
//            Intent in = new Intent(LoginActivity.this,HomeActivity.class);
//            startActivity(in);
//            finish();
        }
    }

    private void logRequest(JSONObject jsonString,Map<String, String> user ){
        progressDialog.show();
        ApiController apiController = new ApiController(LoginActivity.this);
        apiController.setParams(user);

        apiController.postJsonRequest(URLConstant.LOGIN_URL, jsonString, new NetworkCallBack() {
            @Override
            public void successResponse(JSONObject jsonObject) {
                progressDialog.dismiss();
                Gson gson = new Gson();
                LoginData mLoginData = gson.fromJson(jsonObject.toString(), LoginData.class);
                Log.e("==========", " "+mLoginData.getToken());
        if(mLoginData!=null && mLoginData.getToken()!=null){
            saveDataManager.setUserId(mLoginData.getId());
            saveDataManager.setUserName(mLoginData.getName());
            saveDataManager.setUserEmail(mLoginData.getEmail());
            saveDataManager.setToken(mLoginData.getToken());
    Intent in = new Intent(LoginActivity.this, HomeActivity.class);
    startActivity(in);
    finish();
            }
            }

            @Override
            public void successResponseString(String response) {

            }

            @Override
            public void error() {
                progressDialog.dismiss();
            }
        });
    }

    // [START handleSignInResult]
    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();
//              result.getSignInAccount().
            assert acct != null;
//            username_fb_str = acct.getDisplayName();
//            userpass_str = acct.getId();
//            username_str = acct.getEmail();
//            utypestr = "Google";
            try {
                String email = acct.getEmail();
//                                    String id = object.getString("id");
                String name  = acct.getDisplayName();
                JSONObject user =new  JSONObject();
                user.put("name", name);
                user.put("email",email );
                user.put("network_type","google");
//                user.put("fb_token", "");
                user.put("google_token",acct.getId());

                logRequest(user,null);
            } catch (Exception e) {
                e.printStackTrace();
            }        } else {

        }
    }
}
