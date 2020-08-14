package com.xp;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import com.xp.mapper.BookMapper;
import com.xp.mapper.BookshelfMapper;
import com.xp.mapper.UserMapper;
import com.xp.model.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class EbooknetApplicationTests {

    @Autowired
    BookMapper bookMapper;

    @Autowired
    BookshelfMapper bookshelfMapper;

    @Autowired
    private UserMapper userMapperl;

    @Test
    void contextLoads() {
        UserDTO user = userMapperl.queryUserByUserAccount("zhangsan");
        System.out.println(user);
    }

    @Test
    void myBatisPlusGenerator() {
        // 创建 AutoGenerator 对象
        AutoGenerator autoGenerator = new AutoGenerator();
        // 1. 设置全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig
                .setOutputDir(System.getProperty("user.dir") + "/src/main/java")  // 设置输出的路径
                .setOpen(false)                     // 是否打开目录
                .setIdType(IdType.AUTO)             // 设置主键策略
                .setAuthor("xp")                    // 自动设置作者名
                .setFileOverride(false)             // 是否覆盖
                .setEntityName("")                  // 设置entity 实体类名字
                .setControllerName("%sController")  // 设置Controller名字
                .setServiceName("%sService")        // 设置Service 接口名字
                .setServiceImplName("%sServiceImpl")// 设置Service 接口实现类名字
                .setMapperName("%sMapper")          // 设置Mapper 接口名字
                .setBaseResultMap(true)             // 是否创建resultMap
                .setSwagger2(true);                 // 设置开启 swagger2 注解
        autoGenerator.setGlobalConfig(globalConfig);    // 将全局配置注入到代码生成器中

        // 2. 配置数据源
        DataSourceConfig sourceConfig = new DataSourceConfig();
        sourceConfig
                .setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/ebook?useUnicode=true&useSSL=false&characterEncoding=utf8")
                .setUsername("root")
                .setPassword("root");
        autoGenerator.setDataSource(sourceConfig);  // 将数据源配置注入到代码生成器中

        // 3. 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig
                .setEntity("model.entity")          // 设置实体类路径
                .setParent("com.xp");               // 设置父包名
        autoGenerator.setPackageInfo(packageConfig);// 将包配置注入到代码生成器中
        // 配置 xml 自动输出路径
        String templatePath = "/templates/mapper.xml.vm";   // 配置模板引擎路径
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return System.getProperty("user.dir") + "/src/main/resources/mapper/"
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        autoGenerator.setCfg(cfg);
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        // 配置自定义输出模板
        templateConfig.setXml(null);                // 取消默认的 xml 路径
        autoGenerator.setTemplate(templateConfig);  // 将模板注入到代码生成器中
        autoGenerator.setTemplateEngine(new VelocityTemplateEngine()); // 将模板引擎注入到代码生成器中

        // 4. 配置策略
        StrategyConfig strategyConfig = new StrategyConfig();
        TableFill createTime = new TableFill("%s_create_time", FieldFill.INSERT);
        TableFill modifiedTime = new TableFill("%s_modified_time", FieldFill.INSERT_UPDATE);
        strategyConfig
                .setTablePrefix("ebook_")                                   // 去掉表名前缀
//                .setInclude("ebook_user", "ebook_role", "ebook_permission", "ebook_user_role", "ebook_role_permission", "ebook_book"
//                        , "ebook_bookshelf", "ebook_content", "ebook_comment") // 设置需要映射的表名
                .setInclude("ebook_book","ebook_book_category")
                .setRestControllerStyle(true)                               // Controller 添加 RestController 注解
                .setEntityLombokModel(true)                                 // 是否使用 lombok
                .setEntityTableFieldAnnotationEnable(true)                  // 是否生成实体时，生成字段注解
                .setVersionFieldName("version")                             // 设置乐观锁版本字段
                .setTableFillList(Arrays.asList(createTime, modifiedTime))   // 设置自动填充规则
                .setLogicDeleteFieldName("%sis_deleted")                    // 设置逻辑删除字段
                .setNaming(NamingStrategy.underline_to_camel)               // 数据库映射到实体类的名字为驼峰命名
                .setColumnNaming(NamingStrategy.underline_to_camel);        // 字段名映射驼峰命名
        autoGenerator.setStrategy(strategyConfig);  // 将配置策略注入到代码生成器中

        // 5. 执行代码生成器
        autoGenerator.execute();
    }

}
