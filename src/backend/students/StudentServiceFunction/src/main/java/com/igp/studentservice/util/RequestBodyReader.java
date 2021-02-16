package com.igp.studentservice.util;

import com.google.gson.Gson;
import lombok.experimental.UtilityClass;

/**
 * PROBLEM: The body of a request will return a JSON format. We want it to be the object we've defined.
 *
 * This is super simple - it's literally a simple utility method to convert JSON format into an object.
 */
@UtilityClass
public class RequestBodyReader {

    private final Gson GSON = new Gson();

    public <T> T getAsObject(String body, Class<T> clazz) {
        return GSON.fromJson(body, clazz);
    }
}
