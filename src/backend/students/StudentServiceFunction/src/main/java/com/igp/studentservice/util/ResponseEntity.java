package com.igp.studentservice.util;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

public class ResponseEntity<T> {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @SerializedName("response")
    private final T object;

    private final HTTPStatus status;

    /* ------------- STATIC FACTORY METHODS ------------- */
    public static <T> ResponseEntity<T> ok(T object) {
        return new ResponseEntity<>(object, HTTPStatus.OK);
    }

    public static ResponseEntity<String> forbidden() {
        return new ResponseEntity<>("You are not allowed to access this!", HTTPStatus.FORBIDDEN);
    }

    public static ResponseEntity<String> internalServerError() {
        return new ResponseEntity<>("Internal server error! :/", HTTPStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseEntity<String> notFound() {
        return new ResponseEntity<>("Resource not Found :/", HTTPStatus.NOT_FOUND);
    }

    public static ResponseEntity<String> badRequest() {
        return new ResponseEntity<>("Bad Request!", HTTPStatus.BAD_REQUEST);
    }

    /*
     * Shouldn't really call this unless you have a weird response code to use that's not worth making a static factory
     * method for.
     */
    public ResponseEntity(T object, HTTPStatus status) {
        this.object = object;
        this.status = status;
    }

    public T getObject() {
        return object;
    }

    public HTTPStatus getStatus() {
        return status;
    }

    public APIGatewayProxyResponseEvent toApiGatewayProxyResponseEvent() {
        return new APIGatewayProxyResponseEvent()
                .withIsBase64Encoded(false)
                .withHeaders(Headers.headers())
                .withStatusCode(getStatus().getCode())
                .withBody(toString());
    }

    @Override
    public String toString() {
        return GSON.toJson(object);
    }
}
