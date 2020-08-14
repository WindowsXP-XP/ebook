package com.xp.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author xp
 * @since 2020-08-05
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("ebook_user")
@ApiModel(value="User对象", description="用户表")
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户id")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @ApiModelProperty(value = "用户名字")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty(value = "用户登录账号")
    @TableField("account")
    private String account;

    @ApiModelProperty(value = "用户登录密码")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "用户年龄")
    @TableField("age")
    private Integer age;

    @ApiModelProperty(value = "用户性别")
    @TableField("sex")
    private Integer sex;

    @ApiModelProperty(value = "用户住址")
    @TableField("address")
    private String address;

    @ApiModelProperty(value = "用户电子邮件")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "用户手机号")
    @TableField("tel")
    private String tel;

    @ApiModelProperty(value = "用户个人介绍")
    @TableField("user_introduction")
    private String userIntroduction;

    @ApiModelProperty(value = "用户状态，1为逻辑删除")
    @TableField("user_is_deleted")
    @TableLogic
    private Integer userIsDeleted;

    @ApiModelProperty(value = "用户创建时间")
    @TableField(value = "user_create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "用户信息写修改时间")
    @TableField(value = "user_modified_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifiedTime;

    @ApiModelProperty(value = "头像")
    @TableField("avatar")
    private String avatar;

    @ApiModelProperty(value = "盐值")
    @TableField("salt")
    private String salt;

    @ApiModelProperty(value = "最后一次登录时间")
    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;


}
