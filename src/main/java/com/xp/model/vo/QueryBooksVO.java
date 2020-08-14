package com.xp.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 查询书籍 VO 实体类
 *
 * create by 2020-08-09
 * @author xp
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "查询书籍 VO 实体类")
public class QueryBooksVO {

    @ApiModelProperty(value = "搜索关键词，可以是作者，书名，简介内容")
    private String keyword;

    @ApiModelProperty(value = "是否按书籍藏次数排序")
    private boolean bookCollectionTime;

    @ApiModelProperty(value = "是否按书籍字数排序")
    private boolean bookTotalWord;

    @ApiModelProperty(value = "是否按书籍上架时间排序")
    private boolean bookCreateTime;

    @ApiModelProperty(value = "是否按书籍更新时间排序")
    private boolean bookModifiedTime;

    @ApiModelProperty(value = "是否按书籍阅读次数排序")
    private boolean bookReadTime;

    @ApiModelProperty(value = "书本类型id")
    private Integer bookCategoryId;

}
