package com.imooc.sakila.model.view;

import lombok.Data;

import java.util.List;

@Data
public class ActorVo {
    private Integer actorId;

    private String actorName;

    private List<FilmVo> films;
}
