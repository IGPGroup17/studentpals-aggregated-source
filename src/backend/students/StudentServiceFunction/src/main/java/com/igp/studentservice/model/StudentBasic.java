package com.igp.studentservice.model;

import com.google.gson.annotations.SerializedName;

public class StudentBasic {

    private String username;

    @SerializedName("realname")
    private String realName;

    private int age;

    private String gender;

    public StudentBasic(String username, String realName, int age, String gender) {
        this.username = username;
        this.realName = realName;
        this.age = age;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
