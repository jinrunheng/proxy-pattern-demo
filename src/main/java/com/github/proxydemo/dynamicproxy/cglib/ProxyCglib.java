package com.github.proxydemo.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyCglib implements MethodInterceptor {

    private Object delegate;

    public Object getInstance(Object realSubject) {
        this.delegate = realSubject;
        // Cglib 中的加强器，用来创建动态代理
        Enhancer enhancer = new Enhancer();
        // 设置超类，因为 cglib 基于父类来生成代理子类
        enhancer.setSuperclass(delegate.getClass());
        //设置回调，这里相当于是对于代理类上所有方法的调用，都会调用Callback，而Callback则需要实现intercept()方法进行拦截
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before invoke doAction...");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("after invoke doAction...");
        return object;
    }
}
