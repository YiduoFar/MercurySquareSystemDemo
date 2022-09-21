package com.bats.community.common.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.bats.community.auth.constant.CommunityConstant;
import com.google.gson.Gson;
import org.apache.http.cookie.SM;

/**
 * 短信发送工具类
 * @author HuiBBao
 * @create 2022/4/17 12:39
 */
public class SendSms {

    public boolean send(String phoneNumbers, int[] param) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-beijing",
                CommunityConstant.Sms.ACCESSKEY_ID,
                CommunityConstant.Sms.ACCESSKEY_SECRET);

        IAcsClient client = new DefaultAcsClient(profile);

        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(phoneNumbers);//接收短信的手机号码
        request.setSignName(CommunityConstant.Sms.SIGNNAME);//短信签名名称
        request.setTemplateCode(CommunityConstant.Sms.TEMPLATECODE);//短信模板CODE
        request.setTemplateParam("{\"code\":\""
                + param[0]
                + param[1]
                + param[2]
                + param[3] + "\"}");//短信模板变量对应的实际值

        try {
            SendSmsResponse response = client.getAcsResponse(request);
            System.out.println(new Gson().toJson(response));
        } catch (ServerException e) {
            e.printStackTrace();
            return false;
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
            return false;
        }

        return true;
    }

}
