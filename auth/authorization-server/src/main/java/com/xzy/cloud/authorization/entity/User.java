package com.xzy.cloud.authorization.entity;

import com.xzy.cloud.common.web.entity.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author XZY
 * @version V1.0
 * @Package com.xzy.cloud.authorization.entity
 * @date 2020/10/25 15:11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class User extends BasePo {
    private String name;
    private String mobile;
    private String username;
    private String password;
    private Boolean enabled;
    private Boolean accountNonExpired;
    private Boolean credentialsNonExpired;
    private Boolean accountNonLocked;
}
