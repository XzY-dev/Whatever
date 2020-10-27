package com.xzy.cloud.common.core.exception;

/**
 * @author XZY
 * @version V1.0
 * @Package com.springboot.cloud.common.core.exception
 * @date 2020/10/21 22:36
 */
public interface ErrorType {
    /**
     * 返回code
     *
     * @return
     */
    String getCode();

    /**
     * 返回mesg
     *
     * @return
     */
    String getMessage();
}
