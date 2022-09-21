package com.bats.community.test.controller;

import com.bats.community.auth.controller.ArticleController;
import com.bats.community.auth.domain.ArticleQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author HuiBBao
 * @create 2022/4/27 20:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleControllerTest {

    @Autowired
    ArticleController articleController;

    @Test
    public void queryArticleTest() throws Exception {
//        System.out.println(articleController.queryArticle(new ArticleQuery(0, "Java")));
    }

}
