package com.xp.service.impl;

import com.xp.model.entity.UserRole;
import com.xp.mapper.UserRoleMapper;
import com.xp.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author xp
 * @since 2020-08-05
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
