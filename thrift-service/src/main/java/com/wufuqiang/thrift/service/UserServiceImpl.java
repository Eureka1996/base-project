package com.wufuqiang.thrift.service;

import com.wufuqiang.thrift.User;
import com.wufuqiang.thrift.UserService;
import org.apache.thrift.TException;

/**
 * @author wufuqiang
 * @date 2022/6/26 10:10
 **/

public class UserServiceImpl implements UserService.Iface {
    @Override
    public User getById(int id) throws TException {
        System.out.println("=====调用getById====");
        User user = new User();
        user.setId(id);
        user.setName("wufuqiang");
        user.setAge(18);
        return user;
    }

    @Override
    public boolean isExist(String name) throws TException {
        return true;
    }
}
