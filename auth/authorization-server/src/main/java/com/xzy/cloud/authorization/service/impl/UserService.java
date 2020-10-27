package com.xzy.cloud.authorization.service.impl;

import com.xzy.cloud.authorization.entity.User;
import com.xzy.cloud.authorization.provider.OrganizationProvider;
import com.xzy.cloud.authorization.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XZY
 * @version V1.0
 * @Package com.xzy.cloud.authorization.service.impl
 * @date 2020/10/25 15:59
 */
@Service
public class UserService implements IUserService {
    @Autowired
    private OrganizationProvider organizationProvider;
    @Override
    public User getByUniqueId(String uniqueId) {
        return organizationProvider.getUserByUniqueId(uniqueId).getData();
    }
}
