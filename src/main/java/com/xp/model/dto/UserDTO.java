package com.xp.model.dto;

import com.xp.model.entity.Permission;
import com.xp.model.entity.Role;
import com.xp.model.entity.User;
import com.xp.model.vo.SessionVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 用户DTO
 *
 * create by 2020-08-05
 * @author xp
 */
@Data
@Accessors(chain = true)
@ApiModel("用户 DTO")
public class UserDTO {

    @ApiModelProperty("用户信息")
    private User user;

    @ApiModelProperty("用户角色")
    private List<Role> role;

    @ApiModelProperty("用户权限")
    private List<Permission> permission;

    public SessionVO toSessionVO(){
        return new SessionVO().setUserId(user.getUserId()).setUserName(user.getUserName());
    }
}
