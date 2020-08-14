package com.xp.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.xp.model.entity.Book;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 首页书籍展示 VO类
 *
 * create by 2020-008-08
 * @author xp
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class IndexBookVO {

    @ApiModelProperty(value = "书本id")
    @TableId(value = "book_id", type = IdType.AUTO)
    private Integer bookId;

    @ApiModelProperty(value = "书名")
    @TableField("book_name")
    private String bookName;

    @ApiModelProperty(value = "作者")
    @TableField("book_author")
    private String bookAuthor;

    @ApiModelProperty(value = "书籍封面图片")
    private String bookImage;

    public IndexBookVO(Book book) {
        this.bookId = book.getBookId();
        this.bookName = book.getBookName();
        this.bookAuthor = book.getBookAuthor();
        this.bookImage = book.getBookImage();
    }
}
