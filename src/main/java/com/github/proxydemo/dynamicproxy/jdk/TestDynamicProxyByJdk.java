package com.github.proxydemo.dynamicproxy.jdk;

public class TestDynamicProxyByJdk {
    public static void main(String[] args) {
        Subject subject = (Subject) new DynamicProxyHandler().newProxyInstance(new RealSubject());
        subject.doAction();
    }
}
