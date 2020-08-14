package com.xp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mysql.cj.util.StringUtils;
import com.xp.model.dto.BookDTO;
import com.xp.model.entity.Book;
import com.xp.model.vo.IndexBookVO;
import com.xp.model.vo.QueryBooksVO;
import com.xp.model.vo.ShowBooksVO;
import com.xp.service.BookService;
import com.xp.util.JackSonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 电子书表 前端控制器
 * </p>
 *
 * @author xp
 * @since 2020-08-08
 */
@RestController
@RequestMapping("/book")
@ApiModel("书籍控制器")
public class BookController {

    @Autowired
    public BookService bookService;

    @ApiOperation("初始化首页书籍")
    @GetMapping("/initIndexBook")
    public String initIndexBook() {
        HashMap<String, Object> map = new HashMap<>();
        // 查询热销书
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>(null);
        queryWrapper.orderByDesc("book_read_time");
        Page<Book> recommendBooks = bookService.page(new Page<>(1, 10), queryWrapper);
        map.put("recommendBooks", listToVo(recommendBooks.getRecords()));
        // 本周推荐
        queryWrapper = new QueryWrapper<>(null);
        queryWrapper.orderByDesc("book_modified_time", "book_read_time");
        Page<Book> weekRecommendBooks = bookService.page(new Page<>(1, 2), queryWrapper);
        map.put("weekRecommendBooks", listToVo(weekRecommendBooks.getRecords()));
        // 新书
        queryWrapper = new QueryWrapper<>(null);
        queryWrapper.orderByDesc("book_create_time","book_total_word");
        Page<Book> newBooks = bookService.page(new Page<>(1, 10), queryWrapper);
        map.put("newBooks", listToVo(newBooks.getRecords()));
        // 查询所有的书籍
        Page<Book> allBooks = bookService.page(new Page<Book>(1, 20));
        map.put("allBooks", listToVo(allBooks.getRecords()));
        // 返回数据
        return JackSonUtil.toJson(map);
    }

    @ApiOperation("展示所有书籍")
    @RequestMapping("/toShowBooks")
    public ModelAndView toShowBooks (){
        ModelAndView modelAndView = new ModelAndView();
        // 查询数据库
        IPage<BookDTO> dtoList = bookService.queryAllBook(new Page<Book>(1, 10), null);
        // 设置 数据模型 并且跳转视图
        modelAndView.addObject("queryBooksVO",dtoListToVo(dtoList.getRecords()));
        modelAndView.setViewName("showBooks");
        return modelAndView;
    }

    @ApiOperation("初始化书籍")
    @GetMapping("/initBooks")
    public String initBooks(){
        HashMap<String, Object> map = new HashMap<>();
        IPage<BookDTO> dtoList = bookService.queryAllBook(new Page<BookDTO>(1, 10), null);
        map.put("status",0);
        map.put("count",dtoList.getTotal());
        map.put("data",dtoListToVo(dtoList.getRecords()));
        return JackSonUtil.toJson(map);
    }

    @ApiOperation("展示查询结果")
    @RequestMapping("/showBooksByQueryVO")
    public String showBooksByQueryVO(@RequestBody QueryBooksVO queryBooksVO, Model model) {
        // 回写数据
        model.addAttribute("queryBooksVO","!23");
        // 查询操作
        Map<String, Object> map = new HashMap<>();
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        // 拼接查询条件
        if (StringUtils.isEmptyOrWhitespaceOnly(queryBooksVO.getKeyword())) {
            queryWrapper.like("concat(book_name,book_author,book_introduction)", queryBooksVO.getKeyword());
        }
        if (queryBooksVO.getBookCategoryId() != null) {
            queryWrapper.eq("book_category_id", queryBooksVO.getBookCategoryId());
        }
        // 拼接降序升序条件
        addCondition(queryWrapper, queryBooksVO.isBookReadTime(), "book_read_time");
        addCondition(queryWrapper, queryBooksVO.isBookCollectionTime(), "book_collection_time");
        addCondition(queryWrapper, queryBooksVO.isBookModifiedTime(), "book_modified_time");
        addCondition(queryWrapper, queryBooksVO.isBookTotalWord(), "book_total_word");
        addCondition(queryWrapper, queryBooksVO.isBookCreateTime(), "book_create_time");
        // 查询数据库
        IPage<BookDTO> bookDTOs = bookService.queryAllBook(new Page<Book>(1, 10), queryWrapper);
        map.put("allBooks", dtoListToVo(bookDTOs.getRecords()));
        // 返回数据
        return JackSonUtil.toJson(map);
    }

    @RequestMapping("/showDetails/{id}")
    @ResponseBody
    public String showDetails(@PathVariable("id") Integer id){
        // 将数据返回给前端
        Map<String, Object> map = new HashMap<>();
        map.put("status",0);
        map.put("bookDetail",bookService.queryBookDetailById(id));
        return JackSonUtil.toJson(map);
    }

    /**
     * wrapper 中添加条件
     *
     * @param queryWrapper wrapper
     * @param condition    是否增加条件
     * @param column       增加条件的数据库字段
     */
    private void addCondition(QueryWrapper<Book> queryWrapper, boolean condition, String column) {
        if (condition) {
            queryWrapper.orderByAsc(column);
        } else {
            queryWrapper.orderByDesc(column);
        }
    }

    /**
     * 将 Book 对象集合转换成 VO 对象集合
     *
     * @param books 待转换的 Book 对象集合
     * @return VO 对象集合
     */
    private List<IndexBookVO> listToVo(List<Book> books) {
        ArrayList<IndexBookVO> indexBookVOS = new ArrayList<>();
        for (Book book : books) {
            indexBookVOS.add(new IndexBookVO(book));
        }
        return indexBookVOS;
    }

    /**
     * 将 Book 对象集合转换成 VO 对象集合
     *
     * @param bookDTOS 待转换的 Book 对象集合
     * @return VO 对象集合
     */
    private List<ShowBooksVO> dtoListToVo(List<BookDTO> bookDTOS) {
        ArrayList<ShowBooksVO> showBooksVOS = new ArrayList<>();
        for (BookDTO bookDTO : bookDTOS) {
            showBooksVOS.add(new ShowBooksVO(bookDTO));
        }
        return showBooksVOS;
    }

}

