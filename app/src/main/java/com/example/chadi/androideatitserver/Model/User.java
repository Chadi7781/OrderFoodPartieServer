package com.example.chadi.androideatitserver.Model;

public class User {

    private String name, password, phone, IsStaff;

    public User() {

    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        name = Name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        password =Password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String Phone) {
        phone = Phone;
    }

    public String getIsStaff() {
        return IsStaff;
    }

    public void setIsStaff(String isStaff) {
        IsStaff = isStaff;
    }
}