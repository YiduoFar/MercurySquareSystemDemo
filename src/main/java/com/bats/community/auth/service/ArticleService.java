package com.bats.community.auth.service;

import com.bats.community.auth.domain.*;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HuiBBao
 * @create 2022/4/23 11:51
 */
public interface ArticleService {

    /**
     * 查询文章（推荐）
     * @param queryWord
     * @return
     */
    List<ArticleDTO> queryArticleByRecommend(String queryWord);

    /**
     * 查询文章（热门）
     * @param queryWord
     * @return
     */
    List<ArticleDTO> queryArticleByHot(String queryWord);

    /**
     * 查询文章（最新）
     * @param queryWord
     * @return
     */
    List<ArticleDTO> queryArticleByNewest(String queryWord);

    /**
     * 组合作者名片
     * @param resultArticles
     * @return
     */
    List<?> mergeAccount(List<ArticleVO> articles) throws Exception;


    /**
     * queryArticleBySortType
     * @param articleQuery
     * @return
     */
    List<ArticleDTO> queryArticleBySortType(ArticleQuery articleQuery);

    /**
     * filterArticleByTimeSlot
     * @param articles
     * @param timeSlot
     * @return
     */
    List<ArticleDTO> filterArticleByTimeSlot(List<ArticleDTO> articles, int timeSlot);
}
