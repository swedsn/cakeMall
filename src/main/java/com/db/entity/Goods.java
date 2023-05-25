package com.db.entity;

/**
 * @author swedsn
 * @version 1.0
 * @date 2022-12-13 14:38
 */
public class Goods {
    private int goodsID;
    private String goodsName;
    private double goodsPrice;
    private String goodsCategory;
    private String goodsLogo;
    private boolean goodsExist;
    private String goodsDescription;

    private int goodsSale;

    public int getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(int goodsID) {
        this.goodsID = goodsID;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsCategory() {
        return goodsCategory;
    }

    public void setGoodsCategory(String goodsCategory) {
        this.goodsCategory = goodsCategory;
    }

    public String getGoodsLogo() {
        return goodsLogo;
    }

    public void setGoodsLogo(String goodsLogo) {
        this.goodsLogo = goodsLogo;
    }

    public boolean getGoodsExist() {
        return goodsExist;
    }

    public void setGoodsExist(boolean goodsExist) {
        this.goodsExist = goodsExist;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }


}
