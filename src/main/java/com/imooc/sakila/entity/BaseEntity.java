package com.imooc.sakila.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class BaseEntity implements Serializable {

    @TableId(type = IdType.ASSIGN_ID)
    protected Long id;

    /**
     * createUserRefid 创建者关联id
     */
    @TableField(fill = FieldFill.INSERT)
    protected Long currentUserId;

    /**
     * createDateTime 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    protected Date createDateTime;

    /**
     * modifyUserRefid 修改者关联id
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    protected Long modifyUserId;

    /**
     * modifyDateTime 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    protected Date modifyDatetime;

    /**
     * 标识是否已经被删除（true:删除，false:未删除）
     */
    @TableLogic
    protected Boolean deleted = Boolean.FALSE;
}
