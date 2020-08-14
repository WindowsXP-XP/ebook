package com.xp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xp.mapper.UserMapper;
import com.xp.mapper.UserRoleMapper;
import com.xp.model.dto.UserDTO;
import com.xp.model.entity.User;
import com.xp.model.entity.UserRole;
import com.xp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author xp
 * @since 2020-08-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRoleMapper userRoleMapper;


    @Override
    public UserDTO queryUserByUserAccount(String account) {
        return userMapper.queryUserByUserAccount(account);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean registerUser(User user) {
        try {
            userMapper.insert(user);
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("account",user.getAccount());
            User roleUser = userMapper.selectOne(wrapper);
            userRoleMapper.insert(new UserRole().setUserId(roleUser.getUserId()).setRoleId(4));
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public IPage<UserDTO> queryAllUser(Page<UserDTO> page, QueryWrapper<?> wrapper) {
        // 手动拼接逻辑删除
        if (wrapper == null){
            wrapper = new QueryWrapper<UserDTO>();
        }
        // .eq("user_is_deleted",0)
        wrapper.eq("role_is_deleted",0).eq("permission_is_deleted",0);
        return userMapper.queryAllUser(page,wrapper);
    }

}
