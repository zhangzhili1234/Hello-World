package com.zzl.goods.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzl.goods.entity.dto.UrlPrivilegeDTO;
import com.zzl.goods.entity.form.PrivilegeUrlForm;
import org.apache.ibatis.annotations.Param;

/**
 * @Desc: TODO
 * @Author: john（coder_john@163.com）
 * @Date: 2019-06-20
 */
public interface UrlPrivilegeMapper extends BaseMapper<UrlPrivilegeDTO> {

    PrivilegeUrlForm select(@Param("ew") Wrapper<UrlPrivilegeDTO> queryWrapper);

}
