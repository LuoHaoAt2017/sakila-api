package com.imooc.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc.springboot.entity.StaffEntity;
import com.imooc.springboot.mapper.StaffMapper;
import com.imooc.springboot.service.StaffService;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, StaffEntity> implements StaffService {
}
