package com.imooc.sakila.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imooc.sakila.model.view.ActorVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ActorMapper extends BaseMapper<ActorVo> {
    Page<ActorVo> queryActorList(Page<ActorVo> params);
}
