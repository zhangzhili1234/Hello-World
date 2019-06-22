package com.zzl.goods.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzl.common.mybatis.Pagination;
import com.zzl.common.utils.PageForm;
import com.zzl.goods.entity.dto.UrlPrivilegeDTO;
import com.zzl.goods.mapper.UrlPrivilegeMapper;
import com.zzl.goods.service.UrlPrivilegeService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Map;

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
    public Map<String, Object> queryList(@RequestBody @Valid PageForm form) {
        IPage<UrlPrivilegeDTO> page = new Pagination<>(form.getCurrent(), form.getSize());
        page = urlPrivilegeMapper.queryList(page);
        return Pagination.getResultMap(page);
    }
}
