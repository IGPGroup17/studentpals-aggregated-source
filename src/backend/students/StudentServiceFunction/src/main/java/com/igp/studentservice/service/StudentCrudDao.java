package com.igp.studentservice.service;

import com.igp.studentservice.model.Student;

public interface StudentCrudDao {
    public Student createStudent(Student user);
    public Student readStudent(String studentId);
    public Student updateStudent(Student student);
    public void deleteStudent(String studentId);
}
