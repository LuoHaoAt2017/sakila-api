package com.imooc.sakila.controller;

import com.imooc.sakila.entity.FilmEntity;
import com.imooc.sakila.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/film")
public class FilmController {

    @Autowired
    FilmService filmService;

    @GetMapping(value = "/page")
    public List<FilmEntity> filmPage() {
        return filmService.list().subList(0,10);
    }
}
