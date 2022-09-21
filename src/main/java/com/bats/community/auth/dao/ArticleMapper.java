package com.bats.community.auth.dao;

import com.bats.community.auth.domain.ArticleDO;
import com.bats.community.auth.domain.ArticleDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author HuiBBao
 * @create 2022/4/23 20:19
 */
@Mapper
public interface ArticleMapper {

    /**
     * 通过标题查询文章作为列表项的信息
     * @param queryWord
     * @return
     */
    @Select("SELECT " +
            "article_id," +
            "article_title," +
            "article_author_name," +
            "article_cover," +
            "article_publish_date," +
            "article_digest," +
            "article_browse_num," +
            "article_liked_num," +
            "article_forwarded_num," +
            "article_collected_num," +
            "article_comment_num " +
            "FROM article " +
            "WHERE article_title like CONCAT(#{queryWord}, '%')")
    List<ArticleDO> queryArticleByTitle(String queryWord);

}
