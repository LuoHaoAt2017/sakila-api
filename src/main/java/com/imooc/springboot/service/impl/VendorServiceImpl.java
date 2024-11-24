package com.imooc.springboot.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imooc.springboot.entity.Vendor;
import com.imooc.springboot.mapper.VendorMapper;
import com.imooc.springboot.model.condition.VendorCondition;
import com.imooc.springboot.model.view.ProductView;
import com.imooc.springboot.model.view.VendorView;
import com.imooc.springboot.service.VendorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc.springboot.utils.PageUtils;
import com.imooc.springboot.utils.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Luo Hao
 * @since 2024-07-08
 */
@Service
public class VendorServiceImpl extends ServiceImpl<VendorMapper, Vendor> implements VendorService {

    @Autowired
    VendorMapper vendorMapper;

    @Override
    public Paging<VendorView> getVendorPage(VendorCondition condition) {
        Page<VendorView> page = PageUtils.getPage(condition);
        IPage<VendorView> vendorPage =  vendorMapper.queryPage(page, condition);
        return new Paging<>(vendorPage);
    }

    @Override
    public List<VendorView> getVendorList(VendorCondition condition) {
        return vendorMapper.queryList(condition);
    }
}
