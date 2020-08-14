package com.xp.model.vo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 展示用户信息 VO
 *
 * create by 2020-08-13
 * @author xp
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ShowUsersVO {

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "用户名字")
    private String userName;

    @ApiModelProperty(value = "用户登录账号")
    private String account;

    @ApiModelProperty(value = "用户登录密码")
    private String password;

    @ApiModelProperty(value = "用户年龄")
    private Integer age;

    @ApiModelProperty(value = "用户性别")
    private Integer sex;

    @ApiModelProperty(value = "用户住址")
    private String address;

    @ApiModelProperty(value = "用户电子邮件")
    private String email;

    @ApiModelProperty(value = "用户手机号")
    private String tel;

    @ApiModelProperty(value = "用户个人介绍")
    private String userIntroduction;

    @ApiModelProperty(value = "用户状态，1为逻辑删除")
    @TableField("user_is_deleted")
    @TableLogic
    private Integer userIsDeleted;

    @ApiModelProperty(value = "用户创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "用户信息写修改时间")
    private LocalDateTime modifiedTime;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "盐值")
    private String salt;

    @ApiModelProperty(value = "最后一次登录时间")
    private LocalDateTime lastLoginTime;


}
