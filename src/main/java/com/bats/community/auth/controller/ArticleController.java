package com.bats.community.auth.controller;

import com.bats.community.auth.constant.CommunityConstant;
import com.bats.community.auth.domain.*;
import com.bats.community.auth.service.ArticleService;
import com.bats.community.common.util.CloneDirection;
import com.bats.community.common.util.ObjectUtil;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HuiBBao
 * @create 2022/4/23 11:51
 */
@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;

    /**
     * 文章查询
     * @param articleQuery
     * @return
     */
    @RequestMapping(value = "/index/query", method = RequestMethod.GET)
    public List<?> queryArticle(ArticleQuery articleQuery) throws Exception {
        // 得到文章并排序
        List<ArticleDTO> articles = articleService.queryArticleBySortType(articleQuery);

        // 将不在时间段内的文章过滤
        int timeSlot = articleQuery.getTimeSlot();
        articles = articleService.filterArticleByTimeSlot(articles, timeSlot);

        // 搜索结果
        List<ArticleVO> resultArticles = ObjectUtil.convertList(articles,
                ArticleVO.class, CloneDirection.OPPOSITE);
        // 组合作者名片
        List<?> results = articleService.mergeAccount(resultArticles);
        return results;
    }

}
