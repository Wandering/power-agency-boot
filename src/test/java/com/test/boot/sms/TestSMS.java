//package com.test.boot.sms;
//
//import com.alibaba.fastjson.JSON;
//import com.power.cache.RedisRepository;
//import io.renren.RenrenApplicationTests;
//import org.junit.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.util.Assert;
//
//import java.util.UUID;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
///**
// * Created by Administrator on 2017/9/4.
// */
//public class TestSMS extends RenrenApplicationTests{
//    Logger logger = LoggerFactory.getLogger(TestSMS.class);
//    @Autowired
//    private MockMvc mvc;
//    @Autowired
//    private RedisRepository<String,String> redis;
//
//    private static final String phone = "17602903609";
//
//    @Test
//    public void testSMS() throws Exception {
//
//        this.mvc.perform(get("/sms/captcha/sendSMS").accept(MediaType.APPLICATION_JSON_UTF8)
//                .param("phone",phone)
//                .param("token",token))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.rtnCode").value(ok_rtn))
//                .andExpect(jsonPath("$.bizData").value("true"))
//        ;
//        String checkCode = redis.get(checkKey);
//        this.mvc.perform(get("/user/wechat/auth/{uniqueKey}/captcha/checkSms",uniqueKey).accept(MediaType.APPLICATION_JSON_UTF8)
//                .param("phone",phone)
//                .param("checkCode",checkCode)
//                .param("token", UUID.randomUUID().toString()))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.rtnCode").value(ERRORCODE.TOKEN_INVALID_OR_NOTHINGNESS.getCode()));
//        this.mvc.perform(get("/user/wechat/auth/{uniqueKey}/captcha/checkSms",uniqueKey).accept(MediaType.APPLICATION_JSON_UTF8)
//                .param("phone",phone)
//                .param("checkCode","123")
//                .param("token",token))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.rtnCode").value(ERRORCODE.SMS_CHECK_ERROR.getCode()));
//        this.mvc.perform(get("/user/wechat/auth/{uniqueKey}/captcha/checkSms",uniqueKey).accept(MediaType.APPLICATION_JSON_UTF8)
//                .param("phone",phone)
//                .param("checkCode",checkCode)
//                .param("token",token))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.rtnCode").value(ok_rtn))
//                .andExpect(jsonPath("$.bizData").value("true"));
//        Assert.isTrue(!redis.exists(checkKey),"验证码未清除");
//        UserInfoDTO userInfoDTO = JSON.parseObject(redis.get(token),UserInfoDTO.class);
//        Assert.isTrue(userInfoDTO!=null,"用户对象为空");
//        Assert.isTrue(userInfoDTO.getAccountId().equals(Long.valueOf(accountId)),"accountId错误");
//        Assert.isTrue(userInfoDTO.getPhone()!=null,"用户手机号码为空");
//        Assert.isTrue(userInfoDTO.getPhone().equals(phone),"用户手机号码错误");
//        Assert.isTrue(!userInfoDTO.getHeadimgurl().isEmpty(),"用户头像空");
//        Assert.isTrue(!userInfoDTO.getNickname().isEmpty(),"用户昵称为空");
//        Assert.isTrue(userInfoDTO.getOpenId().equals(openId),"openId错误");
//
//    }
//
//}
