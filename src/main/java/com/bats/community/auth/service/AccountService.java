package com.bats.community.auth.service;

import com.bats.community.auth.domain.*;

/**
 * @author HuiBBao
 * @create 2022/4/13 21:43
 */
public interface AccountService {


    /**
     * 添加账号
     * @param accountPhone
     * @return
     */
    DataVO<AccountDTO> inserAccount(String accountPhone);

    /**
     * 发送验证码
     * @param accountPhone
     * @return
     */
    DataVO<?> sendSecurityCode(String accountPhone);

    /**
     * 登录
     * @param accountCertification
     * @return
     */
    DataVO<AccountDTO> certification(AccountCertification accountCertification);

}
