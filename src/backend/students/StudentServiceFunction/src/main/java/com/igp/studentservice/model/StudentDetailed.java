package com.igp.studentservice.model;

public class StudentDetailed {

    private StudentBasic basic;

    private StudentUni uni;

    public StudentDetailed(StudentBasic studentBasic, StudentUni studentUni) {
        this.basic = studentBasic;
        this.uni = studentUni;
    }

    public StudentBasic getBasic() {
        return basic;
    }

    public StudentUni getUni() {
        return uni;
    }

    public void setBasic(StudentBasic basic) {
        this.basic = basic;
    }

    public void setUni(StudentUni uni) {
        this.uni = uni;
    }

    @Override
    public String toString() {
        return "StudentDetailed{}";
    }
}
