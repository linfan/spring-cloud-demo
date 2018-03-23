package com.demo.transmission.plugin.interceptor;

public class UserId {

    private static ThreadLocal<String> userId = new ThreadLocal<>();

    public static String get() {
        return userId.get();
    }

    public static void set(String id) {
        userId.set(id);
    }

    private UserId() {
    }
}
