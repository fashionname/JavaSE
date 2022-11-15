package com.cowbaby.java.Util;

public class StaticProxyFactory {

    public Object o;

    public StaticProxyFactory(Object o){
        this.o = o;
    }

    public void start(){
        System.out.println("begin...");
    }

    public void end(){
        System.out.println("end...");
    }

    public void proxyUserToString(){
        this.start();

        if(o instanceof User){
            System.out.println(o);
        }

        this.end();
    }
    public static void main(String[] args) {
        new StaticProxyFactory(new User()).proxyUserToString();
    }
}
