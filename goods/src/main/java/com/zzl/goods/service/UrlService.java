package com.zzl.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzl.common.utils.PageForm;
import com.zzl.goods.entity.dto.UrlDTO;

import java.util.Map;

/**
 * @Desc: TODO
 * @Author: john（coder_john@163.com）
 * @Date: 2019-06-20
 */
public interface UrlService extends IService<UrlDTO> {

    Map<String, Object> queryList(PageForm form);
}
