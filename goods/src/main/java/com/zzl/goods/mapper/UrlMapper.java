package com.zzl.goods.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzl.goods.entity.dto.UrlDTO;
import com.zzl.goods.entity.response.UrlPrivilegeVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Desc: TODO
 * @Author: john（coder_john@163.com）
 * @Date: 2019-06-20
 */
public interface UrlMapper extends BaseMapper<UrlDTO> {

    @Select("select * from mall_url ${ew.customSqlSegment}")
    IPage<UrlPrivilegeVO> queryList(IPage<UrlPrivilegeVO> page, @Param("ew") QueryWrapper<UrlDTO> wrapper);
}