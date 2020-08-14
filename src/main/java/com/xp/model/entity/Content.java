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
 * 书籍内容表
 * </p>
 *
 * @author xp
 * @since 2020-08-05
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("ebook_content")
@ApiModel(value="Content对象", description="书籍内容表")
public class Content implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "书籍内容id")
    @TableId(value = "content_id", type = IdType.AUTO)
    private Integer contentId;

    @ApiModelProperty(value = "章节标题")
    @TableField("chapter_title")
    private String chapterTitle;

    @ApiModelProperty(value = "章节内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "章节所属的书籍id")
    @TableField("book_id")
    private Integer bookId;

    @ApiModelProperty(value = "章节号")
    @TableField("chapter_num")
    private Integer chapterNum;

    @ApiModelProperty(value = "章节状态，默认是0，为1时是逻辑删除")
    @TableField("content_is_deleted")
    @TableLogic
    private Integer contentIsDeleted;

    @ApiModelProperty(value = "章节内容创建时间")
    @TableField(value = "content_create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "章节内容修改时间")
    @TableField(value = "content_modified_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modified_time;


}
