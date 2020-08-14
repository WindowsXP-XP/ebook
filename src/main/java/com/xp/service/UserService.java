package com.xp.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xp.model.dto.UserDTO;
import com.xp.model.entity.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author xp
 * @since 2020-08-05
 */
public interface UserService extends IService<User> {

    /**
     * 根据用户登录账号查询用户信息
     * @param account   用户账号
     * @return  用户信息
     */
    UserDTO queryUserByUserAccount(String account);

    /**
     * 注册用户
     * @param user 待注册的用户
     * @return  数据库影响行数
     */
    boolean registerUser(User user);

    /**
     * 根据 wrapper 分页查询用户信息
     * 数据存储到 DTO 中
     *
     * @param page      分页信息
     * @param wrapper   wrapper 对象
     * @return  存储用户 DTO 的集合
     */
    IPage<UserDTO> queryAllUser(Page<UserDTO> page, QueryWrapper<?> wrapper);

}
