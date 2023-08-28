package com.example.showlist_customer.model;

import java.time.LocalDate;
import java.util.Date;

public class Customer {
    private int idCustomer;
    private String name;
    private LocalDate birthday;
    private String address;
    private String images;

    public Customer(int idCustomer, String name, LocalDate birthday, String address, String images) {
        this.idCustomer = idCustomer;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.images = images;
    }

    public Customer(String name, LocalDate birthday, String address, String images) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.images = images;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
