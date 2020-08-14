package com.xp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xp.model.dto.BookShelfDTO;
import com.xp.model.entity.Bookshelf;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 书架表 Mapper 接口
 * </p>
 *
 * @author xp
 * @since 2020-08-05
 */
@Repository
public interface BookshelfMapper extends BaseMapper<Bookshelf> {

    List<BookShelfDTO> test();

}
