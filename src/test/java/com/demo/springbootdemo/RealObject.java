package com.demo.springbootdemo;

/**
 * @ClassName: RealObject
 * @Author: zhanghongkai
 * @Date: Create in 2019/2/14 9:03
 * @Version: 1.0
 */
public class RealObject implements AbstractObject{
    @Override
    public void doSomething() {
        System.out.println("something");
    }
}
