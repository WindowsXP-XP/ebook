package com.xp.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xp.model.dto.UserDTO;
import com.xp.model.entity.User;
import com.xp.model.vo.LoginVO;
import com.xp.model.vo.RegisterVO;
import com.xp.service.UserService;
import com.xp.util.CheckUtil;
import com.xp.util.JackSonUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author xp
 * @since 2020-08-05
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 跳转到登录页
     */
    @RequestMapping("/toLogin")
    public ModelAndView toLogin(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    /**
     * 登录
     */
    @RequestMapping("/login")
    public String login(@RequestBody LoginVO loginVO, HttpSession httpSession){
        // 将用户登录的账号密码封装进 token 中
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginVO.getAccount(),loginVO.getPassword());

        HashMap<String, String> loginMsgMap = new HashMap<>();
        // 将登录验证交给 Shiro 做
        try {
            subject.login(token);
        } catch (AuthenticationException e){
            loginMsgMap.put("loginMsg","账号或密码错误");
            return JackSonUtil.toJson(loginMsgMap);
        }

        // 将session 传给前端
        UserDTO userDTO = (UserDTO) SecurityUtils.getSubject().getPrincipal();
        System.out.println(userDTO);
        httpSession.setAttribute("user",userDTO.toSessionVO());

        loginMsgMap.put("loginMsg","登录成功");
        return JackSonUtil.toJson(loginMsgMap);
    }

    @RequestMapping("/register")
    public String register(@RequestBody RegisterVO registerVO){
        HashMap<String, Object> registerMap = new HashMap<>();
        // 对前端传来的参数进行校验
        String msg = CheckUtil.checkRegisterVO(registerVO);
        if (!CheckUtil.isEmpty(msg)){
            registerMap.put("registerMsg",msg);
            return JackSonUtil.toJson(registerMap);
        }
        // 判断登录账号是否已经存在
        if (userService.queryUserByUserAccount(registerVO.getAccount()) != null){
            registerMap.put("registerMsg","账号已存在");
            return JackSonUtil.toJson(registerMap);
        }
        // 注册
        boolean flag = userService.registerUser(registerVO.toUser());
        if (flag){
            registerMap.put("registerMsg","注册成功");
        }else {
            registerMap.put("registerMsg","注册失败");
        }
        return JackSonUtil.toJson(registerMap);
    }

    @RequestMapping("/showUsers")
    public String showUsers (){
        Map<String, Object> map = new HashMap<>();
        map.put("status",1);

        // 查询数据库
        Page<User> page = userService.page(new Page<User>(1, 10));
        List<User> records = page.getRecords();

        return JackSonUtil.toJson(map);
    }

}

