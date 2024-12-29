package com.imooc.sakila.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc.sakila.mapper.ActorMapper;
import com.imooc.sakila.mapper.FimlMapper;
import com.imooc.sakila.model.condition.ActorPage;
import com.imooc.sakila.model.condition.FilmPage;
import com.imooc.sakila.model.view.ActorVo;
import com.imooc.sakila.model.view.FilmVo;
import com.imooc.sakila.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImp extends ServiceImpl<ActorMapper, ActorVo> implements ActorService {
    @Autowired
    ActorMapper actorMapper;

    @Autowired
    FimlMapper fimlMapper;

    private List<FilmVo> getFilmList(Integer actorId) {
        FilmPage page = new FilmPage();
        page.setCurrent(1);
        page.setSize(-1);
        Page<FilmVo> result = fimlMapper.queryFilmList(page, actorId);
        return result.getRecords();
    }

    public Page<ActorVo> getActorByPage(ActorPage page) {
        Page<ActorVo> result = this.actorMapper.queryActorList(page);
        List<ActorVo> actors = result.getRecords();
        actors.forEach(actor -> {
            List<FilmVo> films = this.getFilmList(actor.getActorId());
            actor.setFilms(films);
        });
        return result;
    }
}
