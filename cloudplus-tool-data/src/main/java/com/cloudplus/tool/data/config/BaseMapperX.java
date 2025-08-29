package com.cloudplus.tool.data.config;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloudplus.tool.core.constant.PageRequest;
import com.cloudplus.tool.core.utils.StringUtils;

/**
 * 基础Mapper接口
 */
public interface BaseMapperX<T> extends BaseMapper<T> {
    // 可以在这里扩展通用Mapper方法
    default Page<T> selectPage(PageRequest pageRequest, Wrapper<T> queryWrapper) {
        Page<T> page = new Page<>(pageRequest.getPageNum(), pageRequest.getPageSize());
        if (StringUtils.isNotBlank(pageRequest.getOrderBy())) {
            page.addOrder(pageRequest.getAsc() ?
                    OrderItem.asc(pageRequest.getOrderBy()) :
                    OrderItem.desc(pageRequest.getOrderBy()));
        }
        return selectPage(page, queryWrapper);
    }
}
