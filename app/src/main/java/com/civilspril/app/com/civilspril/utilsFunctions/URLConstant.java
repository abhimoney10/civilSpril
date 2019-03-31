package com.civilspril.app.com.civilspril.utilsFunctions;

public class URLConstant {

    public static final String BASE_URL = "https://civilspiral.appspot.com";

    public static final String LOGIN_URL = BASE_URL+"/api/register";
    public static final String CATEGORYS_URL  =BASE_URL+"/api/category";
    public static final String CATEGORYS_ARTICLES_URL  =BASE_URL+"/api/category/<name>/articles";
    public static final String TODAY_SPIRL_URL  =BASE_URL+"/api/home";
    public static final String FAVORITE_LIST_URL  =BASE_URL+"/api/favourite/?token=";
    public static final String QUIZ_LIST_URL  =BASE_URL+"/api/quiz?token=";
}
