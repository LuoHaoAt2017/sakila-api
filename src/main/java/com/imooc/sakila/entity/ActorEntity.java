package com.imooc.sakila.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("actor")
public class ActorEntity {

    @TableId
    private Integer actorId;

    private String firstName;

    private String lastName;

    private Timestamp lastUpdate;
}
