package com.github.proxydemo.dynamicproxy.jdk;

public class RealSubject implements Subject{

    @Override
    public void doAction() {
        System.out.println("do action");
    }
}
