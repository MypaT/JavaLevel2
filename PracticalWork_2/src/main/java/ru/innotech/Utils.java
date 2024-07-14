package ru.innotech;

import java.lang.reflect.Proxy;

public class Utils extends Object{
    @SuppressWarnings("unchecked")
    public static <T> T cache(T obj) {
        return (T) Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new CashingHandler<>(obj));
    }
}
