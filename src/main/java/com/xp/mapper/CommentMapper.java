package com.xp.mapper;

import com.xp.model.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 评论表 Mapper 接口
 * </p>
 *
 * @author xp
 * @since 2020-08-05
 */
@Repository
public interface CommentMapper extends BaseMapper<Comment> {

}
