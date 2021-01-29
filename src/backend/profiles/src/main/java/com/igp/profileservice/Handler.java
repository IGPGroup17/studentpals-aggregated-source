package com.igp.profileservice;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.igp.profileservice.util.EnvironmentLogger;
import com.igp.profileservice.util.ResponseEntity;
import com.igp.profileservice.service.ProfileService;
import com.igp.profileservice.service.ProfileServiceImpl;

public class Handler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent, Context context) {
        EnvironmentLogger.log(apiGatewayProxyRequestEvent, context);
        ProfileService service = new ProfileServiceImpl();

        return (switch (apiGatewayProxyRequestEvent.getResource()) {
                    case "/profile/{id}" -> service.getProfile(apiGatewayProxyRequestEvent, context);
                    case "/profile/create/{id}" -> service.createProfile(apiGatewayProxyRequestEvent, context);
                    case "/profile/delete/{id}" -> service.deleteProfile(apiGatewayProxyRequestEvent, context);
                    case "/profile/update/{id}" -> service.updateProfile(apiGatewayProxyRequestEvent, context);
                    default -> ResponseEntity.notFound();
                }).toApiGatewayProxyResponseEvent();
    }
}
