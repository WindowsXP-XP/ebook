package com.xp.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xp.model.dto.UserDTO;
import com.xp.model.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author xp
 * @since 2020-08-05
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户登录账号查询用户信息
     * @param account   用户账号
     * @return  用户信息
     */
    UserDTO queryUserByUserAccount(String account);

    /**
     * 根据 wrapper 分页查询用户信息
     * 数据存储到 DTO 中
     *
     * @param page      分页信息
     * @param wrapper   wrapper 对象
     * @return  存储用户 DTO 的集合
     */
    IPage<UserDTO> queryAllUser(Page<UserDTO> page, @Param(Constants.WRAPPER)Wrapper<?> wrapper);

}
