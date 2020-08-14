package com.xp.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Shiro 配置类
 * <p>
 * create by 2020-08-05
 *
 * @author xp
 */
@Configuration
public class ShiroConfig {

    @Bean
    ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();

        filterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> filterChainMap = new HashMap<>();
        filterChainMap.put("user/admin","perms[user:admin]");

        filterFactoryBean.setFilterChainDefinitionMap(filterChainMap);

        return filterFactoryBean;
    }

    @Bean(name = "securityManager")
    DefaultWebSecurityManager securityManager(@Qualifier("myRealm") MyRealm myRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm());
        return securityManager;
    }

    @Bean
    MyRealm myRealm() {
        return new MyRealm();
    }

    /**
     * 整合 Thymeleaf，设置方言为 shiro
     */
    @Bean
    ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }

}
