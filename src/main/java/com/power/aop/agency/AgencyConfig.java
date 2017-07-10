package com.power.aop.agency;

import com.google.common.collect.Lists;
import com.power.entity.AgenciesEntity;
import org.apache.commons.lang.ArrayUtils;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/7/8.
 */

public class AgencyConfig {



    private  static List<MapConfig> mapAopConfigs = Lists.newArrayList();
    private static List<EntityConfig> entityConfigs = Lists.newArrayList();

    static {
        //init
        mapAopConfigs.add(new MapConfig("^* com.power.service.*.*.queryList(..)","agencyId",0));
//        entityConfigs.add(new EntityConfig("^* com.power.service.*.*.add(..)","agencyId",0,AgenciesEntity.class));
    }

    /**
     * 写入agencyId
     * @param pointcut
     * @param value
     * @param args
     */
    public static void write(String pointcut,String value,Object[] args){
        for (MapConfig mapConfig :mapAopConfigs){
            if (pointcut.matches(mapConfig.getRegex())){
                Object object = args[mapConfig.getIndex()];
                if (ArrayUtils.toString(object.getClass().getInterfaces()).startsWith("java.util.Map")){
                    Map map = (Map)object;
                    map.put(mapConfig.getField(),value);
                    return;
                }
            }
        }
        for (EntityConfig entityConfig : entityConfigs){
            if (Pattern.matches(entityConfig.getRegex(),pointcut)){
                Object object = args[entityConfig.getIndex()];
                if (object.getClass() == entityConfig.getClazz()){
                    Field field = ReflectionUtils.findField(entityConfig.getClazz(),entityConfig.getField());
                    if (field != null){
                        try {
                            field.set(object,value);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        return;
                    }
                }
            }
        }
    }


    public static class Config{
        /**正则**/
        private String regex;
        /**属性**/
        private String field;

        public Config(String regex, String field) {
            this.regex = regex;
            this.field = field;
        }

        public String getRegex() {
            return regex;
        }

        public void setRegex(String regex) {
            this.regex = regex;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

    }

    public static class MapConfig extends Config{

        /**第几个参数**/
        private int index;

        public MapConfig(String regex, String field, int index) {
            super(regex, field);
            this.index = index;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    public static class EntityConfig extends MapConfig{
        /**类名**/
        private Class clazz;

        public EntityConfig(String regex, String field, int index, Class clazz) {
            super(regex, field, index);
            this.clazz = clazz;
        }

        public Class getClazz() {
            return clazz;
        }

        public void setClazz(Class clazz) {
            this.clazz = clazz;
        }

    }


    public static void main(String[] args) {
        String s = "List com.power.service.impl.StationErrorLogServiceImpl.queryList(Map)";
        String regex = "^* com.power.service.*.*.queryList(..)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        System.out.println(matcher.find());
    }
}
