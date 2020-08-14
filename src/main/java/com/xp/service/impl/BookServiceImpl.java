package com.xp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xp.mapper.BookMapper;
import com.xp.model.dto.BookDTO;
import com.xp.model.entity.Book;
import com.xp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 电子书表 服务实现类
 * </p>
 *
 * @author xp
 * @since 2020-08-08
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public IPage<BookDTO> queryAllBook(Page<?> page, QueryWrapper<?> wrapper) {
        // 手动拼接逻辑删除
        if (wrapper == null){
            wrapper = new QueryWrapper<BookDTO>();
        }
        wrapper.eq("book_is_deleted",0);
        return bookMapper.queryAllBook(page,wrapper);
    }

    @Override
    public BookDTO queryBookDetailById(Integer id) {
        return bookMapper.queryBookDetailById(id);
    }
}
