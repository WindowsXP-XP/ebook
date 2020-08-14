package com.xp.controller;


import com.xp.model.entity.BookCategory;
import com.xp.service.BookCategoryService;
import com.xp.util.JackSonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 书本类型表 前端控制器
 * </p>
 *
 * @author xp
 * @since 2020-08-08
 */
@RestController
@RequestMapping("/bookCategory")
public class BookCategoryController {

    @Autowired
    BookCategoryService bookCategoryService;

    @GetMapping("/getBookCategory")
    public String getBookCategory(){
        // 查询数据库
        List<BookCategory> bookCategories = bookCategoryService.list();
        // 返回数据
        return JackSonUtil.toJson(bookCategories);
    }


}

