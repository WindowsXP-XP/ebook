package com.xp.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author xp
 * @since 2020-08-05
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("ebook_comment")
@ApiModel(value="Comment对象", description="评论表")
public class Comment implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "评论id")
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Integer commentId;

    @ApiModelProperty(value = "评论的人")
    @TableField("comment_from_user_id")
    private Integer commentFromUserId;

    @ApiModelProperty(value = "被评论的人")
    @TableField("comment_to_user_id")
    private Integer commentToUserId;

    @ApiModelProperty(value = "被评论的书籍id")
    @TableField("book_id")
    private Integer bookId;

    @ApiModelProperty(value = "评论的内容")
    @TableField("comment_content")
    private String commentContent;

    @ApiModelProperty(value = "评论审核的状态，默认为0，为1是代表审核通过")
    @TableField("comment_status")
    private Integer commentStatus;

    @ApiModelProperty(value = "评论删除状态，默认为0，为1时表示逻辑删除")
    @TableField("comment_is_deleted")
    @TableLogic
    private Integer commentIsDeleted;

    @ApiModelProperty(value = "评论创建时间")
    @TableField(value = "comment_create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "评论修改时间")
    @TableField(value = "comment_modified_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifiedTime;


}
