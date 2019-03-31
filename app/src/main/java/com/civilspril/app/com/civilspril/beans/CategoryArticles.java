package com.civilspril.app.com.civilspril.beans;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CategoryArticles implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("message")
    private String message;
    @SerializedName("errors")
    private String errors;
    @SerializedName("code")
    private int code;

    @SerializedName("data")
    private CategoryArticleData mCategoryArticleData;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public CategoryArticleData getmCategoryArticleData() {
        return mCategoryArticleData;
    }

    public void setmCategoryArticleData(CategoryArticleData mCategoryArticleData) {
        this.mCategoryArticleData = mCategoryArticleData;
    }
}
