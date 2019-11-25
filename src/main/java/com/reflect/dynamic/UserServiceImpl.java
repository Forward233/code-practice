package com.reflect.dynamic;

/**
 * @author: yhl
 * @DateTime: 2019/11/22 9:49
 * @Description:
 */
public class UserServiceImpl implements UserService {

    @Override
    public void insert() {
        System.out.println("insert ");
    }

    @Override
    public void query() {
        System.out.println("query");
    }

}
