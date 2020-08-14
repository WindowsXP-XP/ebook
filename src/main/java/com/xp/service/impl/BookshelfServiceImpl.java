package com.xp.service.impl;

import com.xp.model.entity.Bookshelf;
import com.xp.mapper.BookshelfMapper;
import com.xp.service.BookshelfService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 书架表 服务实现类
 * </p>
 *
 * @author xp
 * @since 2020-08-05
 */
@Service
public class BookshelfServiceImpl extends ServiceImpl<BookshelfMapper, Bookshelf> implements BookshelfService {

}
