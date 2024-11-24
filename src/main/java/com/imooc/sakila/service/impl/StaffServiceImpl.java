package com.imooc.sakila.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc.sakila.entity.StaffEntity;
import com.imooc.sakila.mapper.StaffMapper;
import com.imooc.sakila.service.StaffService;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, StaffEntity> implements StaffService {
}
