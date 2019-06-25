package com.zzl.goods.entity.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Desc: TODO
 * @Author: john（coder_john@163.com）
 * @Date: 2019-06-20
 */
@Getter
@Setter
@ToString
public class PrivilegeUrlForm implements Serializable {

    private static final long serialVersionUID = 1535331382277994125L;

    private String url;
}
