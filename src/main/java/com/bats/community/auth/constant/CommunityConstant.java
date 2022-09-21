package com.bats.community.auth.constant;


import javafx.util.Pair;

/**
 * @author HuiBBao
 * @create 2022/4/13 21:55
 */
public final class CommunityConstant {

    public static class DatabaseDMLReturnCode {
        /**
         * 成功
         */
        public static final Integer SUCCESS = 1;
        /**
         * 失败
         */
        public static final Integer FAILED = 0;
    }

    /**
     * 登录
     */
    public static class Login {
        /**
         * 短信登录方式码
         */
        public static final Integer LOGINTYPE_ZERO = 0;
        /**
         * 密码登录方式码
         */
        public static final Integer LOGINTYPE_ONE = 1;
    }

    /**
     * 短信
     */
    public static class Sms {
        /**
         * AccessKey ID
         */
        public static final String ACCESSKEY_ID = "LTAI5tCrGqbTWpHLZ6Pgss9N";
        /**
         * AccessKey Secret
         */
        public static final String ACCESSKEY_SECRET = "ZeO4SMpt9LKEsfmMCMJ5H6kEMlVcRT";
        /**
         * 短信签名名称
         */
        public static final String SIGNNAME = "阿里云短信测试";
        /**
         * 短信模板Code
         */
        public static final String TEMPLATECODE = "SMS_154950909";
        /**
         * 失效时间 60s
         */
        public static final long TIME = 60;
    }

    /**
     * 成功码
     */
    public static class SuccessCode {
        /**
         * 成功
         */
        public static final Pair<Integer, String> SUCCESS = new Pair<>(1, "SUCCESS:成功");
    }

    /**
     * 错误码
     */
    public static class FailCode {
        /**
         * 账号不存在
         */
        public static final Pair<Integer, String> FAIL_1 = new Pair<>(100, "ERROR:账号不存在");
        /**
         * 账号已存在（注册）
         */
        public static final Pair<Integer, String> FAIL_2 = new Pair<>(200, "ERROR:账号已存在");
        /**
         * 密码错误
         */
        public static final Pair<Integer, String> FAIL_3 = new Pair<>(300, "ERROR:密码错误");
        /**
         * 验证码发送失败
         */
        public static final Pair<Integer, String> FAIL_4 = new Pair<>(400, "ERROR:验证码发送失败");
        /**
         * 验证码错误
         */
        public static final Pair<Integer, String> FAIL_5 = new Pair<>(500, "ERROR:验证码错误");
        /**
         * 验证码过期 或不存在
         */
        public static final Pair<Integer, String> FAIL_6 = new Pair<>(600, "ERROR:验证码过期 或不存在");
        /**
         * 未知错误
         */
        public static final Pair<Integer, String> FAILED = new Pair<>(-100, "ERROR:未知错误(可能源于控制层传参或数据层)");
    }

}
