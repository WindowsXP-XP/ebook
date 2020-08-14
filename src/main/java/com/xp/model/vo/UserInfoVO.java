package com.xp.model.vo;

import com.xp.model.dto.UserDTO;
import com.xp.model.entity.Permission;
import com.xp.model.entity.Role;
import com.xp.model.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息VO
 *
 * create by 2020-08-05
 * @author xp
 */
@Data
@Accessors(chain = true)
@ApiModel("用户登信息VO")
public class UserInfoVO {

    @ApiModelProperty("用户信息")
    private User user;

    @ApiModelProperty(value = "角色集合")
    private List<String> roles;

    @ApiModelProperty(value = "权限集合")
    private List<String> permissions;

    public UserInfoVO(UserDTO userDTO){
        this.user = userDTO.getUser();
        // 获取角色
        roles = new ArrayList<String>();
        List<Role> roleList = userDTO.getRole();
        for (Role role : roleList) {
            roles.add(role.getRoleName());
        }
        // 获取权限
        permissions = new ArrayList<String>();
        List<Permission> permissionList = userDTO.getPermission();
        for (Permission permission : permissionList) {
            permissions.add(permission.getPermissionCode());
        }
    }

}
