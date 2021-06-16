package com.github.proxydemo.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyHandler implements InvocationHandler {

    Object delegate = null;

    public Object newProxyInstance(Subject realSubject) {
        this.delegate = realSubject;
        Class<?> clazz = delegate.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke doAction...");
        method.invoke(delegate, args);
        System.out.println("after invoke doAction...");
        return null;
    }
}
