package com.xp.model.dto;

import com.xp.model.entity.Book;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 书籍 DTO 实体类
 *
 * creat by 2020-08-09
 * @author xp
 */
@ApiModel(value = "书籍DTP实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BookDTO implements Serializable {

    private static final long serialVersionUID = 1364423380516984160L;

    @ApiModelProperty(value = "书籍信息")
    private Book book;

    @ApiModelProperty(value = "类型名称")
    private String categoryName;

}
