package com.imooc.sakila.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.imooc.sakila.model.condition.ActorPage;
import com.imooc.sakila.model.view.ActorVo;

public interface ActorService extends IService<ActorVo> {
    Page<ActorVo> getActorByPage(ActorPage page);
}
