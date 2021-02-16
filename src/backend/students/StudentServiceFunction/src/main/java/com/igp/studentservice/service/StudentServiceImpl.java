package com.igp.studentservice.service;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.igp.studentservice.model.*;
import com.igp.studentservice.util.ResponseEntity;

public class StudentServiceImpl implements StudentService {
    @Override
    public ResponseEntity<Student> createStudent(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(Examples.EXAMPLE);
    }

    @Override
    public ResponseEntity<Student> readStudent(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(Examples.EXAMPLE);
    }

    @Override
    public ResponseEntity<Student> updateStudent(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(Examples.EXAMPLE);
    }

    @Override
    public ResponseEntity<Student> deleteStudent(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(Examples.EXAMPLE);
    }
}
