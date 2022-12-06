package com.breze.common.exception;

import com.breze.common.enums.ErrorEnum;
import lombok.Data;

/**
 * @Author tylt6688
 * @Date 2022/11/2 16:40
 * @Description 业务异常处理机制
 * @Copyright(c) 2022 , 青枫网络工作室
 */
@Data
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 6222543820599495474L;
    private ErrorEnum errorEnum;

    private String message;

    public BusinessException(ErrorEnum errorEnum) {
        this.errorEnum = errorEnum;
        this.message = errorEnum.getErrorName();
    }


    public BusinessException(ErrorEnum errorEnum, String message) {
        this.errorEnum = errorEnum;
        this.message = message;
    }


}
