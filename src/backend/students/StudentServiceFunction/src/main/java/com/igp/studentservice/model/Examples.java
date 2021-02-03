package com.igp.studentservice.model;

public class Examples {

    public static final StudentBasic EXAMPLE_BASIC = new StudentBasic("johnbernadis93", "Leon Watts", 27, "Male");

    public static final StudentUni EXAMPLE_UNI = new StudentUni("johnbernadis93@gmail.com", "University of Bath", 2, "Computer Science (BSc) Hons");


    public static final StudentDetailed EXAMPLE_DETAILED = new StudentDetailed(EXAMPLE_BASIC, EXAMPLE_UNI);
}
