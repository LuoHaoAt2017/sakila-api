package com.imooc.springboot.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imooc.springboot.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imooc.springboot.model.condition.ProductCondition;
import com.imooc.springboot.model.view.ProductView;
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
public interface ProductMapper extends BaseMapper<Product> {
    // 关于如何正确地在 Mapper 接口和 XML 配置文件之间传递参数的问题。
    List<ProductView> queryList(Page<ProductView> page, ProductCondition condition);

    IPage<ProductView> queryPage(Page<ProductView> page, ProductCondition condition);
}
