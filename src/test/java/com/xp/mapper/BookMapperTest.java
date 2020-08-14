package com.xp.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xp.model.dto.BookDTO;
import com.xp.model.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 书本mapper接口 测试了哦
 *
 * create by 2020-08-09
 * @author xp
 */
@SpringBootTest
public class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    void test(){
        Page<Book> bookPage = bookMapper.selectPage(new Page<Book>(1, 10), null);
        List<Book> books = bookPage.getRecords();
//        List<Book> books = bookMapper.selectList(null);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    void test1(){
        QueryWrapper<BookDTO> queryWrapper = new QueryWrapper<>();
//        IPage<BookDTO> bookDTOIPage = bookMapper.queryAllBook(new Page<BookDTO>(1, 10), queryWrapper.eq("book_is_deleted",0));
        IPage<BookDTO> bookDTOIPage = bookMapper.queryAllBook(new Page<BookDTO>(1, 10),
                queryWrapper.like("concat(book_name,book_author,book_introduction)","辰").orderByAsc("book_collection_time").orderByAsc("book_create_time"));
        List<BookDTO> records = bookDTOIPage.getRecords();
        for (BookDTO record : records) {
            System.out.println(record);
        }
    }

}
