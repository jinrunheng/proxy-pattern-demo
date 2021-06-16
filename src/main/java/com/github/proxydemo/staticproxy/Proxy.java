package com.github.proxydemo.staticproxy;

public class Proxy implements Subject{

    private Subject delegate = null;

    @Override
    public void doAction() {
        if(delegate == null){
            delegate = new RealSubject();
            System.out.println("before invoke doAction...");
            delegate.doAction();
            System.out.println("after invoke doAction...");
        }
    }
}
