package com.example.base.autoservice;

import java.util.ServiceLoader;

public final class MyServiceLoader {
    private MyServiceLoader(){}
    public static <T> T getService(Class<T> cls){
        try {
            return ServiceLoader.load(cls).iterator().next();
        } catch (Exception e){
            return null;
        }
    }
}
