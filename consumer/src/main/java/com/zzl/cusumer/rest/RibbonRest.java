package com.zzl.cusumer.rest;

import com.zzl.common.result.Result;
import com.zzl.common.utils.PageForm;
import com.zzl.cusumer.service.RibbonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @author john（coder_john@163.com）
 * @desc Ribbon测试类
 * @date 2019-07-08
 */
@RestController
public class RibbonRest {

    @Resource
    private RibbonService ribbonService;

    @PostMapping("/test")
    public Result ribbon() {
        PageForm page = new PageForm(2,1);
        return ribbonService.queryList(page);
    }
}
