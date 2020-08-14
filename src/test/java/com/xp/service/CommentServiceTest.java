package com.xp.service;

import com.xp.model.entity.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 评论业务测试
 *
 * create by 2020-08-13
 * @author xp
 */
@SpringBootTest
public class CommentServiceTest {

    @Autowired
    CommentService commentService;

    @Test
    void test(){
        System.out.println(commentService.save(new Comment().setBookId(6).setCommentFromUserId(2).setCommentContent("测试")));
    }

}
