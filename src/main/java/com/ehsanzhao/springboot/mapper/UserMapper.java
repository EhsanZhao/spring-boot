package com.ehsanzhao.springboot.mapper;

import com.ehsanzhao.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhaoyuan
 * @date 2023/2/27
 */
@Mapper
public interface UserMapper {

    User getUser(String user);

    @Select("select * from user where host = #{host}")
    List<User> getUserByHost(String host);

}
