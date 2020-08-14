package com.xp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xp.model.entity.Comment;
import com.xp.model.entity.User;
import com.xp.model.vo.CommentVO;
import com.xp.model.vo.SaveCommentVO;
import com.xp.service.CommentService;
import com.xp.service.UserService;
import com.xp.util.CheckUtil;
import com.xp.util.JackSonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 评论表 前端控制器
 * </p>
 *
 * @author xp
 * @since 2020-08-05
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;


    @RequestMapping("/showComment/{id}")
    public String showComment(@PathVariable("id") Integer id){
        Map<String, Object> map = new HashMap<>();
        List<CommentVO> commentVOS = new ArrayList<>();
        // 查询评论信息
        Page<Comment> commentPage = commentService.page(new Page<Comment>(1, 10), new QueryWrapper<Comment>().eq("book_id", id));
        List<Comment> pageRecords = commentPage.getRecords();
        for (Comment comment : pageRecords) {
            // 查询出用户信息,并封装进 评论 VO 中
            CommentVO commentVO = new CommentVO(comment);
            User fromUser = userService.getOne(new QueryWrapper<User>().select("user_name").eq("user_id",comment.getCommentFromUserId()));
            User toUser = userService.getOne(new QueryWrapper<User>().select("user_name").eq("user_id", comment.getCommentToUserId()));
            if (fromUser != null){
                commentVO.setCommentFromUser(fromUser.getUserName());
            }
            if (!CheckUtil.isEmpty(toUser)){
                commentVO.setCommentFromUser(toUser.getUserName());
            }
            commentVOS.add(commentVO);
        }
        // 将数据传给前端
        map.put("status",0);
        map.put("comment",commentVOS);
        map.put("count",commentPage.getTotal());
        return JackSonUtil.toJson(map);
    }

    @RequestMapping("/saveComment")
    public String saveComment(@RequestBody SaveCommentVO saveCommentVO){
        System.out.println(saveCommentVO);
        Map<String, Object> map = new HashMap<>();
        int status = 0;
        // 保存评论信息并返回信息给前端
        if (CheckUtil.isEmpty(saveCommentVO) || !commentService.save(saveCommentVO.toComment())){
            map.put("msg","评论失败");
            status = 1;
        }
        map.put("status",status);

        return JackSonUtil.toJson(map);
    }

}

