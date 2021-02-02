package com.igp.studentservice;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
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
        return new PatternMatcher<String, ResponseEntity<?>>()
                .defineCase(
                        "/v1/students/basic/{id}", service.getBasicStudent(event, context),
                        () -> event.getHttpMethod().equals("GET"))

                .defineCase(
                        "/v1/students/create", service.createStudent(event, context),
                        () -> event.getHttpMethod().equals("POST"))

                .defineCase(
                        "/v1/students/delete/{id}", service.deleteStudent(event, context),
                        () -> event.getHttpMethod().equals("DELETE"))

                .defineCase(
                        "/v1/students/detailed/{id}", service.getDetailedStudent(event, context),
                        () -> event.getHttpMethod().equals("GET"))

                .defineCase(
                        "/v1/students/uni/{id}", service.getUniStudent(event, context),
                        () -> event.getHttpMethod().equals("GET"))

                .defineCase(
                        "/v1/students/update/{id}", service.updateStudent(event, context),
                        () -> event.getHttpMethod().equals("POST"))

                .defaultCase(ResponseEntity.notFound())

                .match(event.getResource());
    }
}
