package com.xp.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xp.model.dto.BookDTO;
import com.xp.model.entity.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 电子书表 Mapper 接口
 * </p>
 *
 * @author xp
 * @since 2020-08-08
 */
@Repository
public interface BookMapper extends BaseMapper<Book> {

    /**
     * 查询所有的书本信息
     * 返回 BookDTO 对象对数据进行存储
     *
     * @return BookDTO对象
     */
    IPage<BookDTO> queryAllBook(Page<?> page, @Param(Constants.WRAPPER)Wrapper wrapper);

    /**
     * 根据书籍id查询书籍信息
     *
     * @return  存储书籍信息的DTO对象
     */
    BookDTO queryBookDetailById(Integer id);

}
