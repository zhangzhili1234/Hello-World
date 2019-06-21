package com.zzl.goods.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @desc: TODO
 * @author: john(coder_john@163.com)
 * @date: 2019-06-20
 */
@Getter
@Setter
@ToString
@TableName("bi_url_privilege")
public class UrlPrivilegeDTO implements Serializable {

	private static final long serialVersionUID =  8926474675886062478L;

	/** 主键 */
   	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/** url */
   	@TableField("url")
	private String url;

	/** 是否可用 0：可用，1：不可用 */
   	@TableField("is_access")
	private String isAccess;

	/** 是否需要登陆 0：需登陆，1：无需登录 */
   	@TableField("is_login")
	private String isLogin;

	/** 描述 */
   	@TableField("description")
	private String description;

}
