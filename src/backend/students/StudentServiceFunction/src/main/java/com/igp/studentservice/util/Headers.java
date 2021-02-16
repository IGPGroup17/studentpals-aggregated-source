package com.igp.studentservice.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Headers for the HTTP Response. Used in {@link ResponseEntity}.
 */
public class Headers {

    public static Map<String, String> headers() {
        Map<String, String> map = new HashMap<>();
        map.put("Content-Type", "application/json");
        return map;
    }
}
