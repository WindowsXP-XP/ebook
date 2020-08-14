package com.xp.service.impl;

import com.xp.model.entity.Permission;
import com.xp.mapper.PermissionMapper;
import com.xp.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author xp
 * @since 2020-08-05
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

}
