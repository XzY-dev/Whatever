package com.xzy.cloud.authorization.provider;

import com.xzy.cloud.authorization.entity.Role;
import com.xzy.cloud.authorization.entity.User;
import com.xzy.cloud.common.core.entity.Result;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author XZY
 * @version V1.0
 * @Package com.xzy.cloud.authorization.provider
 * @date 2020/10/25 15:20
 */
@Component
public class OrganizationProviderFallback implements OrganizationProvider {
    @Override
    public Result<User> getUserByUniqueId(String uniqueId) {
        return Result.success(new User());
    }

    @Override
    public Result<Set<Role>> queryRolesByUserId(String userId) {
        return Result.success(new HashSet<Role>());
    }
}
