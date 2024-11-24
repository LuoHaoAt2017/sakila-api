package com.imooc.springboot.model.file;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddFile {

    @NotNull(message = "fileName required")
    private String fileName;

    @NotNull(message = "fileSize required")
    private Integer fileSize;

    @NotNull(message = "extension required")
    private String extension;
}
