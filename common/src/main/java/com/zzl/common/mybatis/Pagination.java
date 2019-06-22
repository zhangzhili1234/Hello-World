package com.zzl.common.mybatis;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc: 自定义分页对象
 * @Author: john（coder_john@163.com）
 * @Date: 2019-06-22
 */
@Slf4j
public class Pagination<T> extends Page<T> {

    private static final long serialVersionUID = 1046648205712560262L;

    public Pagination(Integer current, Integer size) {
        super(current, size);
        log.info("Pagination instance establish...current:{}, size:{}", this.getCurrent(), this.getSize());
    }

    public static Map<String, Object> getResultMap(IPage page){
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("total", page.getTotal());
        resultMap.put("pages", page.getPages());
        resultMap.put("current", page.getCurrent());
        resultMap.put("size", page.getSize());
        resultMap.put("records", page.getRecords());
        return resultMap;
    }
}
