package com.xp.model.vo;

import com.xp.model.entity.Comment;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 评论 VO
 *
 * create by 2020-08-13
 * @author xp
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("评论 VO")
public class CommentVO {

    @ApiModelProperty(value = "评论id")
    private Integer commentId;

    @ApiModelProperty(value = "评论的人id")
    private Integer commentFromUserId;

    @ApiModelProperty(value = "被评论的人id")
    private Integer commentToUserId;

    @ApiModelProperty(value = "评论的人")
    private String commentFromUser;

    @ApiModelProperty(value = "被评论的人")
    private String commentToUser;

    @ApiModelProperty(value = "被评论的书籍id")
    private Integer bookId;

    @ApiModelProperty(value = "评论的内容")
    private String commentContent;

    @ApiModelProperty(value = "评论审核的状态，默认为0，为1是代表审核通过")
    private Integer commentStatus;

    @ApiModelProperty(value = "评论创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "评论修改时间")
    private LocalDateTime modifiedTime;

    public CommentVO(Comment comment) {
        this.commentId = comment.getCommentId();
        this.bookId = comment.getBookId();
        this.commentFromUserId = comment.getCommentFromUserId();
        this.commentToUserId = comment.getCommentToUserId();
        this.commentContent = comment.getCommentContent();
        this.commentStatus = comment.getCommentStatus();
        this.createTime = comment.getCreateTime();
        this.modifiedTime = comment.getModifiedTime();
    }
}
