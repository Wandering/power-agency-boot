package com.power.aop.agency;

import com.google.common.collect.Lists;

import org.apache.commons.lang.ArrayUtils;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/7/8.
 */

public class AgencyConfig {



    private  static List<MapConfig> mapAopConfigs = Lists.newArrayList();
    private static List<EntityConfig> entityConfigs = Lists.newArrayList();

    static {
        //init
    	   mapAopConfigs.add(new MapConfig("^* com.power.service.*.*.queryTotal(..)","authAgencyId",0));
    	   mapAopConfigs.add(new MapConfig("^* com.power.service.*.*.queryList(..)","authAgencyId",0));
    	   mapAopConfigs.add(new MapConfig("^* io.renren.service.*.*.queryTotal(..)","authAgencyId",0));
    	   mapAopConfigs.add(new MapConfig("^* io.renren.service.*.*.queryList(..)","authAgencyId",0));
//           mapAopConfigs.add(new MapConfig("^* com.power.service.ex.impl.OrderLineServiceImpl.queryList(..) ","agency",0));
//
//           mapAopConfigs.add(new MapConfig("^* com.power.service.impl.OrdersServiceImpl.queryList(..) ","agency",0));
//
//           mapAopConfigs.add(new MapConfig("^* com.power.service.impl.PowerBankServiceImpl.queryList(..) ","agency",0));
//           entityConfigs.add(new EntityConfig("^* com.power.service.impl.PowerBankServiceImpl.save(..) ","agency",0,PowerBankEntity.class));
//           entityConfigs.add(new EntityConfig("^* com.power.service.impl.PowerBankServiceImpl.delete(..) ","agency",0,PowerBankEntity.class));
//           entityConfigs.add(new EntityConfig("^* com.power.service.impl.PowerBankServiceImpl.update(..) ","agency",0,PowerBankEntity.class));
//
//           mapAopConfigs.add(new MapConfig("^* com.power.service.impl.PowerStationBaseServiceImpl.queryList(..) ","agencyId",0));
//
//           entityConfigs.add(new EntityConfig("^* com.power.service.impl.PowerStationBaseServiceImpl.save(..) ","agencyId",0,PowerStationBaseEntity.class));
//           entityConfigs.add(new EntityConfig("^* com.power.service.impl.PowerStationBaseServiceImpl.delete(..) ","agencyId",0,PowerStationBaseEntity.class));
//           entityConfigs.add(new EntityConfig("^* com.power.service.impl.PowerStationBaseServiceImpl.update(..) ","agencyId",0,PowerStationBaseEntity.class));
//
//           mapAopConfigs.add(new MapConfig("^* com.power.service.impl.PowerStationServiceImpl.queryList(..) ","agent",0));
//           entityConfigs.add(new EntityConfig("^* com.power.service.impl.PowerStationServiceImpl.save(..) ","agent",0,PowerStationEntity.class));
//           entityConfigs.add(new EntityConfig("^* com.power.service.impl.PowerStationServiceImpl.delete(..) ","agent",0,PowerStationEntity.class));
//           entityConfigs.add(new EntityConfig("^* com.power.service.impl.PowerStationServiceImpl.update(..) ","agent",0,PowerStationEntity.class));
//
    }

    /**
     * 写入agencyId
     * @param pointcut
     * @param value
     * @param args
     */
    public static void write(String pointcut,String value,Object[] args){
        for (MapConfig mapConfig :mapAopConfigs){
            if (Pattern.compile(mapConfig.getRegex()).matcher(pointcut).find()){
                Object object = args[mapConfig.getIndex()];
                if (ArrayUtils.toString(object.getClass().getSuperclass().getInterfaces()).contains("Map")){
                    Map map = (Map)object;
                    map.put(mapConfig.getField(),value);
                    return;
                }
            }
        }
        for (EntityConfig entityConfig : entityConfigs){
            if (Pattern.compile(entityConfig.getRegex()).matcher(pointcut).find()){
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
        String s = "List com.power.service.ex.impl.StationErrorLogServiceImpl.queryList(Map)";
        String regex = "^* com.power.service.*.*.queryList(..)";
        System.out.println(Pattern.compile(regex).matcher(s).find());
        System.out.println(s.matches(regex));
    }
}
