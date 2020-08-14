package com.xp.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xp.model.dto.BookDTO;
import com.xp.model.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 书籍业务接口测试类
 * <p>
 * create by 2020-08-11
 *
 * @author xp
 */
@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    void test() {
        IPage<BookDTO> bookDTOIPage = bookService.queryAllBook(new Page<BookDTO>(1, 10), new QueryWrapper());
        for (BookDTO record : bookDTOIPage.getRecords()) {

            System.out.println(record);
        }
    }

    @Test
    void test1(){
        System.out.println(bookService.update(new UpdateWrapper<Book>().setSql( "book_read_time=book_read_time+1").setEntity(new Book().setBookId(90))));
    }

}
