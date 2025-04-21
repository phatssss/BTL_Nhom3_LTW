package com.javaweb.utils;

//import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

public class MapUtils {

    public static <T> T getObject(Map<String, Object> maps, String key, Class<T> tClass) {
        Object obj = maps.getOrDefault(key, null);

        if (obj != null ) {
           if(tClass.getTypeName().equals("java.lang.Long")) {
               obj = obj != "" ? Long.valueOf(obj.toString()) : null;
           }
           else if(tClass.getTypeName().equals("java.lang.Integer")) {
               obj = obj != "" ? Integer.valueOf(obj.toString()) : null;
           }
           else if(tClass.getTypeName().equals("java.lang.Double")) {
               obj = obj != "" ? Double.valueOf(obj.toString()) : null;
           }

           else if(tClass.getTypeName().equals("import java.math.BigDecimal;")) {
               obj = !obj.toString().isEmpty() ? new BigDecimal(obj.toString()) : null;
           }

           else if(tClass.getTypeName().equals("java.time.LocalDateTime")) {
               obj = obj != "" ? LocalDateTime.parse(obj.toString()) : null;
           }

           else if(tClass.getTypeName().equals("java.lang.String")) {
               obj = obj.toString();
           }
           return tClass.cast(obj);
        }

        return null;
    }
}

//            if (tClass.equals(Long.class)) {
//        return tClass.cast(Long.valueOf(obj.toString()));
//        } else if (tClass.equals(Integer.class)) {
//        return tClass.cast(Integer.valueOf(obj.toString()));
//        } else if (tClass.equals(LocalDateTime.class)) {
//        return tClass.cast(LocalDateTime.parse(obj.toString()));
//        } else if (tClass.equals(String.class)) {
//        return tClass.cast(obj.toString());
//        }

