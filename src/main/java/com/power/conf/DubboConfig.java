//package com.power.conf;
//
//import com.alibaba.dubbo.config.ApplicationConfig;
//import com.alibaba.dubbo.config.RegistryConfig;
//import com.alibaba.dubbo.config.spring.AnnotationBean;
//import com.power.cloud.spring.ZookeeperConfigurer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.EnvironmentAware;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
//import org.springframework.core.env.Environment;
//import org.springframework.web.context.support.StandardServletEnvironment;
//
///**
// * Created by Administrator on 2017/7/22.
// */
//@AutoConfigureAfter(ZookeeperConfigurer.class)
//@EnableAutoConfiguration
//@Configuration
//public class DubboConfig {
//    public static final String APPLICATION_NAME = "-agency-boot-consumer";
//    @Value("${dubbo.zk.url:mc.zk.power.com}")
//    public String url;
//
//    public static final String ANNOTATION_PACKAGE = "com.power.yuneng.nonparty.api.IPowerConsumer";
//
//    @Bean
//    public ApplicationConfig applicationConfig() {
//        ApplicationConfig applicationConfig = new ApplicationConfig();
//        applicationConfig.setName(APPLICATION_NAME);
//        return applicationConfig;
//    }
//
//    @Bean
//    public RegistryConfig registryConfig() {
//        RegistryConfig registryConfig = new RegistryConfig();
//        registryConfig.setAddress(url);
//        return registryConfig;
//    }
//
//    @Bean
//    public AnnotationBean annotationBean() {
//        AnnotationBean annotationBean = new AnnotationBean();
//        annotationBean.setPackage(ANNOTATION_PACKAGE);
//        return annotationBean;
//    }
//
////    @Override
////    public void setEnvironment(Environment environment) {
////        ((StandardServletEnvironment)environment).initPropertySources();
////    }
//}
