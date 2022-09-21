package com.bats.community.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * unused
 * @author HuiBBao
 * @create 2022/4/19 21:56
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AccountCertification {
    int loginType; // 状态码 0-免密登录or注册, 1-密码登录
    String accountPhone; // 手机号
    String accountPassword; // 密码
    String securityCode; // 验证码
}
