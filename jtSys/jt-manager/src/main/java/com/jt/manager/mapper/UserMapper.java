package com.jt.manager.mapper;

import com.jt.manager.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author sumail
 * @date 2019/8/23 0023-${time}
 */
public interface UserMapper {

    //查询User表中的数据
//    @Select(value = "select id,name,age,sex from user")
    List<User> findAll();
}
