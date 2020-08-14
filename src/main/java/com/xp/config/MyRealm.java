package com.xp.config;

import com.xp.model.dto.UserDTO;
import com.xp.model.vo.UserInfoVO;
import com.xp.service.UserService;
import io.swagger.annotations.ApiModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义 Realm
 *
 * create by 2020-08-05
 * @author xp
 */
@ApiModel("自定义 Realm")
@Slf4j
public class MyRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("===============>执行了授权");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        UserDTO userDTO = (UserDTO) subject.getPrincipal();
        UserInfoVO loginInfoVO = new UserInfoVO(userDTO);

        // 设置 session
        Session session = subject.getSession();
        session.setAttribute("user",loginInfoVO);

        // 添加角色和权限
        info.addRoles(loginInfoVO.getRoles());
        info.addStringPermissions(loginInfoVO.getPermissions());

        return info;
    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.info("===============>执行了认证");

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        // 查询数据库
        UserDTO userDTO = userService.queryUserByUserAccount(usernamePasswordToken.getUsername());

        // 如果用户不存在，抛出异常
        if (userDTO == null){
            return null;
        }

        return new SimpleAuthenticationInfo(userDTO,userDTO.getUser().getPassword(),"");
    }
}
