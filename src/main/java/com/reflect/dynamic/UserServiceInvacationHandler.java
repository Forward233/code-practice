package com.reflect.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: yhl
 * @DateTime: 2019/11/22 9:50
 * @Description:  继承InvocationHandler，编写代理后的增强逻辑
 *
 * reference：[为什么JDK的动态代理要基于接口实现而不能基于继承实现？-掘金](https://juejin.im/post/5d8a0799f265da5b7a752e7c)
 */
public class UserServiceInvacationHandler implements InvocationHandler {

    /**
     * 被代理的对象
     */
    private Object target;

    public UserServiceInvacationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        final String name = method.getName();
        System.out.println(name+" before");
        method.invoke(target, args);
        System.out.println(name+" after");
        return null;
    }
}
