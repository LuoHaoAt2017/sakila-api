package com.imooc.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imooc.springboot.entity.FileInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FileMapper extends BaseMapper<FileInfo> {
}
