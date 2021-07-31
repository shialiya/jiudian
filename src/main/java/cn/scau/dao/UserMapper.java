package cn.scau.dao;

import cn.scau.pojo.Staff;
import cn.scau.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName：User
 * @Description：TODO
 * @Author： lishuai
 * @Date：2021/7/31 1:13 下午
 * @Versiion：1.0
 */
public interface UserMapper {
    User checkStaff (@Param("youxaing") String youxaing, @Param("password") String password);
}
