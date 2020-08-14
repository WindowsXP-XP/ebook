package com.xp.model.dto;

import com.baomidou.mybatisplus.annotation.*;
import com.xp.model.entity.Book;
import com.xp.model.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 书架 DTO
 *
 * create by 2020-08-05
 * @author xp
 */
@ApiModel("书架 DTO")
@Data
@Accessors(chain = true)
public class BookShelfDTO implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "书架id")
    @TableId(value = "bs_id", type = IdType.AUTO)
    private Integer bsId;

    @ApiModelProperty(value = "书架名")
    @TableField("bs_name")
    private String bsName;

    @ApiModelProperty(value = "书架所属用户")
    private User user;

    @ApiModelProperty(value = "书架上的书")
    private Book book;

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
