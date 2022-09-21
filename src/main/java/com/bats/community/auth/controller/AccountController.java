package com.bats.community.auth.controller;

import com.bats.community.auth.domain.*;
import com.bats.community.auth.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author HuiBBao
 * @create 2022/4/13 21:32
 */
@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    /**
     * 发送验证码
     * @param accountPhone
     * @return
     */
    @RequestMapping(value = "/account/sendCode", method = RequestMethod.POST)
    public DataVO<?> sendSecurityCode(@RequestParam("phoneNumber") String accountPhone) {
        return accountService.sendSecurityCode(accountPhone);
    }

    /**
     * 登录(认证) 可能存在问题
     * @param accountCertification
     * @return
     */
    @RequestMapping(value = "/account/certification", method = RequestMethod.POST)
    public DataVO<AccountDTO> certification(AccountCertification accountCertification) {
        return accountService.certification(accountCertification);
    }


}
