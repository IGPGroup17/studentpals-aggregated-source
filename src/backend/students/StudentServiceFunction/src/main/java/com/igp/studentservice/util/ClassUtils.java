package com.igp.studentservice.util;

import com.igp.studentservice.util.path.InvalidTypeException;
import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

/**
 * Boring unused stuff that may come in handy later. It just casts stuff safely but honestly i cba to use it lmao
 */
@SuppressWarnings("unchecked")
@UtilityClass
public class ClassUtils {

    private static final Map<Class<?>, Class<?>> BOXING_MAP = new HashMap<>();

    static {
        BOXING_MAP.put(int.class, Integer.class);
        BOXING_MAP.put(char.class, Character.class);
        BOXING_MAP.put(boolean.class, Boolean.class);
        BOXING_MAP.put(double.class, Double.class);
        BOXING_MAP.put(float.class, Float.class);
        BOXING_MAP.put(short.class, Short.class);
        BOXING_MAP.put(byte.class, Byte.class);
        BOXING_MAP.put(long.class, Long.class);
    }


    public <T> T cast(Object object, Class<T> clazz) {
        if (isAssignableFrom(object, clazz))
            return (T) object;

        throw new InvalidTypeException(object, clazz);
    }

    public boolean isAssignableFrom(Object object, Class<?> clazz) {
        Class<?> objectClazz = object.getClass();
        return objectClazz.isAssignableFrom(clazz) || box(objectClazz).isAssignableFrom(clazz);
    }

    public Class<?> box(Class<?> clazz) {
        Class<?> boxed = BOXING_MAP.get(clazz);

        if (boxed == null)
            throw new IllegalArgumentException("Class cannot be boxed!");

        return boxed;
    }
}
