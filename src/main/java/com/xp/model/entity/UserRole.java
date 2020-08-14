package com.xp.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户角色表
 * </p>
 *
 * @author xp
 * @since 2020-08-05
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("ebook_user_role")
@ApiModel(value="UserRole对象", description="用户角色表")
public class UserRole implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "user_role_id", type = IdType.AUTO)
    private Integer userRoleId;

    @ApiModelProperty(value = "用户id")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty(value = "角色id")
    @TableField("role_id")
    private Integer roleId;


}
