package com.xzy.cloud.authorization.service.impl;

import com.xzy.cloud.authorization.entity.Role;
import com.xzy.cloud.authorization.provider.OrganizationProvider;
import com.xzy.cloud.authorization.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author XZY
 * @version V1.0
 * @Package com.xzy.cloud.authorization.service.impl
 * @date 2020/10/25 15:27
 */
@Service
public class RoleService implements IRoleService {

    @Autowired
    private OrganizationProvider organizationProvider;
    @Override
    public Set<Role> queryUserRolesByUserId(String userId) {
        return organizationProvider.queryRolesByUserId(userId).getData();
    }
}
