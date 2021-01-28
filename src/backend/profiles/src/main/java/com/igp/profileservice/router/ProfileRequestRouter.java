package com.igp.profileservice.router;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.igp.profileservice.service.ProfileService;
import com.igp.profileservice.util.EnvironmentLogger;
import com.igp.profileservice.util.ResponseEntity;

public class ProfileRequestRouter implements IRouter<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent, ProfileService> {

    @Override
    public APIGatewayProxyResponseEvent routeRequest(APIGatewayProxyRequestEvent event, Context context, ProfileService service) {

        EnvironmentLogger.log(event, context);

        ResponseEntity<?> result = switch(event.getResource()) {
            case "/profile/{id}" -> service.getProfile(event, context);
            case "/profile/create/{id}" -> service.createProfile(event, context);
            case "/profile/delete/{id}" -> service.deleteProfile(event, context);
            case "/profile/update/{id}" -> service.updateProfile(event, context);
            default -> ResponseEntity.notFound();
        };

        return result.toApiGatewayProxyResponseEvent();
    }
}
