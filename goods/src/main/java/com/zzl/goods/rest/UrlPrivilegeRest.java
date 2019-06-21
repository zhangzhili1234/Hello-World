package com.zzl.goods.rest;

import com.zzl.common.response.BaseRest;
import com.zzl.common.response.Result;
import com.zzl.goods.entity.form.PrivilegeUrlForm;
import com.zzl.goods.service.UrlPrivilegeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Desc: TODO
 * @Author: john（coder_john@163.com）
 * @Date: 2019-06-20
 */
@RestController
public class UrlPrivilegeRest extends BaseRest {

    @Resource
    private UrlPrivilegeService urlPrivilegeService;

    @PostMapping("/queryByUrl")
    public Result queryByUrl(@RequestBody @Valid PrivilegeUrlForm form) {
        return this.success(urlPrivilegeService.queryByUrl(form.getUrl()));
    }
}
