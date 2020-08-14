package com.xp.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xp.model.dto.BookDTO;
import com.xp.model.entity.Book;

/**
 * <p>
 * 电子书表 服务类
 * </p>
 *
 * @author xp
 * @since 2020-08-08
 */
public interface BookService extends IService<Book> {


    /**
     * 查询所有的书本信息
     * 返回 BookDTO 对象对数据进行存储
     *
     * @return BookDTO对象
     */
    IPage<BookDTO> queryAllBook(Page<?> page, QueryWrapper<?> wrapper);

    /**
     * 根据书籍id查询书籍信息
     *
     * @return  存储书籍信息的DTO对象
     */
    BookDTO queryBookDetailById(Integer id);

}
