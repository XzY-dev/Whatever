package com.xzy.cloud.authorization.service;

import com.xzy.cloud.authorization.entity.Role;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author XZY
 * @version V1.0
 * @Package com.xzy.cloud.authorization.service
 * @date 2020/10/25 15:24
 */
@Service
public interface IRoleService {
    Set<Role> queryUserRolesByUserId(String userId);
}
