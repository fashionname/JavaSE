package com.cowbaby.java.Reflect;

import com.cowbaby.java.Util.User;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {

    /*


     */


    @Test
    public void testStaticProxy(){

        User u = new User();
        Object o = new DynamicProxyFactory(u).getProxyFactory(u);

        if(o instanceof Human){
            ((Human) o).doSome();
            ((Human) o).otherDo();
        }
    }


    static class DynamicProxyFactory{

        private User user;

        public DynamicProxyFactory(User user){
            this.user = user;
        }

        public DynamicProxyFactory(){

        }
        public Object getProxyFactory(Object o){

            InvocationHandler invocationHandler = this.getInvocationHandler();
            Object proxyInstance = Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), invocationHandler);

            return proxyInstance;
        }

        public InvocationHandler getInvocationHandler(){

            return new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    Object o = null;
                    System.out.println("start...");
                    if(user != null){
                         o = method.invoke(user, args);
                    }
                    return o;
                }
            };
        }

    }
}
