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
 * 权限表
 * </p>
 *
 * @author xp
 * @since 2020-08-05
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("ebook_permission")
@ApiModel(value="Permission对象", description="权限表")
public class Permission implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "权限id")
    @TableId(value = "permission_id", type = IdType.AUTO)
    private Integer permissionId;

    @ApiModelProperty(value = "权限编码")
    @TableField("permission_code")
    private String permissionCode;

    @ApiModelProperty(value = "权限描述")
    @TableField("permission_description")
    private String permissionDescription;

    @ApiModelProperty(value = "权限状态，默认为0，为1时表示逻辑删除")
    @TableField("permission_is_deleted")
    @TableLogic
    private Integer permissionIsDeleted;

    @ApiModelProperty(value = "权限名")
    @TableField("permission_name")
    private String permissionName;

    @ApiModelProperty(value = "权限创建时间")
    @TableField(value = "permission_create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "权限修改时间")
    @TableField(value = "permission_modified_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifiedTime;


}
