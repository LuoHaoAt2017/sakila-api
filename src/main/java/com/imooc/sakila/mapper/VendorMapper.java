package com.imooc.springboot.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imooc.springboot.entity.Vendor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imooc.springboot.model.condition.ProductCondition;
import com.imooc.springboot.model.condition.VendorCondition;
import com.imooc.springboot.model.view.ProductView;
import com.imooc.springboot.model.view.VendorView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Luo Hao
 * @since 2024-07-08
 */
@Mapper
@Repository
public interface VendorMapper extends BaseMapper<Vendor> {
    IPage<VendorView> queryPage(Page<VendorView> page, VendorCondition condition);

    // 为了避免混淆和确保兼容性，最佳实践是在Mapper接口的方法参数上使用 @Param 注解来明确参数名称。
    // 不要固执地追求回字的四种写法
    List<VendorView> queryList(@Param("condition") VendorCondition condition);
}
