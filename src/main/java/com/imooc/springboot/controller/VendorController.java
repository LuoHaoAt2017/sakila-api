package com.imooc.springboot.controller;


import com.imooc.springboot.model.condition.VendorCondition;
import com.imooc.springboot.model.view.VendorView;
import com.imooc.springboot.service.VendorService;
import com.imooc.springboot.utils.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Luo Hao
 * @since 2024-07-08
 */
@RestController
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    VendorService vendorService;

    @PostMapping("/page")
    Paging<VendorView> getVendorByPage(@RequestBody VendorCondition condition) {
        return vendorService.getVendorPage(condition);
    }

    @PostMapping("/list")
    List<VendorView> getVendorByList(@RequestBody VendorCondition condition) {
        return vendorService.getVendorList(condition);
    }
}

