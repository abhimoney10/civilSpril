package com.civilspril.app.com.civilspril.beans;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class CategoryList implements Serializable {
    private static final long serialVersionUID = 1L;
    @SerializedName("category")
    private ArrayList<Categories> categoryList;

    public ArrayList<Categories> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(ArrayList<Categories> categoryList) {
        this.categoryList = categoryList;
    }
}
