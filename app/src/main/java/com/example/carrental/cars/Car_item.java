package com.example.carrental.cars;

public class Car_item {
    private final String car_name;
    private final String capacity;
    private final String car_status;

    public Car_item(String car_name, String capacity, String car_status) {
        this.car_name = car_name;
        this.capacity = capacity;
        this.car_status = car_status;
    }
    public String get_car_name() {
        return car_name;
    }
    public String get_capacity() {
        return capacity;
    }
    public String get_car_status() {
        return car_status;
    }
}
