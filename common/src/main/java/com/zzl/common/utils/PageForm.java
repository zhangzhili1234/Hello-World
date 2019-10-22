package com.zzl.common.utils;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @desc: 分页查询入参
 * @author: john（zhangzhili@163.com）
 * @date: 2019/6/6
 */
@Setter
@Getter
public class PageForm implements Serializable{

	private static final long serialVersionUID = -1988568179983044897L;
	
	@NotNull(message = "每页显示数量不能为空")
    private Integer size;

    @NotNull(message = "当前页数不能为空")
    private Integer current;

    public PageForm() {
    }

    public PageForm(Integer size, Integer current) {
        this.size = size;
        this.current = current;
    }

    @Override
    public String toString() {
        return "PageForm{" +
                "size=" + size +
                ", current=" + current +
                '}';
    }
}
