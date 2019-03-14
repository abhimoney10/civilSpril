package com.civilspril.app.com.civilspril.networkManager;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class ApiController {
    private static ApiController mInstance;
    private Context context;
    private Map<String, String> params;

    public  ApiController(Context context) {
        this.context = context;
    }

    public static ApiController getInstance(Context context) {
        if (mInstance == null)
            mInstance = new ApiController(context);
        return mInstance;
    }

    public void setParams(Map<String, String> params){
       this.params = params;
    }

    public void getDataFromNetwork(String url, final NetworkCallBack mNetworkCallBack){
        RequestQueue requestQueue = Volley.newRequestQueue(context);
//        requestQueue.
//        requestQueue.
        // Initialize a new JsonObjectRequest instance
        StringRequest jsonObjectRequest = new StringRequest(
                Request.Method.POST,
                url,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Do something with response
                        //mTextView.setText(response.toString());
                         Log.e("===========", "   "+response.toString());
                        JSONObject obj = null;
                        try {
                            obj = new JSONObject(response);
                            mNetworkCallBack.successResponse(obj);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
//                        error.
                        Log.e("======jhgsdfj=====", " eroor  "+error.getMessage());

                        mNetworkCallBack.error();
                        // Do something when error occurred

                    }
                }

        ){
            @Override
            protected Map<String,String> getParams(){


                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
             //   params.put("authorization", "Basic YWRtaW46MTIzNA==");
                if(params!=null){
                    return params;
                }


                return super.getHeaders();
            }
        };
        ;


//        requestQueue.
        // Add JsonObjectRequest to the RequestQueue
        requestQueue.add(jsonObjectRequest);
//        requestQueue.


    }

    public void getDataFromNetworkGetMethod(String url, final NetworkCallBack mNetworkCallBack){
        RequestQueue requestQueue = Volley.newRequestQueue(context);
//        requestQueue.
//        requestQueue.
        // Initialize a new JsonObjectRequest instance
        StringRequest jsonObjectRequest = new StringRequest(
                Request.Method.GET,
                url,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Do something with response
                        //mTextView.setText(response.toString());
                        Log.e("===========", "   "+response.toString());
                        JSONObject obj = null;
                        try {
                            obj = new JSONObject(response);
                            mNetworkCallBack.successResponse(obj);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
//                        error.
                        Log.e("======jhgsdfj=====", " eroor  "+error.getMessage());

                        mNetworkCallBack.error();
                        // Do something when error occurred

                    }
                }

        ){
            @Override
            protected Map<String,String> getParams(){


                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
              //  params.put("authorization", "Basic YWRtaW46MTIzNA==");
                if(params!=null){
                    return params;
                }


                return super.getHeaders();
            }
        };

        requestQueue.add(jsonObjectRequest);

    }

    public void postJsonRequest(String url,JSONObject  mJSONURLString,final NetworkCallBack mNetworkCallBack){

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        // Initialize a new JsonObjectRequest instance
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                url,
                mJSONURLString,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        mNetworkCallBack.successResponse(response);
                        Log.e("========","    "+response.toString());

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mNetworkCallBack.error();
                        // Do something when error occurred
                        Log.e("========","    "+error.getMessage());

                    }
                }

        ){
            @Override
            protected Map<String,String> getParams(){


                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();

                params.put("Content-Type", "application/json");
                if(params!=null){
                    return params;
                }


                return super.getHeaders();
            }
        };

        // Add JsonObjectRequest to the RequestQueue
        requestQueue.add(jsonObjectRequest);
    }






}
