package com.zzl.goods.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;

/**
 * @desc TODO  
 * @author john(coder_john@163.com)
 * @date 2019-07-03 
 */
@Getter
@Setter
@ToString
@TableName("mall_url")
public class UrlDTO implements Serializable {

	private static final long serialVersionUID =  462912569377774954L;

	/** 主键 */
	private Long id;

	/** url */
	private String url;

	/** 是否可用 0：可用，1：不可用 */
	private String isAccess;

	/** 是否需要登陆 0：需登陆，1：无需登录 */
	private String isLogin;

	/** 描述 */
	private String description;

	/** 创建人 */
	private String createdBy;

	/** 创建时间 */
	private Integer createdDate;

	/** 更新人 */
	private String updatedBy;

	/** 更新时间 */
	@TableField
	private Integer updatedDate;

}
