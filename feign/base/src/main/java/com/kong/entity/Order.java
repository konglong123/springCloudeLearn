package com.kong.entity;

/**
 * @program: demo-feign-base
 * @description: 测试，订单类
 * @author: Mr.Kong
 * @create: 2019-09-14 16:35
 **/
public class Order {
    private String orderId;
    private int amount;
    private String owner;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
