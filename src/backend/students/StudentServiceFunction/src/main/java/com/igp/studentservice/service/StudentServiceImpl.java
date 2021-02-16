package com.igp.studentservice.service;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.igp.studentservice.dao.StudentCrudDao;
import com.igp.studentservice.model.*;
import com.igp.studentservice.util.ResponseEntity;

public class StudentServiceImpl implements StudentService {

    private StudentCrudDao studentCrudDao;

    public StudentServiceImpl(StudentCrudDao studentCrudDao) {
        this.studentCrudDao = studentCrudDao;
    }

    @Override
    public ResponseEntity<Student> createStudent(APIGatewayProxyRequestEvent event, Context context, Student student) {
        return ResponseEntity.ok(studentCrudDao.createStudent(student));
    }

    @Override
    public ResponseEntity<Student> readStudent(APIGatewayProxyRequestEvent event, Context context, String studentId) {
        return ResponseEntity.ok(studentCrudDao.readStudent(studentId));
    }

    @Override
    public ResponseEntity<Student> updateStudent(APIGatewayProxyRequestEvent event, Context context, Student student) {
        return ResponseEntity.ok(studentCrudDao.updateStudent(student));
    }

    @Override
    public ResponseEntity<Student> deleteStudent(APIGatewayProxyRequestEvent event, Context context, String studentId) {
        studentCrudDao.deleteStudent(studentId);
        return null;
    }
}
