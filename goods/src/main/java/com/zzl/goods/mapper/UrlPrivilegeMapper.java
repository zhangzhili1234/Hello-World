package com.zzl.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzl.goods.entity.dto.UrlPrivilegeDTO;
import org.apache.ibatis.annotations.Select;

/**
 * @Desc: TODO
 * @Author: john（coder_john@163.com）
 * @Date: 2019-06-20
 */
public interface UrlPrivilegeMapper extends BaseMapper<UrlPrivilegeDTO> {

    @Select("select * from bi_url_privilege")
    IPage<UrlPrivilegeDTO> queryList(IPage<UrlPrivilegeDTO> page);
}