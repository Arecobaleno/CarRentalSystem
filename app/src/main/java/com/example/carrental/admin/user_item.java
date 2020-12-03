package com.example.carrental.admin;

public class user_item {
    private final String UtaID;
    private final String username;
    private final String RentalStatus;

    public user_item(String UtaID, String username, String RentalStatus) {
        this.UtaID = UtaID;
        this.username = username;
        this.RentalStatus = RentalStatus;
    }
    public String get_utaid() {
        return UtaID;
    }
    public String get_username() {
        return username;
    }
    public String get_rentalstatus() {
        return RentalStatus;
    }
}
