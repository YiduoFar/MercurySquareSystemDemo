package com.bats.community.auth.service.impl;

import com.bats.community.auth.constant.CommunityConstant;
import com.bats.community.auth.dao.AccountMapper;
import com.bats.community.auth.dao.ArticleMapper;
import com.bats.community.auth.domain.*;
import com.bats.community.auth.service.AccountService;
import com.bats.community.auth.service.ArticleService;
import com.bats.community.common.algorithm.ArticleAlgorithm;
import com.bats.community.common.util.AbstractObject;
import com.bats.community.common.util.CloneDirection;
import com.bats.community.common.util.DomainTypeUtil;
import com.bats.community.common.util.ObjectUtil;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author HuiBBao
 * @create 2022/4/23 11:52
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    ArticleAlgorithm articleAlgorithm;

    @Autowired
    AccountMapper accountMapper;

    /**
     *
     * @param
     * @return
     */
    public List<ArticleDTO> queryArticleBySortType(ArticleQuery articleQuery) {
        // 得到模糊查询的数据
        List<ArticleDTO> listDTO = DomainTypeUtil.articleDO2DTOForList(
                articleMapper.queryArticleByTitle(articleQuery.getKeyWord())
        );
        int sortType = articleQuery.getSortType();
        List<ArticleDTO> articles = null;
        if (sortType == 0) { // 推荐
            articles = queryArticleByRecommend(articleQuery.getKeyWord());
        } else if (sortType == 1) { // 热门
            articles = queryArticleByHot(articleQuery.getKeyWord());
        } else if (sortType == 2) { // 最新
            articles = queryArticleByNewest(articleQuery.getKeyWord());
        }
        return articles;
    }

    /**
     * 时间过滤
     * @param articles
     * @param timeSlot
     * @return
     */
    public List<ArticleDTO> filterArticleByTimeSlot(List<ArticleDTO> articles, int timeSlot) {
        switch (timeSlot) {
            case 1: { // 一天

                break;
            }
            case 2: { // 一周

                break;
            }
            case 3: { // 三月

                break;
            }
            default:break;
        }
        return articles;
    }

    /**
     * 查询文章（推荐）
     * @param queryWord
     * @return
     */
    public List<ArticleDTO> queryArticleByRecommend(String queryWord) {
        // 得到模糊查询的数据
        List<ArticleDTO> listDTO = DomainTypeUtil.articleDO2DTOForList(
                articleMapper.queryArticleByTitle(queryWord)
        );
        // 推荐算法排序
        listDTO.sort(
                (o1, o2) -> articleAlgorithm.recommendInQuery(o1, o2)
        );
        return listDTO;
    }

    /**
     * 查询文章（热门）
     * @param queryWord
     * @return
     */
    public List<ArticleDTO> queryArticleByHot(String queryWord) {
        // 得到模糊查询的数据
        List<ArticleDTO> listDTO = DomainTypeUtil.articleDO2DTOForList(
                articleMapper.queryArticleByTitle(queryWord)
        );
        // 热门（浏览量）排序
        listDTO.sort((o1, o2) -> {
            int browseNum1 = o1.getArticleBrowseNum();
            int browseNum2 = o2.getArticleBrowseNum();
            if (browseNum1 == browseNum2) {
                return 0;
            } else {
                return browseNum1 > browseNum2 ? -1 : 1;
            }
        });
        return listDTO;
    }

    /**
     * 查询文章（最新）
     * @param queryWord
     * @return
     */
    public List<ArticleDTO> queryArticleByNewest(String queryWord) {
        // 得到模糊查询的数据
        List<ArticleDTO> listDTO = DomainTypeUtil.articleDO2DTOForList(
                articleMapper.queryArticleByTitle(queryWord)
        );
        // 最新（发布时间）排序
        listDTO.sort((o1, o2) -> {
            String publishTime1 = o1.getArticlePublishDate();
            String publishTime2 = o2.getArticlePublishDate();
            Long date1 = null;
            Long date2 = null;
            try {
                date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(publishTime1).getTime();
                date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(publishTime2).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (date1 != null && date2 != null) {
                if (date1.equals(date2)) {
                    return 0;
                } else {
                    return date1 > date2 ? -1 : 1;
                }
            } else {
                return 0;
            }
        });
        return listDTO;
    }

    /**
     * 组合作者名片
     * @param articles
     * @return
     */
    public List<?> mergeAccount(List<ArticleVO> articles) throws Exception {
        List<Pair<ArticleVO, AccountDTO>> list = new ArrayList<>();
        for (ArticleVO articleVO : articles) {
            String authorName = articleVO.getArticleAuthorName();
            // 查询作者信息
            // 使用clone方法将DO的属性拷贝到DTO（浅拷贝）
            AccountDTO accountDTO = accountMapper.queryAccountByNameForFacade(authorName)
                    .clone(AccountDTO.class);
            // 以键值对的形式加入list
            list.add(new Pair<>(articleVO, accountDTO));
        }
        return list;
    }


}
