package com.xp.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 登录VO 实体类
 *
 * create by 2020-08-05
 * @author xp
 */
@Data
@Accessors(chain = true)
@ApiModel("登录VO类")
public class LoginVO {

    /**
     * 登录账号
     */
    @ApiModelProperty("登录账号")
    private String account;

    /**
     * 登录密码
     */
    @ApiModelProperty("登录密码")
    private String password;

}
