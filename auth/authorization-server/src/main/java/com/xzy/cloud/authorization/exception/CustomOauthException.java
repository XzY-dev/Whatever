package com.xzy.cloud.authorization.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xzy.cloud.common.core.entity.Result;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @author XZY
 * @version V1.0
 * @Package com.xzy.cloud.authorization.exception
 * @date 2020/10/27 21:48
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonSerialize(using = CustomOauthExceptionSerializer.class)
public class CustomOauthException extends OAuth2Exception {

    private final Result result;
    CustomOauthException(OAuth2Exception oAuth2Exception) {
        super(oAuth2Exception.getSummary(), oAuth2Exception);
        this.result = Result.fail(AuthErrorType.valueOf(oAuth2Exception.getOAuth2ErrorCode().toUpperCase()), oAuth2Exception);
    }
}
