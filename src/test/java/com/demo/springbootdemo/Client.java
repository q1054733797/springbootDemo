package com.demo.springbootdemo;

import java.lang.reflect.Proxy;

/**
 * @ClassName: Client
 * @Author: zhanghongkai
 * @Date: Create in 2019/2/14 9:04
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        ProxySubject proxySubject = new ProxySubject(realObject);
        proxySubject.doSomething();
        proxySubject.doOtherthing();
        SubjectHandler handler = new SubjectHandler(realObject);
        AbstractObject abstractObject = (AbstractObject)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{AbstractObject.class}, handler);
        abstractObject.doSomething();
    }
}
