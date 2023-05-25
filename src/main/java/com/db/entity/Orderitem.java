package com.db.entity;

/**
 * @author swedsn
 * @version 1.0
 * @date 2022-12-19 02:23
 */
public class Orderitem {
    private int orderID;
    private int goodsID;
    private int goodsNum;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
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
}
