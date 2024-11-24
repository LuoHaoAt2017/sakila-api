package com.imooc.springboot.model.access;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddAccess {

    @NotNull(message = "accessName required")
    private String accessName;

    @NotNull(message = "accessCode required")
    private String accessCode;

    @NotNull(message = "accessUrl required")
    private String accessUrl;

    private int parentId;
}
