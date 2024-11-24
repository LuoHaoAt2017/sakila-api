package com.imooc.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Blob;

@Data
@TableName("staff")
public class StaffEntity {

    @TableId
    private Integer staffId;

    private String firstName;

    private String lastName;

    private Integer addressId;

    private Blob picture;

    private String email;

    private Integer active;

    private Integer storeId;

    private String username;

    private String password;
}
