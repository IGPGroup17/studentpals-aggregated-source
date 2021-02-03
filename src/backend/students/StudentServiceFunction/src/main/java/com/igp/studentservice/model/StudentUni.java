package com.igp.studentservice.model;

public class StudentUni {

    private String email;

    private String university;

    private int year;

    private String course;

    public StudentUni(String email, String university, int year, String course) {
        this.email = email;
        this.university = university;
        this.year = year;
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
