package com.civilspril.app.com.civilspril.beans;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ArticaleData implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("title")
    private String title;
    @SerializedName("slug")
    private String slug;
    @SerializedName("body")
    private String body;
    @SerializedName("date")
    private String date;
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("updated_at")
    private String updated_at;
    @SerializedName("userTags")
    private String userTags;

    @SerializedName("id")
    private int id;

    @SerializedName("public")
    private int publicData;
    @SerializedName("category_id")
    private int category_id;
    @SerializedName("favourite")
    private int favourite;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getUserTags() {
        return userTags;
    }

    public void setUserTags(String userTags) {
        this.userTags = userTags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPublicData() {
        return publicData;
    }

    public void setPublicData(int publicData) {
        this.publicData = publicData;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getFavourite() {
        return favourite;
    }

    public void setFavourite(int favourite) {
        this.favourite = favourite;
    }
}
