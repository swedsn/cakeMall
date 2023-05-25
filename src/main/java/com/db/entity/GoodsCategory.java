package com.db.entity;

/**
 * @author swedsn
 * @version 1.0
 * @date 2022-12-08 21:32
 */
public class GoodsCategory {
    private int categoryID;
    private String categoryName;
    private int parentID;
    private boolean isParent;
    public boolean isParent() {
        return isParent;
    }

    public void setParent(boolean parent) {
        isParent = parent;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }
}
