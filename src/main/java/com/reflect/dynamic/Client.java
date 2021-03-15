package com.reflect.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: yhl
 * @DateTime: 2019/11/22 9:53
 * @Description:
 */
public class Client {

    public static void main(String[] args) {
        UserServiceInvacationHandler handler = new UserServiceInvacationHandler(new UserServiceImpl());
        final UserService userService = (UserService) Proxy.newProxyInstance(
                                         Client.class.getClassLoader(), UserServiceImpl.class.getInterfaces(), handler);
        userService.insert();

        // 可以代理系统类
        TestHandler testHandler = new TestHandler(new ArrayList());
        final List list = (List) Proxy.newProxyInstance(
                Client.class.getClassLoader(), ArrayList.class.getInterfaces(), testHandler);
        list.add("a");
        System.out.println(list.get(0));

    }


}

class TestHandler implements InvocationHandler {

    /**
     * 被代理的对象
     */
    private Object target;

    public TestHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        final String name = method.getName();
        System.out.println(name+" add before");
        Object invoke = method.invoke(target, args);
        System.out.println(name+" add after");
        return invoke;
    }
}
