package com.xp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 通用 控制器
 *
 * create by 2020-08-06
 * @author xp
 */
@Controller
public class CommonController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/toShowBooks")
    public String toShowBooks(){
        return "showBooks";
    }

    @RequestMapping("/toShowBooksDetail")
    public String toShowBooksDetail(){
        return "showBooksDetail";
    }

    @RequestMapping("/toMain")
    public String toMain(){
        return "main";
    }

}
