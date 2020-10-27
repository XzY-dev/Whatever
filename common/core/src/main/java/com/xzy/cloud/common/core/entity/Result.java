package com.xzy.cloud.common.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.xzy.cloud.common.core.exception.BaseException;
import com.xzy.cloud.common.core.exception.ErrorType;
import com.xzy.cloud.common.core.exception.SystemErrorType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.time.Instant;
import java.time.ZonedDateTime;

/**
 * @author XZY
 * @version V1.0
 * @Package com.springboot.cloud.common.core.entity
 * @date 2020/10/21 22:34
 */
@ApiModel(description = "rest请求的返回模型，所有rest正常都返回该类的对象")
@Getter
public class Result<T> {

    public static final String SUCCESSFUL_CODE = "000000";
    public static final String SUCCESSFUL_MESG = "处理成功";

    @ApiModelProperty(value = "处理结果code", required = true)
    private String code;
    @ApiModelProperty(value = "处理结果描述信息")
    private String mesg;
    @ApiModelProperty(value = "请求结果生成时间戳")
    private Instant time;
    @ApiModelProperty(value = "处理结果数据信息")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public Result() {
        this.time = ZonedDateTime.now().toInstant();
    }

    /**
     * @Author XZY
     * @Description
     * @Param [errorType]
    **/
    public Result(ErrorType errorType) {
        this.code = errorType.getCode();
        this.mesg = errorType.getMessage();
        this.time = ZonedDateTime.now().toInstant();
    }

    /**
     * @Author XZY
     * @Description
     * @Param [errorType, data]
    **/
    public Result(ErrorType errorType, T data) {
        this(errorType);
        this.data = data;
    }

    /**
     * @Author XZY
     * @Description 内部使用，用于构造成功的结果
     * @Param [code, mesg, data]
    **/
    private Result(String code, String mesg, T data) {
        this.code = code;
        this.mesg = mesg;
        this.data = data;
        this.time = ZonedDateTime.now().toInstant();
    }

    /**
     * @Author XZY
     * @Description 快速创建成功结果并返回结果数据
     * @Param [data]
     * @return com.xzy.cloud.common.core.entity.Result
    **/
    public static Result success(Object data) {
        return new Result<>(SUCCESSFUL_CODE, SUCCESSFUL_MESG, data);
    }

    /**
     * 快速创建成功结果
     *
     * @return Result
     */
    public static Result success() {
        return success(null);
    }

    /**
     * @Author XZY
     * @Description 系统异常类无返回数据
     * @Param []
     * @return com.xzy.cloud.common.core.entity.Result
    **/
    public static Result fail() {
        return new Result(SystemErrorType.SYSTEM_ERROR);
    }

    /**
     * @Author XZY
     * @Description 系统异常类无返回数据
     * @Param [baseException]
     * @return com.xzy.cloud.common.core.entity.Result
    **/
    public static Result fail(BaseException baseException) {
        return fail(baseException, null);
    }

   /**
    * @Author XZY
    * @Description 系统异常类并返回结果数据
    * @Param [baseException, data]
    * @return com.xzy.cloud.common.core.entity.Result
   **/
    public static Result fail(BaseException baseException, Object data) {
        return new Result<>(baseException.getErrorType(), data);
    }

    /**
     * @Author XZY
     * @Description 系统异常类并返回结果数据
     * @Param [errorType, data]
     * @return com.xzy.cloud.common.core.entity.Result
    **/
    public static Result fail(ErrorType errorType, Object data) {
        return new Result<>(errorType, data);
    }

    /**
     * @Author XZY
     * @Description 系统异常类并返回结果数据
     * @Param [errorType]
     * @return com.xzy.cloud.common.core.entity.Result
    **/
    public static Result fail(ErrorType errorType) {
        return Result.fail(errorType, null);
    }

   /**
    * @Author XZY
    * @Description 系统异常类并返回结果数据
    * @Param [data]
    * @return com.xzy.cloud.common.core.entity.Result
   **/
    public static Result fail(Object data) {
        return new Result<>(SystemErrorType.SYSTEM_ERROR, data);
    }


    /**
     * 成功code=000000
     *
     * @return true/false
     */
    @JsonIgnore
    public boolean isSuccess() {
        return SUCCESSFUL_CODE.equals(this.code);
    }

    /**
     * 失败
     *
     * @return true/false
     */
    @JsonIgnore
    public boolean isFail() {
        return !isSuccess();
    }
}
