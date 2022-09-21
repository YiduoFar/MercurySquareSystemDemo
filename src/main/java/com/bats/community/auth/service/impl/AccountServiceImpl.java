package com.bats.community.auth.service.impl;

import com.bats.community.auth.constant.AccountConstant;
import com.bats.community.auth.constant.CommunityConstant;
import com.bats.community.auth.dao.AccountMapper;
import com.bats.community.auth.domain.*;
import com.bats.community.auth.service.AccountService;
import com.bats.community.common.util.DomainTypeUtil;
import com.bats.community.common.util.FormatUtil;
import com.bats.community.common.util.RedisUtil;
import com.bats.community.common.util.SendSms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;

/**
 * @author HuiBBao
 * @create 2022/4/13 22:03
 * DTO、DO相互转换在Service里实现
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private RedisUtil redis;

    @Autowired
    private FormatUtil formatUtil;


    /**
     * 注册（添加账号）
     * @param accountPhone
     * @return
     */
    public DataVO<AccountDTO> inserAccount(String accountPhone) {

        AccountDO accountDO = new AccountDO();
        accountDO.setAccountPhone(accountPhone);

        Integer count = accountMapper.insertAccount(accountDO);

        if (CommunityConstant.DatabaseDMLReturnCode.SUCCESS.equals(count)) {
            // 插入成功, 得到id
            int accountId = accountDO.getAccountId();
            // 设置默认昵称
            String accountName = AccountConstant.PREFIX + accountId;
            Integer count2 = accountMapper.updateAccountNameByAccountId(accountId, accountName);

            if (CommunityConstant.DatabaseDMLReturnCode.SUCCESS.equals(count2)) {
                // 返回对象
                AccountDTO accountDTO = DomainTypeUtil.accountDO2DTO(
                        accountMapper.queryAccountByAccountId(accountId)
                );
                return new DataVO<>(CommunityConstant.SuccessCode.SUCCESS, accountDTO);
            } else {
                return new DataVO<>(CommunityConstant.FailCode.FAILED);
            }
        } else {
            return new DataVO<>(CommunityConstant.FailCode.FAILED);
        }

    }

    /**
     * 登录（认证）
     * @param accountCertification
     * @return
     */
    public DataVO<AccountDTO> certification(AccountCertification accountCertification) {

        AccountDO accountDO = accountMapper.queryAccountByAccountPhone(accountCertification.getAccountPhone());

        // 短信登录
        if (CommunityConstant.Login.LOGINTYPE_ZERO.equals(accountCertification.getLoginType())) {
            // 得到储存在Redis里的验证码
            Object code = redis.get(accountCertification.getAccountPhone());
            if (code != "") {
                // 匹配
                if (formatUtil.formatSecurityCode(code).equals(accountCertification.getSecurityCode())) {
                    // 验证码正确
                    // 如果账号不存在，则注册
                    if (accountDO == null) {
                        return inserAccount(accountCertification.getAccountPhone());
                    } else { // 若存在，则登录
                        //  DO2DTO
                        AccountDTO accountDTO = DomainTypeUtil.accountDO2DTO(accountDO);
                        return new DataVO<>(CommunityConstant.SuccessCode.SUCCESS, accountDTO);
                    }
                } else {
                    // 验证码错误
                    return new DataVO<>(CommunityConstant.FailCode.FAIL_5);
                }
            } else {
                // 验证码过期 或不存在
                return new DataVO<>(CommunityConstant.FailCode.FAIL_6);
            }
        }
        // 密码登录
        if (CommunityConstant.Login.LOGINTYPE_ONE.equals(accountCertification.getLoginType())) {
            // 若账号不存在，则返回
            if (accountDO == null) {
                return new DataVO<>(CommunityConstant.FailCode.FAIL_1);
            }
            if (accountCertification.getAccountPassword().equals(accountDO.getAccountPassword())) {
                // 密码正确
                AccountDTO accountDTO = DomainTypeUtil.accountDO2DTO(accountDO);
                return new DataVO<>(CommunityConstant.SuccessCode.SUCCESS, accountDTO);
            } else {
                // 密码错误
                return new DataVO<>(CommunityConstant.FailCode.FAIL_3);
            }
        }

        return new DataVO<>(CommunityConstant.FailCode.FAILED);
    }

    /**
     * 发送验证码
     * @param accountPhone
     * @return
     */
    public DataVO<AccountDTO> sendSecurityCode(String accountPhone) {

        // 产生4位数验证码
        int[] securityCodeArray = new int[4];
        Random random = new Random();
        for (int i = 0, n = securityCodeArray.length; i < n; i++) {
            securityCodeArray[i] = (char)random.nextInt(10);
        }
        String securityCode = Arrays.toString(securityCodeArray);

        // 发送验证码
        SendSms sendSms = new SendSms();
        if (sendSms.send(accountPhone, securityCodeArray)) {

            // 将产生的验证码存入redis
            redis.set(accountPhone, securityCode);

            // 指定失效时间
            redis.expire(accountPhone, CommunityConstant.Sms.TIME);

            // 从缓存中读取内容
            Object result = redis.get(accountPhone);
            System.out.println(accountPhone + "对应的验证码是" + result);

            return new DataVO<>(CommunityConstant.SuccessCode.SUCCESS);

        } else {
            // 发送失败
            return new DataVO<>(CommunityConstant.FailCode.FAIL_4);
        }

    }


}
