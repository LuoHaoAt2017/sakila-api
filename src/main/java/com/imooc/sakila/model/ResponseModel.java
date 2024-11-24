package com.imooc.sakila.model;

import com.imooc.sakila.enums.ResponseCodeEnum;
import lombok.Data;

/**
 *  @Data 提供的注解，它可以自动为类生成常用的方法，包括 getter、setter、equals、hashCode 和 toString 等。使用 @Data 注解可以简化代码，使代码更加简洁易读。
 */
@Data
public class ResponseModel<T> {
    private String code;
    private String msgCode;
    private T data;

    public ResponseModel(){
    }

    public ResponseModel(T data){
        this.code = ResponseCodeEnum.SUCCESS.getCode();
        this.msgCode = ResponseCodeEnum.SUCCESS.getDescription();
        this.data = data;
    }

    public ResponseModel(ResponseCodeEnum responseCodeEnum){
        this.code = responseCodeEnum.getCode();
        this.msgCode = responseCodeEnum.getDescription();
    }

    public ResponseModel(ResponseCodeEnum responseCodeEnum, T data) {
        this.code = responseCodeEnum.getCode();
        this.msgCode = responseCodeEnum.getDescription();
        this.data = data;
    }

    public static ResponseModel<String> failed() {
        return new ResponseModel<>(ResponseCodeEnum.FAILED);
    }

    public static ResponseModel<String> success() {
        return new ResponseModel<>(ResponseCodeEnum.SUCCESS);
    }
}
