package com.igp.studentservice.model;

public class Examples {

    public static final Student EXAMPLE = Student.builder()
        .username("johnbernadis93")
        .realName("John Bernadis")
        .age(30)
        .gender("Male")
        .email("johnbernadis93@gmail.com")
        .universityName("University of Bath")
        .year(2)
        .course("Computer Science (BSc) Hons")
        .universityEmail("jbb23@bath.ac.uk")
        .build();
}
