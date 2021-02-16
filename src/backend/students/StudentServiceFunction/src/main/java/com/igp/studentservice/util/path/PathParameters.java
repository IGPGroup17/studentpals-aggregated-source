package com.igp.studentservice.util.path;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import lombok.experimental.UtilityClass;

import java.util.Map;
import java.util.Objects;

/**
 * PROBLEM: We need to identify get the shit {id} shit in the path for the URL. (eg. /students/{id} - the id bit).
 *
 * SOLUTION:
 *
 * APIGatewayProxyRequestEvent provides a .getPathParameters() method
 * {@link APIGatewayProxyRequestEvent#getPathParameters()}, which returns a Map<String, String> with the key being
 * the thing we call it, and the value being the value there.
 *
 * For example, if we have a path defined as /students/{id}, and when typing in the URL we type /students/1, the map
 * will contain a single entry looking like this: id: "1". (Note that 1 is a string here).
 *
 * This class does a few things. Firstly, it ensures that something at this path actually exists (and throws an
 * exception if it doesn't). Secondly, it will automatically try to cast the path parameter to the type you specify,
 * and throws an exception if its not of that type.
 *
 * So for example, If you call getPathParameter(event, "id", Integer.class) on the example we used above, it will return
 * an Integer with the value 1.
 *
 * Hopefully this makes it easier for yalls to get path parameters :)
 */
@UtilityClass
public class PathParameters {

    /**
     * This method is public, and returns a string by default if you dont need anything else.
     * You can alternatively call getPathParameter(event, key, String.class), although this doesn't bother with
     * any of the type casting nonsense.
     */
    public String getPathParameter(APIGatewayProxyRequestEvent event, String key) {
        Objects.requireNonNull(event);
        Objects.requireNonNull(key);

        Map<String, String> pathParameters = event.getPathParameters();

        Objects.requireNonNull(pathParameters);

        String value = pathParameters.get(key);

        if (value == null)
            throw new IllegalArgumentException("The key specified isn't valid!");

        return value;
    }

    /**
     * This method takes in the event, the key you want to get, and the class you want to attempt to cast it to, and
     * returns the value at that key with it already casted for you. See text above the class declaration
     * for an example :)
     */
    public <T> T getPathParameter(APIGatewayProxyRequestEvent event, String key, Class<T> clazz) {
        Objects.requireNonNull(clazz);

        String value = getPathParameter(event, key);

        if (value == null)
            throw new IllegalArgumentException("The key specified isn't valid!");

        return StringToTypeConversionFactory.convert(value, clazz);
    }
}
