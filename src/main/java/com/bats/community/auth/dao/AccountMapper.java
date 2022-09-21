package com.bats.community.auth.dao;

import com.bats.community.auth.domain.AccountDO;
import org.apache.ibatis.annotations.*;

/**
 * @author HuiBBao
 * @create 2022/4/13 22:04
 */
@Mapper
public interface AccountMapper {



    /**
     * 新增账号
     * @param
     */
    @Insert("INSERT INTO account("
            + "account_id,"
            + "account_name,"
            + "account_password,"
            + "account_phone,"
            + "account_sex,"
            + "account_type,"
            + "account_status"
            + ") VALUES("
            + "default,"
            + "null,"
            + "null,"
            + "#{accountPhone},"
            + "default," // 性别默认：男 0
            + "default," // 用户类型默认：普通用户 0
            + "default" // 状态默认：离线 0
            + ")")
    @Options(keyColumn = "account_id", keyProperty = "accountId", useGeneratedKeys = true)
    Integer insertAccount(AccountDO accountDO);

    /**
     * 通过id找到一个用户
     * @param accountId
     * @return
     */
    @Select("SELECT * FROM account WHERE account_id = #{accountId}")
    AccountDO queryAccountByAccountId(int accountId);

    /**
     * 通过手机号找一个用户
     * @param accountPhone
     * @return
     */
    @Select("SELECT * FROM account WHERE account_phone = #{accountPhone}")
    AccountDO queryAccountByAccountPhone(String accountPhone);

    /**
     * 通过id设置昵称
     * @param accountId
     * @param accountName
     * @return
     */
    @Update("UPDATE account SET account_name = #{accountName} WHERE account_id = #{accountId}")
    Integer updateAccountNameByAccountId(int accountId, String accountName);


    @Select("SELECT " +
            "account_id," +
            "account_name," +
            "account_icon," +
            "account_readed_num," +
            "account_liked_num," +
            "account_collected_num," +
            "account_followed_num " +
            "FROM account " +
            "WHERE account_name = #{accountName}")
    AccountDO queryAccountByNameForFacade(@Param("accountName") String authorName);
}
