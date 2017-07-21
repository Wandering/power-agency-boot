<<<<<<< HEAD
//package com.test.boot;
//
//import com.power.yuneng.nonparty.api.IPowerConsumer;
//import com.power.yuneng.nonparty.domain.req.QueryPowerReq;
//import com.power.yuneng.nonparty.domain.res.QueryPowerRes;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.util.Assert;
//
///**
// * Created by Administrator on 2017/7/20.
// */
//@RunWith(SpringRunner.class)
////@SpringBootTest
//@ContextConfiguration(locations = "classpath*:config/zgk-dubbo-consumer-test.xml")
//public class PowerConsumerTest {
//    private final static Logger logger = LoggerFactory.getLogger(PowerConsumerTest.class);
////
////    @Autowired
////    private RestTemplate restTemplate;
//
//    @Autowired
//    IPowerConsumer powerConsumer;
////    @Test
////    public void testName1() throws Exception {
////        BaseReq req = new BaseReq();
////        req.setUrl("http://iot.zhilutec.com:8080/MIA-API/management/device/query");
////        req.setUserid("a2630e98-ce28-4f5f-9a4c-d68dfed8c913");
////        HttpHeaders httpHeaders = new HttpHeaders();
////        List<MediaType> list = new ArrayList<>();
////        list.add(MediaType.ALL);
////        httpHeaders.setAccept(list);
////        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
////        TokenRes res = restTemplate.postForEntity(req.getUrl(),new HttpEntity<BaseReq>(req,httpHeaders), TokenRes.class).getBody();
////    }
////
//    @Test
//    public void testName() throws Exception {
//        QueryPowerRes res = powerConsumer.queryPower(new QueryPowerReq(10));
//        Assert.isTrue(res.getTotalRows()>0,"数据为空");
//    }
//
//}
=======
package com.test.boot;

import com.power.yuneng.nonparty.api.IPowerConsumer;
import com.power.yuneng.nonparty.domain.req.QueryPowerReq;
import com.power.yuneng.nonparty.domain.res.QueryPowerRes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

/**
 * Created by Administrator on 2017/7/20.
 */
@RunWith(SpringRunner.class)
//@SpringBootTest
@ContextConfiguration(locations = "classpath*:config/zgk-dubbo-consumer-test.xml")
public class PowerConsumerTest {
    private final static Logger logger = LoggerFactory.getLogger(PowerConsumerTest.class);
//
//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    IPowerConsumer powerConsumer;
//    @Test
//    public void testName1() throws Exception {
//        BaseReq req = new BaseReq();
//        req.setUrl("http://iot.zhilutec.com:8080/MIA-API/management/device/query");
//        req.setUserid("a2630e98-ce28-4f5f-9a4c-d68dfed8c913");
//        HttpHeaders httpHeaders = new HttpHeaders();
//        List<MediaType> list = new ArrayList<>();
//        list.add(MediaType.ALL);
//        httpHeaders.setAccept(list);
//        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
//        TokenRes res = restTemplate.postForEntity(req.getUrl(),new HttpEntity<BaseReq>(req,httpHeaders), TokenRes.class).getBody();
//    }
//
    @Test
    public void testName() throws Exception {
        QueryPowerRes res = powerConsumer.queryPower(new QueryPowerReq(10));
        Assert.isTrue(res.getTotalRows()>0,"数据为空");
    }

}
>>>>>>> origin/master
