package com.db.entity;

/**
 * @author swedsn
 * @version 1.0
 * @date 2022-12-19 12:00
 */
public class Cart {
    private String telephone;
    private int goodsID;

    private int goodsNum;
    private double goodsPriceSum;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(int goodsID) {
        this.goodsID = goodsID;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public double getGoodsPriceSum() { return goodsPriceSum; }

    public void setGoodsPriceSum(double goodsPriceSum) {
        this.goodsPriceSum = goodsPriceSum;
    }
}
