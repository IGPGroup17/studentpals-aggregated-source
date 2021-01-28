package util;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

public class ResponseEntity<T> {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private final T object;

    private final HTTPStatus status;

    public static <T> ResponseEntity<T> ok(T object) {
        return new ResponseEntity<>(object, HTTPStatus.OK);
    }

    public static <T> ResponseEntity<T> forbidden(T object) {
        return new ResponseEntity<>(object, HTTPStatus.FORBIDDEN);
    }

    public static <T> ResponseEntity<T> internalServerError(T object) {
        return new ResponseEntity<>(object, HTTPStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseEntity<String> notFound() {
        return new ResponseEntity<>("Resource not Found :/", HTTPStatus.NOT_FOUND);
    }

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
                .withHeaders(Headers.getHeaders())
                .withStatusCode(getStatus().getCode())
                .withBody(toString());
    }

    @Override
    public String toString() {
        JsonElement element = GSON.toJsonTree(object);
        element.getAsJsonObject().addProperty("code", status.getCode());
        return GSON.toJson(element);
    }
}
