package cn.scau.service;

import cn.scau.dao.StaffMapper;
import cn.scau.dao.UserMapper;
import cn.scau.pojo.Staff;
import cn.scau.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName：UserService
 * @Description：TODO
 * @Author： lishuai
 * @Date：2021/7/31 1:23 下午
 * @Versiion：1.0
 */
@Service
public class UserService implements  UserServiceImpl {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String name, String pd) {
        // TODO Auto-generated method stub
        return userMapper.checkStaff(name, pd);
    }

}
