package com.xp.service.impl;

import com.xp.model.entity.Role;
import com.xp.mapper.RoleMapper;
import com.xp.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author xp
 * @since 2020-08-05
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
