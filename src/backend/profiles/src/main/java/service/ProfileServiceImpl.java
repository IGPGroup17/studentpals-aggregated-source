package service;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import model.Profile;
import util.ResponseEntity;

public class ProfileServiceImpl implements ProfileService {

    @Override
    public ResponseEntity<Profile> getProfile(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(new Profile("Get"));
    }

    @Override
    public ResponseEntity<Profile> updateProfile(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(new Profile("Update"));
    }

    @Override
    public ResponseEntity<Profile> createProfile(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(new Profile("Create"));
    }

    @Override
    public ResponseEntity<Profile> deleteProfile(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(new Profile("Delete"));
    }
}
