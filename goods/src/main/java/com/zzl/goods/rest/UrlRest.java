package com.zzl.goods.rest;

import com.zzl.common.result.Result;
import com.zzl.common.utils.PageForm;
import com.zzl.goods.service.UrlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Map;

/**
 * @Desc: TODO
 * @Author: john（coder_john@163.com）
 * @Date: 2019-06-20
 */
@Slf4j
@RestController
public class UrlRest {

    @Resource
    private UrlService urlService;

    @PostMapping("/queryList")
    public Result queryList(@RequestBody @Valid PageForm form) throws InterruptedException {
        log.info("UrlPrivilegeRest queryList start...params:{}", form);
        Map<String, Object> returnMap = urlService.queryList(form);
        log.info("UrlPrivilegeRest queryList end...");
//        Thread.sleep(3000);
        return Result.success(returnMap);
    }
}
