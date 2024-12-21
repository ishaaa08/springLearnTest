package com.learn.learnTest.model;

public class DataBase {
    private String name;
    private String password;
    private String email;
    private long phone;
    private String address;

    //setter

    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(long phone) {
        this.phone = phone;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    //getter
    public String getName() {
        return this.name;
    }
    public String getPassword() {
        return this.password;
    }
    public String getEmail() {
        return this.email;
    }
    public long getPhone() {
        return this.phone;
    }
    public String getAddress() {
        return this.address;
    }
    @Override
    public String toString() {
        return "DataBase{" +
                "name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phone=" + getPhone() +
                ", address='" + getAddress() + '\'' +
                '}';
    }
}
