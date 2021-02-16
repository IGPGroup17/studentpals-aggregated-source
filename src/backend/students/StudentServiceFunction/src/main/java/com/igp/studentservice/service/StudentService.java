package com.igp.studentservice.service;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.igp.studentservice.model.Student;
import com.igp.studentservice.util.IService;
import com.igp.studentservice.util.ResponseEntity;

public interface StudentService extends IService {

    ResponseEntity<Student> createStudent(APIGatewayProxyRequestEvent event, Context context);

    ResponseEntity<Student> readStudent(APIGatewayProxyRequestEvent event, Context context);

    ResponseEntity<Student> updateStudent(APIGatewayProxyRequestEvent event, Context context);

    ResponseEntity<Student> deleteStudent(APIGatewayProxyRequestEvent event, Context context);
}
