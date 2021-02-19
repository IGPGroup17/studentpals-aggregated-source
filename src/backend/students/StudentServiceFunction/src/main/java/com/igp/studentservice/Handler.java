package com.igp.studentservice;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.igp.studentservice.model.Student;
import com.igp.studentservice.util.AmazonExceptionHandler;
import com.igp.studentservice.util.pattern.PatternMatcher;
import com.igp.studentservice.service.StudentService;
import com.igp.studentservice.service.StudentServiceImpl;
import com.igp.studentservice.util.EnvironmentLogger;
import com.igp.studentservice.util.ResponseEntity;

public class Handler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent event, Context context) {
        EnvironmentLogger.log(event, context);
        return routeRequest(event, context, new StudentServiceImpl()).toApiGatewayProxyResponseEvent();
    }

    private ResponseEntity<?> routeRequest(APIGatewayProxyRequestEvent event, Context context, StudentService service) {
        return AmazonExceptionHandler.handle(() -> {
            String resource = event.getResource();
            String httpMethod = event.getHttpMethod();

            if (resource.equalsIgnoreCase("/v1/students") && httpMethod.equals("POST")) {
                return ResponseEntity.ok(service.createStudent(event, context));
            } else if (resource.equalsIgnoreCase("/v1/students/{id}") && httpMethod.equals("GET")) {
                return ResponseEntity.ok(service.readStudent(event, context));
            } else if (resource.equalsIgnoreCase("/v1/students") && httpMethod.equals("UPDATE")) {
                return ResponseEntity.ok(service.updateStudent(event, context));
            } else if (resource.equalsIgnoreCase("/v1/students/{id}") && httpMethod.equals("DELETE")) {
                return ResponseEntity.ok(service.deleteStudent(event, context));
            } else {
                return ResponseEntity.notFound();
            }
        });
    }
}
