package com.covid19management;

import java.util.ArrayList;

public class Citizen {
    private String name;
    private int identityCard;
    private int age;
    private String gender;
    private String permanentAddress;
    private String temporaryAddress;
    private String health = "normal";

    ArrayList<String> listMove = new ArrayList<>();

    public Citizen() {

    }

    public Citizen(String name, int identityCard, int age, String gender, String permanentAddress, String temporaryAddress) {
        this.name = name;
        this.identityCard = identityCard;
        this.age = age;
        this.gender = gender;
        this.permanentAddress = permanentAddress;
        this.temporaryAddress = temporaryAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(int identityCard) {
        this.identityCard = identityCard;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getTemporaryAddress() {
        return temporaryAddress;
    }

    public void setTemporaryAddress(String temporaryAddress) {
        this.temporaryAddress = temporaryAddress;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "Tên: "+name+", CMND: "+identityCard+", Tuổi: "+age+", Giới tính: "+gender+", Thường trú: "+permanentAddress+", Tạm trú: "+temporaryAddress
                +", Sức khỏe: "+health+", Lộ trình di chuyển: "+listMove;
    }

    public String formatString() {
        return name+","+identityCard+","+age+","+gender+","+permanentAddress+","+temporaryAddress
                +","+health+","+listMove;
    }
}
