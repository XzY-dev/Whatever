package com.xzy.cloud.authorization.service;

import com.xzy.cloud.authorization.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author XZY
 * @version V1.0
 * @Package com.xzy.cloud.authorization.service
 * @date 2020/10/25 15:25
 */
@Service
public interface IUserService {
    @Cacheable(value = "#id")
    User getByUniqueId(String uniqueId);
}
