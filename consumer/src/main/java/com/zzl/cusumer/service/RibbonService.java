package com.zzl.cusumer.service;

import com.zzl.common.result.Result;
import com.zzl.common.utils.PageForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author john（coder_john@163.com）
 * @desc Ribbon
 * @date 2019-07-08
 */
@FeignClient(value = "goods")
public interface RibbonService {

    @PostMapping("/queryList")
    Result queryList(@RequestBody PageForm form);
}
