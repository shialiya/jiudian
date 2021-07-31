package cn.scau.service;

import cn.scau.pojo.Staff;
import cn.scau.pojo.User;

/**
 * @ClassName：UserServiceImpl
 * @Description：TODO
 * @Author： lishuai
 * @Date：2021/7/31 1:23 下午
 * @Versiion：1.0
 */
public interface UserServiceImpl {
    public User login(String id, String pd);
}
