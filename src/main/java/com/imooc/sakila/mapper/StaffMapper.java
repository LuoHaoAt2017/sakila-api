package com.imooc.sakila.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imooc.sakila.entity.StaffEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StaffMapper extends BaseMapper<StaffEntity> {
}
