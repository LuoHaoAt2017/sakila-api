package com.imooc.springboot.service;

import com.imooc.springboot.entity.Vendor;
import com.baomidou.mybatisplus.extension.service.IService;
import com.imooc.springboot.model.condition.VendorCondition;
import com.imooc.springboot.model.view.VendorView;
import com.imooc.springboot.utils.Paging;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Luo Hao
 * @since 2024-07-08
 */
public interface VendorService extends IService<Vendor> {
    Paging<VendorView> getVendorPage(VendorCondition condition);

    List<VendorView> getVendorList(VendorCondition condition);
}
