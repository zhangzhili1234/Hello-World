package com.zzl.goods;

import com.zzl.goods.entity.dto.UrlDTO;
import com.zzl.goods.mapper.UrlMapper;
import com.zzl.goods.service.UrlService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsApplicationTests {

    @Resource
    private UrlMapper urlMapper;

    @Resource
    private UrlService urlService;

    @Test
    public void insert() {
        UrlDTO urlDTO = new UrlDTO();
        urlDTO.setUrl("/test");
        urlDTO.setIsAccess("0");
        urlDTO.setIsLogin("0");
        urlDTO.setCreatedDate(1562132026);
        urlDTO.setUpdatedDate(1562132026);
        urlMapper.insert(urlDTO);
    }

}
