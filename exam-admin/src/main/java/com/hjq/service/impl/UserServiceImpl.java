package com.hjq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjq.entity.User;
import com.hjq.mapper.UserMapper;
import com.hjq.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Date 2020/10/20 9:05
 * @created by hjq
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
