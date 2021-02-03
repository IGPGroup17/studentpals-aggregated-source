package com.igp.studentservice.service;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.igp.studentservice.model.*;
import com.igp.studentservice.util.ResponseEntity;

public class StudentServiceImpl implements StudentService {

    @Override
    public ResponseEntity<StudentBasic> getBasicStudent(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(Examples.EXAMPLE_BASIC);
    }

    @Override
    public ResponseEntity<StudentDetailed> getDetailedStudent(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(Examples.EXAMPLE_DETAILED);
    }

    @Override
    public ResponseEntity<StudentUni> getUniStudent(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(Examples.EXAMPLE_UNI);
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
