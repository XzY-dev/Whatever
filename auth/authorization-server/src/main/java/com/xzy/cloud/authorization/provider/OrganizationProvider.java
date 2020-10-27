package com.xzy.cloud.authorization.provider;

import com.xzy.cloud.authorization.entity.Role;
import com.xzy.cloud.authorization.entity.User;
import com.xzy.cloud.common.core.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

/**
 * @author XZY
 * @version V1.0
 * @Package com.xzy.cloud.authorization.provider
 * @date 2020/10/25 15:08
 */
@Service
//@FeignClient(name = "organization", fallback = OrganizationProviderFallback.class)
public interface OrganizationProvider {

    @GetMapping(value = "/user")
    Result<User> getUserByUniqueId(@RequestParam("uniqueId")String uniqueId);
    @GetMapping(value = "/role/user/{userId}")
    Result<Set<Role>> queryRolesByUserId(@PathVariable("userId")String userId);
}
