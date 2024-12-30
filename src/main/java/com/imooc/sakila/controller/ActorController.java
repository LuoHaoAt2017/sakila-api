package com.imooc.sakila.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imooc.sakila.model.condition.ActorPage;
import com.imooc.sakila.model.view.ActorVo;
import com.imooc.sakila.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "actor")
public class ActorController {

    @Autowired
    ActorService actorService;

    @GetMapping(value = "page")
    Page<ActorVo> getActorByPage(@RequestBody ActorPage params) {
        return actorService.getActorByPage(params);
    }

    @GetMapping(value = "list")
    List<ActorVo> getActorList(@RequestBody ActorPage params) {
        return actorService.getActorByPage(params).getRecords();
    }
}
