package com.zzl.common.utils;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;

/**
 * @author john（coder_john@163.com）
 * @desc 获取唯一ID工具类
 * @date 2019-07-03
 */
public class UniqueIdUtil {

    /**
     * UUID
     * @return uuid
     */
    public static String uuid() {
        return IdWorker.get32UUID();
    }

    /**
     * 雪花算法生成ID
     * @return work_id
     */
    public static Long work_id() {
        return IdWorker.getId();
    }
}
