package com.xp.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xp.model.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 用户 mapper 接口 测试
 *
 * create by 2020-08-11
 * @author xp
 */
@SpringBootTest
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    void test(){
        IPage<UserDTO> userDTOIPage = userMapper.queryAllUser(new Page<UserDTO>(1, 10), new QueryWrapper<>());
        for (UserDTO record : userDTOIPage.getRecords()) {
            System.out.println(record);
        }

    }

}
