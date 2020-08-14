package com.xp.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 自动填充策略
 * <p>
 * create by 2020-08-13
 *
 * @author xp
 */
@Slf4j      // 使用日志
@Component  // 将我们自定义的元数据处理器注册到 Spring 容器中
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert ");
        System.out.println(LocalDateTime.now());
        // 设置插入的填充策略 参数分别时：第一个为原数据对象，第二个为填充的字段，第三个为填充的内容的Class对象，第四个是填充的内容
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "modifiedTime", LocalDateTime.class, LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update ");
        this.strictUpdateFill(metaObject, "modifiedTime", LocalDateTime.class, LocalDateTime.now());
    }
}
