package com.xp.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 书本类型表
 * </p>
 *
 * @author xp
 * @since 2020-08-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ebook_book_category")
@ApiModel(value="BookCategory对象", description="书本类型表")
public class BookCategory implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "书本类型id")
    @TableId(value = "book_category_id", type = IdType.AUTO)
    private Integer bookCategoryId;

    @ApiModelProperty(value = "类型名称")
    @TableField("category_name")
    private String categoryName;


}
