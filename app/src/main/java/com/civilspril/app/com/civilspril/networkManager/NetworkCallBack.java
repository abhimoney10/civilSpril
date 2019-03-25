package com.civilspril.app.com.civilspril.networkManager;

import org.json.JSONObject;

public interface NetworkCallBack {

    public void successResponse(JSONObject response);
    public void successResponseString(String response);
    public void error();
}
