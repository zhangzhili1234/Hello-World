package com.zzl.goods.service;

import com.zzl.goods.entity.form.PrivilegeUrlForm;

/**
 * @Desc: TODO
 * @Author: john（coder_john@163.com）
 * @Date: 2019-06-20
 */
public interface UrlPrivilegeService {

    public PrivilegeUrlForm queryByUrl(String url);
}
