package cn.scau.service;

import cn.scau.dao.StaffMapper;
import cn.scau.dao.UserMapper;
import cn.scau.pojo.Staff;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName：UserService
 * @Description：TODO
 * @Author： lishuai
 * @Date：2021/7/31 1:23 下午
 * @Versiion：1.0
 */
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Staff login(String name, String pd) {
        // TODO Auto-generated method stub
        return userMapper.checkStaff(name, pd);
    }

}
