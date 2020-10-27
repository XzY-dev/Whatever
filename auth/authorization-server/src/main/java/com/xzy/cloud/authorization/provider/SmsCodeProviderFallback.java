package com.xzy.cloud.authorization.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author XZY
 * @version V1.0
 * @Package com.xzy.cloud.authorization.provider
 * @date 2020/10/25 14:59
 */
@Component
public class SmsCodeProviderFallback implements SmsCodeProvider {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public String getSmsCode(String mobile, String businessType) {
        return passwordEncoder.encode("123456");
    }
}
