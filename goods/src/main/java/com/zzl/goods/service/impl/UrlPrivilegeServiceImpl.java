package com.zzl.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzl.goods.entity.dto.UrlPrivilegeDTO;
import com.zzl.goods.entity.form.PrivilegeUrlForm;
import com.zzl.goods.mapper.UrlPrivilegeMapper;
import com.zzl.goods.service.UrlPrivilegeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Desc: TODO
 * @Author: john（coder_john@163.com）
 * @Date: 2019-06-20
 */
@Service
public class UrlPrivilegeServiceImpl implements UrlPrivilegeService {

    @Resource
    private UrlPrivilegeMapper urlPrivilegeMapper;

    @Override
    public PrivilegeUrlForm queryByUrl(String url) {
        QueryWrapper<UrlPrivilegeDTO> wrapper = new QueryWrapper<>();
        wrapper.select("url");
        wrapper.eq("url", url);
        return urlPrivilegeMapper.select(wrapper);
    }
}
