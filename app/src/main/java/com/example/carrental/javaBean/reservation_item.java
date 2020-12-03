package com.example.carrental.javaBean;

public class reservation_item {
    private String orderId;
    private String orderCreateTime;
    private String reservationStatus;
    private String startDate;
    private Double fee;

    public reservation_item(String orderId, String orderCreateTime, String reservationStatus, String startDate, Double fee) {
        this.orderId = orderId;
        this.orderCreateTime = orderCreateTime;
        this.reservationStatus = reservationStatus;
        this.startDate = startDate;
        this.fee = fee;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(String orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }
}
