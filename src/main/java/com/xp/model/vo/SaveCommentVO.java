package com.xp.model.vo;

import com.xp.model.entity.Comment;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 保存评论 VO
 *
 * create by 2020-08-13
 * @author xp
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("保存评论 VO")
public class SaveCommentVO {

    @ApiModelProperty(value = "评论的人")
    private Integer commentFromUserId;

    @ApiModelProperty(value = "被评论的人")
    private Integer commentToUserId;

    @ApiModelProperty(value = "被评论的书籍id")
    private Integer bookId;

    @ApiModelProperty(value = "评论的内容")
    private String commentContent;

    public Comment toComment(){
        return new Comment().setBookId(bookId).setCommentFromUserId(commentFromUserId).setCommentToUserId(commentToUserId).setCommentContent(commentContent);
    }

}
