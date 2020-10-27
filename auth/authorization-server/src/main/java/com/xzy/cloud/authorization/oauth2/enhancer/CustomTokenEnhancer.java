package com.xzy.cloud.authorization.oauth2.enhancer;

import com.google.common.collect.Maps;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.Map;

/**
 * @author XZY
 * @version V1.0
 * @Package com.xzy.cloud.authorization.oauth2.enhancer
 * @date 2020/10/22 22:57
 */
public class CustomTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        Map<String, Object> customInfo = Maps.newHashMap();
        customInfo.put("organization", oAuth2Authentication.getName());
        ((DefaultOAuth2AccessToken)oAuth2AccessToken).setAdditionalInformation(customInfo);
        return oAuth2AccessToken;
    }
}
