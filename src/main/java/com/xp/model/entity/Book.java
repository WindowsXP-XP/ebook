package com.xp.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 电子书表
 * </p>
 *
 * @author xp
 * @since 2020-08-08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("ebook_book")
@ApiModel(value="Book对象", description="电子书表")
public class Book implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "书本id")
    @TableId(value = "book_id", type = IdType.AUTO)
    private Integer bookId;

    @ApiModelProperty(value = "书名")
    @TableField("book_name")
    private String bookName;

    @ApiModelProperty(value = "作者")
    @TableField("book_author")
    private String bookAuthor;

    @ApiModelProperty(value = "书籍简介")
    @TableField("book_introduction")
    private String bookIntroduction;

    @ApiModelProperty(value = "书籍藏次数")
    @TableField("book_collection_time")
    private Integer bookCollectionTime;

    @ApiModelProperty(value = "书籍封面图片")
    @TableField("book_image")
    private String bookImage;

    @ApiModelProperty(value = "书籍字数")
    @TableField("book_total_word")
    private Long bookTotalWord;

    @ApiModelProperty(value = "书籍状态，默认为0，为1时表示逻辑删除")
    @TableField("book_is_deleted")
    @TableLogic
    private Integer bookIsDeleted;

    @ApiModelProperty(value = "书籍上架时间")
    @TableField(value = "book_create_time" , fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "书籍更新时间")
    @TableField(value = "book_modified_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifiedTime;

    @ApiModelProperty(value = "书籍阅读次数")
    @TableField("book_read_time")
    private Long bookReadTime;

    @ApiModelProperty(value = "作者用户id")
    @TableField("book_author_id")
    private Integer bookAuthorId;

    @ApiModelProperty(value = "书本类型id")
    @TableField("book_category_id")
    private Integer bookCategoryId;

}
