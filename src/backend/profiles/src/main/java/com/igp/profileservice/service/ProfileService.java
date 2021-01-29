package com.igp.profileservice.service;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.igp.profileservice.model.Profile;
import com.igp.profileservice.util.IService;
import com.igp.profileservice.util.ResponseEntity;

public interface ProfileService extends IService {

    ResponseEntity<Profile> getProfile(APIGatewayProxyRequestEvent event, Context context);

    ResponseEntity<Profile> updateProfile(APIGatewayProxyRequestEvent event, Context context);

    ResponseEntity<Profile> createProfile(APIGatewayProxyRequestEvent event, Context context);

    ResponseEntity<Profile> deleteProfile(APIGatewayProxyRequestEvent event, Context context);
}
