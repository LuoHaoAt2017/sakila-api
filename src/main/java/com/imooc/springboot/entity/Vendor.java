package com.imooc.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Luo Hao
 * @since 2024-07-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Vendor implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "vend_id", type = IdType.AUTO)
    private Integer vendId;

    private String vendName;

    private String vendAddress;

    private String vendCity;

    private String vendState;

    private String vendZip;

    private String vendCountry;

    private Integer deleted;
}
