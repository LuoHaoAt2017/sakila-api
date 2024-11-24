package com.imooc.springboot.utils;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imooc.springboot.model.PageParam;
import org.apache.commons.lang3.StringUtils;

public class PageUtils {
    public static <T> Page<T> getPage(PageParam pageParam) {
        return getPage(pageParam, null);
    }

    public static <T> Page<T> getPage(PageParam pageParam, String defaultOrderColumn) {
        return getPage(pageParam, defaultOrderColumn, false);
    }

    public static <T> Page<T> getPage(PageParam pageParam, String defaultOrderColumn, boolean defaultAsc) {
        if(pageParam.getPageNum() == 0) {
            pageParam.setPageNum(1);
        }
        if (pageParam.getPageSize() == 0) {
            pageParam.setPageSize(10);
        }
        Page<T> page = new Page<>(pageParam.getPageNum(), pageParam.getPageSize(), true);
        OrderItem orderItem = new OrderItem();
        if (StringUtils.isNotBlank(pageParam.getAsc())) {
            orderItem.setAsc(true);
            orderItem.setColumn(com.baomidou.mybatisplus.core.toolkit.StringUtils.camelToUnderline(pageParam.getAsc()));
        } else if (StringUtils.isNotBlank(pageParam.getDesc())) {
            orderItem.setAsc(false);
            orderItem.setColumn(com.baomidou.mybatisplus.core.toolkit.StringUtils.camelToUnderline(pageParam.getDesc()));
        } else if (StringUtils.isNotBlank(defaultOrderColumn)) {
            orderItem.setAsc(defaultAsc);
            orderItem.setColumn(com.baomidou.mybatisplus.core.toolkit.StringUtils.camelToUnderline(defaultOrderColumn));
        } else {
            orderItem.setAsc(defaultAsc);
            orderItem.setColumn(com.baomidou.mybatisplus.core.toolkit.StringUtils.camelToUnderline("created_at"));
        }
        page.addOrder(orderItem);
        return page;
    }
}
