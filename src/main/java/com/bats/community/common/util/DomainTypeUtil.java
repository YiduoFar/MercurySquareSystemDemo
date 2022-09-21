package com.bats.community.common.util;

import com.bats.community.auth.domain.AccountDO;
import com.bats.community.auth.domain.AccountDTO;
import com.bats.community.auth.domain.ArticleDO;
import com.bats.community.auth.domain.ArticleDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * 领域模型转换工具类
 * @author HuiBBao
 * @create 2022/4/13 23:25
 */
public class DomainTypeUtil {

    /**
     * Account DTO转DO
     * @param accountDTO
     * @return
     */
    public static AccountDO accountDTO2DO(AccountDTO accountDTO) {
        AccountDO accountDO = new AccountDO();
        accountDO.setAccountId(accountDTO.getAccountId());
        accountDO.setAccountName(accountDTO.getAccountName());
        accountDO.setAccountPassword(accountDTO.getAccountPassword());
        return accountDO;
    }

    /**
     * Account DO转DTO
     * @param accountDO
     * @return
     */
    public static AccountDTO accountDO2DTO(AccountDO accountDO) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountId(accountDO.getAccountId());
        accountDTO.setAccountPhone(accountDO.getAccountPhone());
        accountDTO.setAccountChat(accountDO.getAccountChat());
        accountDTO.setAccountName(accountDO.getAccountName());
        accountDTO.setAccountDynamic(accountDO.getAccountDynamic());
        accountDTO.setAccountSex(accountDO.getAccountSex());
        accountDTO.setAccountFollow(accountDO.getAccountFollow());
        accountDTO.setAccountType(accountDO.getAccountType());
        accountDTO.setAccountFavorite(accountDO.getAccountFavorite());
        accountDTO.setAccountHistory(accountDO.getAccountHistory());
        accountDTO.setAccountMessage(accountDO.getAccountMessage());
        accountDTO.setAccountStatus(accountDO.getAccountStatus());
        accountDTO.setAccountCollectedNum(accountDO.getAccountCollectedNum());
        accountDTO.setAccountFollowedNum(accountDO.getAccountFollowedNum());
        accountDTO.setAccountReadedNum(accountDO.getAccountReadedNum());
        accountDTO.setAccountLikedNum(accountDO.getAccountLikedNum());
        accountDTO.setAccountIcon(accountDO.getAccountIcon());
//        accountDTO.setAccountPassword(accountDO.getAccountPassword()); // DTO过滤DO属性 密码无需传输
        return accountDTO;
    }

    /**
     * Article DO2DTO
     * @param listDO
     * @return
     */
    public static List<ArticleDTO> articleDO2DTOForList(List<ArticleDO> listDO) {
        List<ArticleDTO> relist = new ArrayList<>();
        for (ArticleDO articleDO : listDO) {
            ArticleDTO articleDTO = new ArticleDTO();
            articleDTO.setArticleId(articleDO.getArticleId());
            articleDTO.setArticleTitle(articleDO.getArticleTitle());
            articleDTO.setArticleAuthorName(articleDO.getArticleAuthorName());
            articleDTO.setArticleCover(articleDO.getArticleCover());
            articleDTO.setArticlePublishDate(articleDO.getArticlePublishDate());
            articleDTO.setArticleDigest(articleDO.getArticleDigest());
            articleDTO.setArticleBrowseNum(articleDO.getArticleBrowseNum());
            articleDTO.setArticleLikedNum(articleDO.getArticleLikedNum());
            articleDTO.setArticleForwardedNum(articleDO.getArticleForwardedNum());
            articleDTO.setArticleCollectedNum(articleDO.getArticleCollectedNum());
            articleDTO.setArticleCommentNum(articleDO.getArticleCommentNum());
            relist.add(articleDTO);
        }
        return relist;
    }

}
