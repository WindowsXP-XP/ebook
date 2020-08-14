package com.xp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xp.model.entity.Book;
import com.xp.model.entity.Content;
import com.xp.service.BookService;
import com.xp.service.ContentService;
import com.xp.util.JackSonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 书籍内容表 前端控制器
 * </p>
 *
 * @author xp
 * @since 2020-08-05
 */
@RestController
@RequestMapping("/content")
public class ContentController {

    @Autowired
    ContentService contentService;
    @Autowired
    BookService bookService;

    @RequestMapping("/queryContent/{bookId}/{chapterNum}")
    public String queryContent(@PathVariable("bookId") Integer bookId, @PathVariable("chapterNum") Integer chapterNum ){
        // 文章阅读量加1
        bookService.update(new UpdateWrapper<Book>().setSql("book_read_time=book_read_time+1").setEntity(new Book().setBookId(bookId)));

        Map<String, Object> map = new HashMap<>();
        // 查询数据库
        Book book = bookService.getOne(new QueryWrapper<Book>().select("book_author").eq("book_id", bookId));
        Content content = contentService.getOne(new QueryWrapper<Content>().eq("book_id", bookId).eq("chapter_num",chapterNum));
        // 讲数据封装成 JSON 格式字符串发送给前端
        map.put("author",book.getBookAuthor());
        map.put("content",content);
        return JackSonUtil.toJson(map);
    }

}

