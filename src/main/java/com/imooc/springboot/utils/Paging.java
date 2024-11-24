package com.imooc.springboot.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;
import java.util.List;

@Data
public class Paging<T> {

    private int cur;
    private int total;
    private List<T> data;

    public Paging(IPage page) {
        this.cur = (int)page.getCurrent();
        this.total = (int)page.getTotal();
        this.data = page.getRecords();
    }
}
