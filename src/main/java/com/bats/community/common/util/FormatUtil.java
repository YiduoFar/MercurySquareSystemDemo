package com.bats.community.common.util;

import org.springframework.stereotype.Component;

/**
 * 格式工具类
 * @author HuiBBao
 * @create 2022/4/20 12:53
 */
@Component
public class FormatUtil {

    /**
     * 验证码object转string
     * @param code
     * @return
     */
    public String formatSecurityCode(Object code) {
        return code.toString().replace("[", "")
                .replace("]", "")
                .replace(",", "")
                .replace(" ", "");
    }

}
