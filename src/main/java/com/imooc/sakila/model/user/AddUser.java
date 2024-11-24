package com.imooc.springboot.model.user;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddUser {

    @NotNull(message = "用户名不为空")
    public String userName;
}
