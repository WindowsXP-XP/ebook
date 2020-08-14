package com.xp.model.vo;

import com.xp.model.dto.BookDTO;
import com.xp.model.entity.Book;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 展示所有书籍 VO 实体类
 *
 * create by 2020-08-09
 * @author xp
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "展示所有书籍的实体类")
public class ShowBooksVO {

    @ApiModelProperty(value = "书本id")
    private Integer bookId;

    @ApiModelProperty(value = "书名")
    private String bookName;

    @ApiModelProperty(value = "作者")
    private String bookAuthor;

    @ApiModelProperty(value = "书籍简介")
    private String bookIntroduction;


    @ApiModelProperty(value = "书籍藏次数")
    private Integer bookCollectionTime;

    @ApiModelProperty(value = "书籍封面图片")
    private String bookImage;

    @ApiModelProperty(value = "书籍字数")
    private Long bookTotalWord;

    @ApiModelProperty(value = "书籍上架时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "书籍更新时间")
    private LocalDateTime modifiedTime;

    @ApiModelProperty(value = "书籍阅读次数")
    private Long bookReadTime;

    @ApiModelProperty(value = "书本类型")
    private String bookCategory;

    /**
     * 将 书籍 DTO 中的数据转换成 VO 实体类
     *
     * @param bookDTO 待转换的 书籍 DTO 对象
     */
    public ShowBooksVO(BookDTO bookDTO){
        Book book = bookDTO.getBook();
        this.bookId = book.getBookId();
        this.bookName = book.getBookName();
        this.bookAuthor = book.getBookAuthor();
        this.bookIntroduction = book.getBookIntroduction();
        this.bookCollectionTime = book.getBookCollectionTime();
        this.bookImage = book.getBookImage();
        this.bookTotalWord = book.getBookTotalWord();
        this.createTime = book.getCreateTime();
        this.createTime = book.getModifiedTime();
        this.bookReadTime = book.getBookReadTime();
        this.bookCategory = bookDTO.getCategoryName();
    }


}
