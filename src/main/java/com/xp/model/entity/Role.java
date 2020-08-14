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
 * 角色表
 * </p>
 *
 * @author xp
 * @since 2020-08-05
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("ebook_role")
@ApiModel(value="Role对象", description="角色表")
public class Role implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "角色id")
    @TableId(value = "role_id", type = IdType.AUTO)
    private Integer roleId;

    @ApiModelProperty(value = "角色名")
    @TableField("role_name")
    private String roleName;

    @ApiModelProperty(value = "角色描述")
    @TableField("role_description")
    private String roleDescription;

    @ApiModelProperty(value = "角色是否删除状态，默认为0，1代表已逻辑删除")
    @TableField("role_is_deleted")
    @TableLogic
    private Integer roleIsDeleted;

    @ApiModelProperty(value = "角色创建时间")
    @TableField(value = "role_create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "角色修改时间")
    @TableField(value = "role_modified_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifiedTime;


}
