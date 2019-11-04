package com.example.demo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.jws.WebService;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.BatchSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class Service {
    //邮件地址为_url，内容为_payload
    public  static char sendEmail(String _url,String _sub,String _payload) {
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "key", "keyscreat");
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        try {
            request.setAccountName("wang@wangjifeng.work");
            request.setFromAlias("siki");
            request.setAddressType(1);
            request.setTagName("tagwang");
            request.setReplyToAddress(true);
            request.setToAddress(_url);    //request.setToAddress("目标地址");
            //可以给多个收件人发送邮件，收件人之间用逗号分开，批量发信建议使用BatchSendMailRequest方式
            //request.setToAddress("121,邮箱2");
            request.setSubject(_sub);  //request.setSubject("邮件主题");
            request.setHtmlBody(_payload);  //request.setHtmlBody("邮件正文");
            //request.setClickTrace("0");//开启需要备案，0关闭，1开启
            //如果调用成功，正常返回httpResponse；如果调用失败则抛出异常，需要在异常中捕获错误异常码；错误异常码请参考对应的API文档;
            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
        } catch (ServerException e) {
            //捕获错误异常码
            System.out.println("ErrCode : " + e.getErrCode());
            e.printStackTrace();
            return 'N';
        }
        catch (ClientException e) {
            //捕获错误异常码
            System.out.println("ErrCode : " + e.getErrCode());
            e.printStackTrace();
            return 'N';
        }
        return 'Y';
    }

    //批量发送邮件
    public char sendEmailBatch(String _url,String _sub,String _payload) {
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "keyID", "keyScreat");
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        try {
            request.setAccountName("wang@wangjifeng.work");
            request.setFromAlias("siki");
            request.setAddressType(1);
            request.setTagName("tagwang");
            request.setReplyToAddress(true);
            request.setToAddress(_url);
            request.setSubject(_sub);  //request.setSubject("邮件主题");
            request.setHtmlBody(_payload);  //request.setHtmlBody("邮件正文");
            //可以给多个收件人发送邮件，收件人之间用逗号分开，批量发信建议使用BatchSendMailRequest方式
            //request.setToAddress("邮箱1,邮箱2");
            //request.setHtmlBody("邮件正文");
            //开启需要备案，0关闭，1开启
            //request.setClickTrace("0");
            //如果调用成功，正常返回httpResponse；如果调用失败则抛出异常，需要在异常中捕获错误异常码；错误异常码请参考对应的API文档;
            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
        } catch (ServerException e) {
            //捕获错误异常码
            System.out.println("ErrCode : " + e.getErrCode());
            e.printStackTrace();
            return 'N';
        }
        catch (ClientException e) {
            //捕获错误异常码
            System.out.println("ErrCode : " + e.getErrCode());
            e.printStackTrace();
            return 'N';
        }
        return 'Y';
    }

    //验证是否为有效的邮件地址
    public static char validateEmailAddress(String _url) {
        String RULE_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
        //正则表达式的模式 编译正则表达式
        Pattern p = Pattern.compile(RULE_EMAIL);
        //正则表达式的匹配器
        Matcher m = p.matcher(_url);
        //进行正则匹配
        if(m.matches() == false) {
            return 'N';
        }else
            return 'Y';
    }
}
