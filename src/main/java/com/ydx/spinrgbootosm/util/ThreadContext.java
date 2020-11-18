package com.ydx.spinrgbootosm.util;

import java.util.concurrent.ConcurrentHashMap;

public abstract class ThreadContext {
    private static final ThreadLocal<ConcurrentHashMap<String, Object>> contextMap = new InheritableThreadLocal() {
    };

    public ThreadContext() {
    }

    public static ConcurrentHashMap<String, Object> getContextMap() {
        if (contextMap.get() == null) {
            contextMap.set(new ConcurrentHashMap());
        }

        return (ConcurrentHashMap)contextMap.get();
    }

    public static void putContext(String key, Object value) {
        if (value == null) {
            getContextMap().remove(key);
        } else {
            getContextMap().put(key, value);
        }

    }

    public static Object getContext(String key) {
        return getContextMap().get(key);
    }

    public static void clear() {
        if (contextMap.get() != null) {
            contextMap.remove();
        }

    }
}
