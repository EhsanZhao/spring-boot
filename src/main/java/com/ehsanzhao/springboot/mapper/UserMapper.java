package com.ehsanzhao.springboot.mapper;

import com.ehsanzhao.springboot.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
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

    @Insert("insert into xxx (xxx)values(#{host}) ")
    // useGeneratedKeys这会令 MyBatis 使用 JDBC 的 getGeneratedKeys 方法来取出由数据库内部生成的主键
    // keyProperty指定能够唯一识别对象的属性，MyBatis 会使用 getGeneratedKeys 的返回值或 insert 语句的 selectKey 子元素设置它的值
    @Options(useGeneratedKeys = true,keyProperty = "id")
    List<User> insert(String host);

}
