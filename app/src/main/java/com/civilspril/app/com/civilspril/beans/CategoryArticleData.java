package com.civilspril.app.com.civilspril.beans;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class CategoryArticleData implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("data")
    private ArrayList<ArticaleData> articaleDataArrayList;

    @SerializedName("first_page_url")
    private String first_page_url;
    @SerializedName("last_page_url")
    private String last_page_url;
    @SerializedName("next_page_url")
    private String next_page_url;
    @SerializedName("path")
    private String path;
    @SerializedName("prev_page_url")
    private String prev_page_url;

    @SerializedName("current_page")
    private int current_page;
    @SerializedName("from")
    private int from;
    @SerializedName("last_page")
    private int last_page;
    @SerializedName("per_page")
    private int per_page;
    @SerializedName("to")
    private int to;
    @SerializedName("total")
    private int total;

    public String getFirst_page_url() {
        return first_page_url;
    }

    public void setFirst_page_url(String first_page_url) {
        this.first_page_url = first_page_url;
    }

    public String getLast_page_url() {
        return last_page_url;
    }

    public void setLast_page_url(String last_page_url) {
        this.last_page_url = last_page_url;
    }

    public String getNext_page_url() {
        return next_page_url;
    }

    public void setNext_page_url(String next_page_url) {
        this.next_page_url = next_page_url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPrev_page_url() {
        return prev_page_url;
    }

    public void setPrev_page_url(String prev_page_url) {
        this.prev_page_url = prev_page_url;
    }

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getLast_page() {
        return last_page;
    }

    public void setLast_page(int last_page) {
        this.last_page = last_page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<ArticaleData> getArticaleDataArrayList() {
        return articaleDataArrayList;
    }

    public void setArticaleDataArrayList(ArrayList<ArticaleData> articaleDataArrayList) {
        this.articaleDataArrayList = articaleDataArrayList;
    }
}
