package com.github.proxydemo.staticproxy;

public class RealSubject implements Subject {

    @Override
    public void doAction() {
        System.out.println("do action");
    }
}
