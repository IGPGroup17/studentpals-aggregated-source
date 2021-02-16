package com.igp.studentservice.dao;

import com.igp.studentservice.model.Student;

public interface StudentCrudDao {
     Student createStudent(Student user);
     Student readStudent(String studentId);
     Student updateStudent(Student student);
     void deleteStudent(String studentId);
}
