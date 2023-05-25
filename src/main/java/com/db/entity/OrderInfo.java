package com.db.entity;

/**
 * @author swedsn
 * @version 1.0
 * @date 2022-12-14 11:26
 */
public class OrderInfo {
    private int orderID;
    private String orderTelephone;
    private double orderPrice;
    private String orderStatus;
    private String orderContents;
    private String orderTime;
    private String orderAddress;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderContents() {
        return orderContents;
    }

    public void setOrderContents(String orderContents) {
        this.orderContents = orderContents;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getOrderTelephone() {
        return orderTelephone;
    }

    public void setOrderTelephone(String orderTelephone) {
        this.orderTelephone = orderTelephone;
    }
}
