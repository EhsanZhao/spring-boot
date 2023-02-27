package com.ehsanzhao.springboot.mapper;

import com.ehsanzhao.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhaoyuan
 * @date 2023/2/27
 */
@Mapper
public interface UserMapper {

    User getUser(String user);

}
