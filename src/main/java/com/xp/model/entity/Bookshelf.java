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
 * 书架表
 * </p>
 *
 * @author xp
 * @since 2020-08-05
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("ebook_bookshelf")
@ApiModel(value="Bookshelf对象", description="书架表")
public class Bookshelf implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "书架id")
    @TableId(value = "bs_id", type = IdType.AUTO)
    private Integer bsId;

    @ApiModelProperty(value = "书架名")
    @TableField("bs_name")
    private String bsName;

    @ApiModelProperty(value = "书架所属用户")
    @TableField("bs_user_id")
    private Integer bsUserId;

    @ApiModelProperty(value = "书架上的书id")
    @TableField("bs_book_id")
    private Integer bsBookId;

    @ApiModelProperty(value = "书架上书的状态，默认为0，为1时表示逻辑删除")
    @TableField("bs_book_is_deleted")
    @TableLogic
    private Integer bsBookIsDeleted;

    @ApiModelProperty(value = "书籍加入书架的时间")
    @TableField(value = "bs_create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "书籍逻辑删除时间")
    @TableField(value = "bs_modified_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifiedTime;


}
