package com.zzl.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzl.common.mybatis.Pagination;
import com.zzl.common.utils.PageForm;
import com.zzl.goods.entity.dto.UrlDTO;
import com.zzl.goods.entity.response.UrlPrivilegeVO;
import com.zzl.goods.mapper.UrlMapper;
import com.zzl.goods.service.UrlService;
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
public class UrlServiceImpl extends ServiceImpl<UrlMapper, UrlDTO> implements UrlService {

    @Resource
    private UrlMapper urlMapper;

    @Override
    public Map<String, Object> queryList(@RequestBody @Valid PageForm form) {
        IPage<UrlPrivilegeVO> page = new Pagination<>(form.getCurrent(), form.getSize());
        QueryWrapper<UrlDTO> wrapper = new QueryWrapper<>();
        wrapper.eq("id", 5);
        page = urlMapper.queryList(page, wrapper);
        return Pagination.getResultMap(page);
    }
}
