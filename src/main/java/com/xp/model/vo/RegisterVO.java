package com.xp.model.vo;

import com.xp.model.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 注册 VO实体类
 * <p>
 * create by 2020-08-0
 *
 * @author xp
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("注册实体类")
public class RegisterVO {
    @ApiModelProperty("注册的用户账号")
    private String account;
    @ApiModelProperty("注册的用户名")
    private String userName;
    @ApiModelProperty("注册的用户密码")
    private String password;
    @ApiModelProperty("确认用户密码")
    private String surePassword;
    @ApiModelProperty("注册的邮箱号")
    private String email;
    @ApiModelProperty("注册的手机号")
    private String tel;

    public User toUser(){
        return new User().setAccount(account).setUserName(userName).setPassword(password).setEmail(email).setTel(tel);
    }

}
