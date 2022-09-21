package com.bats.community.common.algorithm;

import com.bats.community.auth.domain.ArticleDTO;
import org.springframework.stereotype.Component;

/**
 * @author HuiBBao
 * @create 2022/4/23 21:23
 */
@Component
public class ArticleAlgorithm {

    /**
     * 搜索处 推荐算法
     * @param o1
     * @param o2
     * @return
     */
    public int recommendInQuery(ArticleDTO o1, ArticleDTO o2) {
        // 不知道怎么写合适，弄了两个分数比较
        double score1 = o1.getArticleBrowseNum() * 0.2
                + o1.getArticleLikedNum() * 20
                + o1.getArticleForwardedNum() * 20
                + o1.getArticleCollectedNum() * 20
                + o1.getArticleCommentNum() * 20;
        double score2 = o2.getArticleBrowseNum() * 0.2
                + o2.getArticleLikedNum() * 20
                + o2.getArticleForwardedNum() * 20
                + o2.getArticleCollectedNum() * 20
                + o2.getArticleCommentNum() * 20;
        return score1 > score2 ? -1 : 1;
    }


}
