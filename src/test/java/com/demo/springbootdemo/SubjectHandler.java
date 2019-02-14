package com.demo.springbootdemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName: SubjectHandler
 * @Author: zhanghongkai
 * @Date: Create in 2019/2/14 9:06
 * @Version: 1.0
 */
public class SubjectHandler implements InvocationHandler {
    AbstractObject real;

    public SubjectHandler(AbstractObject real) {
        this.real = real;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理类预处理任务");
        method.invoke(real,args);
        System.out.println("代理类后续处理任务");
        return null;
    }
}
