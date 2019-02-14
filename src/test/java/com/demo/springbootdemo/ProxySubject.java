package com.demo.springbootdemo;

/**
 * @ClassName: ProxySubject
 * @Author: zhanghongkai
 * @Date: Create in 2019/2/14 8:58
 * @Version: 1.0
 */
public class ProxySubject implements AbstractObject{
    private AbstractObject real;

    public ProxySubject(AbstractObject real) {
        this.real = real;
    }

    @Override
    public void doSomething() {
        real.doSomething();
    }

    public void doOtherthing(){
        System.out.println("otherthing");
    }
}
