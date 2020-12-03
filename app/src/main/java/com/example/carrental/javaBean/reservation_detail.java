package com.example.carrental.javaBean;

public class reservation_detail {
    private String orderId;
    private String orderCreateTime;
    private String reservationStatus;
    private Double startDate;
    private String startTime;
    private String username;
    private String utaId;
    private String phone;
    private String email;
    private String carName;
    private String capacity;
    private Double duration;
    private String rateType;
    private String extraService;
    private Double fee;

    public reservation_detail(String orderId, String orderCreateTime, String reservationStatus,
                              Double startDate, String startTime, String username, String utaId,
                              String phone, String email, String carName, String capacity,
                              Double duration, String rateType, String extraService, Double fee) {
        this.orderId = orderId;
        this.orderCreateTime = orderCreateTime;
        this.reservationStatus = reservationStatus;
        this.startDate = startDate;
        this.startTime = startTime;
        this.username = username;
        this.utaId = utaId;
        this.phone = phone;
        this.email = email;
        this.carName = carName;
        this.capacity = capacity;
        this.duration = duration;
        this.rateType = rateType;
        this.extraService = extraService;
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

    public Double getStartDate() {
        return startDate;
    }

    public void setStartDate(Double startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUtaId() {
        return utaId;
    }

    public void setUtaId(String utaId) {
        this.utaId = utaId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public String getExtraService() {
        return extraService;
    }

    public void setExtraService(String extraService) {
        this.extraService = extraService;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }
}
