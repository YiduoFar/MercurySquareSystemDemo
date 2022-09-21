package com.bats.community.auth.domain;

import com.bats.community.common.util.AbstractObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author HuiBBao
 * @create 2022/4/13 22:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountDO extends AbstractObject {

    int accountId; // id
    String accountName; // 用户名
    String accountIcon; // 头像
    String accountPassword; // 密码
    String accountPhone; // 电话
    int accountSex; // 性别（男0，女1）
    int accountType; // 用户类型（普通用户为0，管理员为1）
    int accountStatus; // 状态（离线0，在线1，封禁2）
    String accountFollow; // 关注列表
    String accountFavorite; // 收藏列表
    String accountDynamic; // 动态列表
    String accountMessage; // 消息通知列表
    String accountHistory; // 浏览记录列表
    String accountChat; // 私信
    int accountReadedNum; // 被阅读
    int accountLikedNum; // 被点赞
    int accountCollectedNum; // 被收藏
    int accountFollowedNum; // 被关注

}
