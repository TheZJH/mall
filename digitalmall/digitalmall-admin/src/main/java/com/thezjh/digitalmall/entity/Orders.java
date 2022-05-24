package com.thezjh.digitalmall.entity;


/**
 * @author thezjh
 */
public class Orders {

    private long id;
    private long userId;
    private long shoppingId;
    private double payment;
    private long postage;
    private long status;
    private long freight;
    private java.sql.Timestamp paymentTime;
    private java.sql.Timestamp sendTime;
    private java.sql.Timestamp endTime;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp updateTime;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    public long getShoppingId() {
        return shoppingId;
    }

    public void setShoppingId(long shoppingId) {
        this.shoppingId = shoppingId;
    }


    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }


    public long getPostage() {
        return postage;
    }

    public void setPostage(long postage) {
        this.postage = postage;
    }


    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }


    public long getFreight() {
        return freight;
    }

    public void setFreight(long freight) {
        this.freight = freight;
    }


    public java.sql.Timestamp getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(java.sql.Timestamp paymentTime) {
        this.paymentTime = paymentTime;
    }


    public java.sql.Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(java.sql.Timestamp sendTime) {
        this.sendTime = sendTime;
    }


    public java.sql.Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(java.sql.Timestamp endTime) {
        this.endTime = endTime;
    }


    public java.sql.Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.sql.Timestamp createTime) {
        this.createTime = createTime;
    }


    public java.sql.Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(java.sql.Timestamp updateTime) {
        this.updateTime = updateTime;
    }

}
