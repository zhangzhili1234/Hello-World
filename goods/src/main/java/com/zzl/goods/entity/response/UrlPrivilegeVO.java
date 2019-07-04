package com.zzl.goods.entity.response;

import lombok.Data;
import java.io.Serializable;

/**
 * @Desc: TODO
 * @Author: john（coder_john@163.com）
 * @Date: 2019-06-24
 */
@Data
public class UrlPrivilegeVO implements Serializable {

    private static final long serialVersionUID = 5921555025841143763L;

    /** 是否可用 0：可用，1：不可用 */
    private String isAccess;

    /** 是否需要登陆 0：需登陆，1：无需登录 */
    private String isLogin;

}
