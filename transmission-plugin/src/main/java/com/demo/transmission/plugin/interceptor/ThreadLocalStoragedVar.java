package com.demo.transmission.plugin.interceptor;

import com.alibaba.ttl.TransmittableThreadLocal;

public class ThreadLocalStoragedVar {

    private static TransmittableThreadLocal<String> userId = new TransmittableThreadLocal<>();

    public static String get() {
        return userId.get();
    }

    public static void set(String id) {
        userId.set(id);
    }

    private ThreadLocalStoragedVar() {
    }
}
