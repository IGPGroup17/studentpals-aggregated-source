package com.igp.studentservice.service;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.igp.studentservice.model.Student;
import com.igp.studentservice.util.ResponseEntity;

public class StudentServiceImpl implements StudentService {

    @Override
    public ResponseEntity<Student> getBasicStudent(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(new Student("Basic Student"));
    }

    @Override
    public ResponseEntity<Student> getDetailedStudent(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(new Student("Detailed Student"));
    }

    @Override
    public ResponseEntity<Student> getUniStudent(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(new Student("Uni Student"));
    }

    @Override
    public ResponseEntity<Student> updateStudent(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(new Student("Update"));
    }

    @Override
    public ResponseEntity<Student> createStudent(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(new Student("Create"));
    }

    @Override
    public ResponseEntity<Student> deleteStudent(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(new Student("Delete"));
    }
}
