package com.bats.community.test.controller;

import com.bats.community.auth.controller.AccountController;
import com.bats.community.auth.domain.AccountDTO;
import com.bats.community.auth.domain.AccountCertification;
import com.bats.community.auth.domain.DataVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author HuiBBao
 * @create 2022/4/17 16:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountControllerTest {

    @Autowired
    AccountController accountController;

    @Test
    public void loginTest() {
        DataVO<AccountDTO> dataVO = accountController.certification(
                new AccountCertification(0, "13168162412", "", "8241"));
        System.out.println(dataVO);
    }

    @Test
    public void sendSecurityCodeTest() {
        accountController.sendSecurityCode("13168162412");
    }


}
