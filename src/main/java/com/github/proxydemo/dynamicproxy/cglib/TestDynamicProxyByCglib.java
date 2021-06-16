package com.github.proxydemo.dynamicproxy.cglib;

public class TestDynamicProxyByCglib {
    public static void main(String[] args) {
        ProxyCglib proxy = new ProxyCglib();
        RealSubject delegate = (RealSubject)proxy.getInstance(new RealSubject());
        delegate.doAction();
    }
}
