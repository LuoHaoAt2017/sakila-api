package com.imooc.sakila.model;

import com.imooc.sakila.enums.ResCode;
import lombok.Data;

/**
 *  @Data 提供的注解，它可以自动为类生成常用的方法，包括 getter、setter、equals、hashCode 和 toString 等。使用 @Data 注解可以简化代码，使代码更加简洁易读。
 */
@Data
public class RespModel<T> {
    private String code;
    private String msgCode;
    private T data;

    public RespModel(){
    }

    public RespModel(T data){
        this.code = ResCode.SUCCESS.getCode();
        this.msgCode = ResCode.SUCCESS.getDescription();
        this.data = data;
    }

    public RespModel(ResCode responseCodeEnum){
        this.code = responseCodeEnum.getCode();
        this.msgCode = responseCodeEnum.getDescription();
    }

    public RespModel(ResCode responseCodeEnum, T data) {
        this.code = responseCodeEnum.getCode();
        this.msgCode = responseCodeEnum.getDescription();
        this.data = data;
    }

    public static RespModel<String> failed() {
        return new RespModel<>(ResCode.FAILED);
    }

    public static RespModel<String> success() {
        return new RespModel<>(ResCode.SUCCESS);
    }
}
