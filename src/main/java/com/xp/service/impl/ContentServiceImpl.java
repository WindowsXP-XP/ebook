package com.xp.service.impl;

import com.xp.model.entity.Content;
import com.xp.mapper.ContentMapper;
import com.xp.service.ContentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 书籍内容表 服务实现类
 * </p>
 *
 * @author xp
 * @since 2020-08-05
 */
@Service
public class ContentServiceImpl extends ServiceImpl<ContentMapper, Content> implements ContentService {

}
