package com.imooc.springboot.controller;

import com.imooc.springboot.entity.StaffEntity;
import com.imooc.springboot.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping("list")
    public List<StaffEntity> getStaffList() {
        return staffService.list();
    }
}
