package com.imooc.sakila.model.condition;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imooc.sakila.model.view.FilmVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FilmPage extends Page<FilmVo> {
    private Integer actorId;
}
