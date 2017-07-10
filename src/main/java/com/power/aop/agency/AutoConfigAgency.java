package com.power.aop.agency;

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
import org.springframework.util.ReflectionUtils;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Created by Administrator on 2017/6/23.
 * 自动注入项目agencyId
 */
@Aspect
@Component
public class AutoConfigAgency {

    private final static Logger logger = LoggerFactory.getLogger(AutoConfigAgency.class);

    @Pointcut("execution(* com.power.service..*.*(..))")
    public void autoConfig(){}


    @Before("autoConfig()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()){
            logger.debug("用户未登录，跳出切入点！");
            return;
        }
        String pointcut = joinPoint.getSignature().toString();
        logger.debug("当前切入方法为:{}",pointcut);
        Object[] args = joinPoint.getArgs();

        SysUserEntity userEntity = (SysUserEntity)subject.getPrincipal();
        Integer agencyId = userEntity.getAgencyId();

        //0为超级管理员
        if (agencyId ==0){
            AgencyConfig.write(pointcut,agencyId.toString(),args);
        }
    }

}




