package com.github.proxydemo.staticproxy;

public class TestStaticProxy {
    public static void main(String[] args) {
        Subject subject = new Proxy();
        subject.doAction();
    }
}
