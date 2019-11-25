package com.reflect.dynamic;

import java.lang.reflect.Proxy;

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
    }
}
