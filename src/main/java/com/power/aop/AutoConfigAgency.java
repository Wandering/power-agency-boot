package com.power.aop;

import com.alibaba.fastjson.JSON;
import io.renren.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/6/23.
 * 自动注入项目agencyId
 */
@Aspect
@Component
public class AutoConfigAgency {

    private final static Logger logger = LoggerFactory.getLogger(AutoConfigAgency.class);

//    private final static List<Pattern> pointcuts = new ArrayList<>();

    private final static String regex =  "com.power.entity.* ||　io.renren.dao.*";

    @Pointcut("execution(* com.power.dao..*.*(..)) || execution(* io.renren.dao..*.*(..))")
    public void autoConfig(){}


    @Before("autoConfig()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        logger.debug("匹配正则点...");
//        boolean isPointcut =  isPointcut(joinPoint.getSignature().getDeclaringType().getName());
//        logger.debug("当前匹配结果：%s",isPointcut);
//        if (!isPointcut){
//            return;
//        }

        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()){
            logger.debug("用户未登录，跳出切入点！");
            return;
        }
        logger.debug("用户已经登录，进入切入点，开始处理参数");
        logger.debug("当前切入方法为:{}",joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        logger.debug("传入参数json为：{}",JSON.toJSONString(args));
        if (args.length>0){
            logger.debug("参数数量为：{}，开始读取最后一个参数",args.length);
            Object lastObj = args[args.length-1];
            logger.debug("最后一个参数值json为：{}",JSON.toJSONString(lastObj));

            logger.debug("开始判定最后一个对象是不是对象...");
            Class clazz = lastObj.getClass();
            boolean isEntity = regex.matches(clazz.getName());

            if (isEntity){
                try {
                    logger.debug("判定对象是注入对象");
//                    clazz.
                }catch (Exception e){}
            }

            boolean isMap = lastObj instanceof LinkedHashMap;
            logger.debug("最后一个参数是否是map：{}",isMap);
            lastObj.getClass();
            Map map = null;
            if (isMap) {
                map = (Map) args[args.length - 1];
                logger.debug("开始注入agencyId");
                SysUserEntity userEntity = (SysUserEntity)subject.getPrincipal();
                userEntity.setAgencyId(1);
                Integer agencyId = userEntity.getAgencyId();
//                Integer agencyId = 1;
                logger.debug("当前agencyId为：{}，{}",agencyId,"跳过运营商注入！");
                if (agencyId != null) {
                    map.put("agencyId", agencyId);
                    map.put("agencyid", agencyId);
                    map.put("agent", agencyId);
                }
                logger.info("当前的参数是否是注入成功：{},注入值为：{}",map.containsKey("agencyId"),map.get("agencyId"));
            }
            else {
                logger.info("参数注入失败！");
                //退出
            }

        }

    }

    @AfterReturning(returning = "rtn", pointcut = "autoConfig()")
    public void doAfterReturning(Object rtn) throws Throwable {
        logger.debug("请求完成，反馈参数json为 : {}" ,JSON.toJSONString(rtn));
    }

    /**
     * 判定切入点
//     * @param pointcut
     * @return
     */
//    private boolean isPointcut(String pointcut){
//        Iterator<Pattern> $it = pointcuts.iterator();
//        while ($it.hasNext()){
//            boolean isMatch = $it.next().matcher(pointcut).find();
//            if (isMatch)return false;
//        }
//        return true;
//    }




//    @Autowired
//    private PowerDynamicParamsService dynamicParamsService;

    @PostConstruct
    private void init(){
        Map<String,Object> map = new HashMap<>();
//        map.put("","");
//        map.put("","");
//        map.put("","");
//        dynamicParamsService.queryList(map);
    }
}


