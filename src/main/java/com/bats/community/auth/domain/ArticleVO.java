package com.bats.community.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author HuiBBao
 * @create 2022/4/24 13:04
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ArticleVO {
    int articleId;
    String articleTitle;// '标题'
    String articleAuthorName;// '作者'
    String articleCover;// '封面图片'
    String articlePublishDate;// '发布时间（now() / 2022-4-22 20:45:50）\r\n作为草稿就没有发布时间，为null'
    String articleText;// '文章内容'
    String articleDigest;// '摘要（200字以内）'
    String articleLabelId;// '标签id组'(int数组)
    String articleModelId;// '模块id组'(int数组)
    int articleStatus;// '状态（0-未发布，1-已发布，2-已下架）'
    String articleLink;// '文章链接（已发布后）'
    int articleBrowseNum;// '浏览量'
    int articleLikedNum;// '点赞数'
    int articleTreadedNum;// '点踩数'
    int articleForwardedNum;// '转发数'
    int articleCollectedNum;// '收藏数'
    int articleCommentNum;// '评论数'
    String articleComment;// '评论（json）'
}
