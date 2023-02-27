package com.ehsanzhao.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ehsanzhao.springboot.entity.User;
import com.ehsanzhao.springboot.mapper.UserMapper;
import com.ehsanzhao.springboot.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author zhaoyuan
 * @date 2023/2/27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
