package com.igp.profileservice.util;

import java.util.HashMap;
import java.util.Map;

public class Headers {

    private static Map<String, String> headers;

    // lazy init of headers (dont think it'll matter in the context of AWS lambda but hey why not)
    public static Map<String, String> getHeaders() {
        if (headers == null) {
            headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            headers.put("X-Custom-Header", "application/json");
        }
        return headers;
    }

}
