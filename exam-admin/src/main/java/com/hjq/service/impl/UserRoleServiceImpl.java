package com.hjq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjq.entity.UserRole;
import com.hjq.mapper.UserRoleMapper;
import com.hjq.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * @Date 2020/10/20 19:50
 * @created by hjq
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {
}
