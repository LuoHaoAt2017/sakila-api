package com.imooc.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class FileInfo {
    @TableId(value = "file_id", type = IdType.AUTO)
    private Integer fileId;

    private String fileName;

    private int fileSize;

    private int fileType;

    private String filePath;
}
