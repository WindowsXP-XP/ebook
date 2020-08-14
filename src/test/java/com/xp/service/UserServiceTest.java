package com.xp.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xp.model.dto.UserDTO;
import com.xp.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 用户业务测试
 *
 * create by 2020-08-06
 * @author xp
 */
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void test(){
        UserDTO user = userService.queryUserByUserAccount("zhangsan");
        System.out.println(user);

        IPage<UserDTO> userDTOIPage = userService.queryAllUser(new Page<UserDTO>(1, 10), null);
        for (UserDTO record : userDTOIPage.getRecords()) {
            System.out.println(record);
        }
    }

    @Test
    void test1(){
        User user = userService.getOne(new QueryWrapper<User>().select("account").eq("user_id", 2));
        System.out.println(user);

        List<User> userList = userService.list(new QueryWrapper<User>().select(User.class, info -> !info.getColumn().equals("account")
                && !info.getColumn().equals("user_name")));
        for (User user1 : userList) {
            System.out.println(user1);
        }
    }

}
