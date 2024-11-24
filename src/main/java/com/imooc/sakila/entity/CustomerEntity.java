package com.imooc.sakila.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;

@Data
@TableName("cutomer")
public class CustomerEntity {
    @TableId
    private Integer customerId;

    private String firstName;

    private String lastName;

    private Integer addressId;

    private String email;

    private Integer active;

    private Integer storeId;

    private Date createDate;

    private Date lastUpdate;
}
