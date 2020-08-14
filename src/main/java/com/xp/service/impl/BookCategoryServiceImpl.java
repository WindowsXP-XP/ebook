package com.xp.service.impl;

import com.xp.model.entity.BookCategory;
import com.xp.mapper.BookCategoryMapper;
import com.xp.service.BookCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 书本类型表 服务实现类
 * </p>
 *
 * @author xp
 * @since 2020-08-08
 */
@Service
public class BookCategoryServiceImpl extends ServiceImpl<BookCategoryMapper, BookCategory> implements BookCategoryService {

}
