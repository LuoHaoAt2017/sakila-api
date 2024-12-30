package com.imooc.sakila.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imooc.sakila.model.view.FilmVo;
import org.apache.ibatis.annotations.Param;

public interface FimlMapper extends BaseMapper<FilmVo> {
    Page<FilmVo> queryFilmList(Page<FilmVo> params, @Param("actorId") Integer actorId);
}
