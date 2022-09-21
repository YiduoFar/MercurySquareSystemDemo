package com.bats.community.test;

import com.bats.community.auth.constant.CommunityConstant;
import com.bats.community.auth.controller.AccountController;
import com.bats.community.auth.controller.ArticleController;
import com.bats.community.auth.domain.AccountDTO;
import com.bats.community.auth.domain.ArticleQuery;
import com.bats.community.auth.service.AccountService;
import com.bats.community.auth.service.ArticleService;
import com.bats.community.common.util.DomainTypeUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author HuiBBao
 * @create 2022/4/13 23:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExampleTest {

    @Autowired
    AccountController accountController;

    @Autowired
    AccountService accountService;

    @Autowired
    ArticleController articleController;

    @Test
    public void test001() throws Exception {
//        System.out.println(articleController.queryArticle(new ArticleQuery(1, "Java")));
    }

    @Test
    public void test002() {
        char a = 5;
        System.out.println(a);
    }

}
