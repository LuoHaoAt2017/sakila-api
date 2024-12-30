package com.imooc.sakila.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc.sakila.entity.FilmEntity;
import com.imooc.sakila.mapper.FilmMapper;
import com.imooc.sakila.service.FilmService;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImp extends ServiceImpl<FilmMapper, FilmEntity> implements FilmService {
}
