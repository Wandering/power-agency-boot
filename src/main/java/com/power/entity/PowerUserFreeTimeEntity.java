package com.power.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.alibaba.fastjson.JSON;



/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-19 19:26:00
 */
public class PowerUserFreeTimeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    private Long id;

    /**
     * 订单生成时候的免费时长余量
     */
    @Column(name = "temp_day_free_time")
    private String tempDayFreeTime;
    @Transient
    private Map<Long,Integer> tempDayFreeTimeMap;

    /**
     * 订单生成时候的会员等级{1,1}
     */
    @Column(name = "temp_model_lv")
    private String tempModelLv;
    @Transient
    private Map<Long,Long> tempModelLvMap;

    /**
     * 当前日期的免费时长余量
     */
    @Column(name = "curr_day_free_time")
    private Integer currDayFreeTime;

    /**
     * 当前日期的封顶费用余量
     */
    @Column(name = "curr_day_free_fee")
    private Long currDayFreeFee;


    /**
     * 订单生成时候的免费时长余量
     */
    @Column(name = "temp_day_free_fee")
    private String tempDayFreeFee;
    @Transient
    private Map<Long,Long> tempDayFreeFeeMap;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTempDayFreeTime() {
        return tempDayFreeTime;
    }

    public void setTempDayFreeTime(String tempDayFreeTime) {
        this.tempDayFreeTime = tempDayFreeTime;
    }

    public Map<Long, Integer> getTempDayFreeTimeMap() {
        genTempDayFreeTimeMap();
        return this.tempDayFreeTimeMap;
    }

    public void setTempDayFreeTimeMap(Map<Long, Integer> tempDayFreeTimeMap) {
        this.tempDayFreeTimeMap = tempDayFreeTimeMap;
        this.tempDayFreeTime = JSON.toJSONString(tempDayFreeTimeMap);
    }
    public void putTempDayFreeTimeMap(Long key,Integer value) {
        genTempDayFreeTimeMap();
        this.tempDayFreeTimeMap.put(key,value);
        this.tempDayFreeTime = JSON.toJSONString(tempDayFreeTimeMap);
    }
    public void rmTempDayFreeTimeMap(Long key) {
        genTempDayFreeTimeMap();
        tempDayFreeTimeMap.remove(key);
        this.tempDayFreeTime = JSON.toJSONString(tempDayFreeTimeMap);
    }
    public String getTempModelLv() {
        return tempModelLv;
    }

    public void setTempModelLv(String tempModelLv) {
        this.tempModelLv = tempModelLv;
    }

    public Map<Long, Long> getTempModelLvMap() {
        genTempModelLvMaMap();
        return this.tempModelLvMap;
    }

    public void setTempModelLvMap(Map<Long,Long> tempModelLvMap) {
        this.tempModelLvMap = tempModelLvMap;
        this.tempModelLv = JSON.toJSONString(tempModelLvMap);
    }
    public void putTempModelLvMap(Long key,Long value) {
        genTempModelLvMaMap();
        this.tempModelLvMap.put(key,value);
        this.tempModelLv = JSON.toJSONString(tempModelLvMap);
    }
    public void rmTempModelLvMap(Long key) {
        genTempModelLvMaMap();
        this.tempModelLvMap.remove(key);
        this.tempModelLv = JSON.toJSONString(tempModelLvMap);
    }
    public Integer getCurrDayFreeTime() {
        return currDayFreeTime;
    }

    public void setCurrDayFreeTime(Integer currDayFreeTime) {
        this.currDayFreeTime = currDayFreeTime;
    }

    private void genTempModelLvMaMap(){
        if (this.tempModelLvMap==null) {
            Map<Long,Long> temp = (Map<Long,Long>)JSON.parseObject(tempModelLv, HashMap.class);
            this.tempModelLvMap = new HashMap();
            for (Map.Entry map :  temp.entrySet()){
                this.tempModelLvMap.put(Long.valueOf(map.getKey().toString()),Long.valueOf(map.getValue().toString()));
            }
        }
    }

    private void genTempDayFreeTimeMap(){
        if (this.tempDayFreeTimeMap == null){
            this.tempDayFreeTimeMap = new HashMap<>();
            Map<Long,Integer> temp = (Map<Long,Integer>)JSON.parseObject(tempDayFreeTime, HashMap.class);
            for (Map.Entry map :  temp.entrySet()){
                this.tempDayFreeTimeMap.put(Long.valueOf(map.getKey().toString()),Integer.valueOf(map.getValue().toString()));
            }
        }
    }


    public Long getCurrDayFreeFee() {
        return currDayFreeFee;
    }

    public void setCurrDayFreeFee(Long currDayFreeFee) {
        this.currDayFreeFee = currDayFreeFee;
    }

    public String getTempDayFreeFee() {
        genTempDayFreeFeeMap();
        return tempDayFreeFee;
    }

    public void setTempDayFreeFee(String tempDayFreeFee) {
        this.tempDayFreeFee = tempDayFreeFee;
    }

    public Map<Long, Long> getTempDayFreeFeeMap() {
        genTempDayFreeFeeMap();
        return tempDayFreeFeeMap;
    }

    public void setTempDayFreeFeeMap(Map<Long, Long> tempDayFreeFeeMap) {
        this.tempDayFreeFeeMap = tempDayFreeFeeMap;
        this.tempDayFreeFee = JSON.toJSONString(tempDayFreeFeeMap);
    }

    private void genTempDayFreeFeeMap(){
        if (this.tempDayFreeFeeMap == null){
            this.tempDayFreeFeeMap = new HashMap<>();
            Map<Long,Integer> temp = (Map<Long,Integer>)JSON.parseObject(tempDayFreeFee, HashMap.class);
            for (Map.Entry map :  temp.entrySet()){
                this.tempDayFreeFeeMap.put(Long.valueOf(map.getKey().toString()),Long.valueOf(map.getValue().toString()));
            }
        }
    }

    public void putTempDayFreeFeeMap(Long key,Long value) {
        genTempDayFreeFeeMap();
        this.tempDayFreeFeeMap.put(key,value);
        this.tempDayFreeFee = JSON.toJSONString(tempDayFreeFeeMap);
    }
    public void rmTempDayFreeFeeMap(Long key) {
        genTempDayFreeFeeMap();
        this.tempDayFreeFeeMap.remove(key);
        this.tempDayFreeFee = JSON.toJSONString(tempDayFreeFeeMap);
    }
}
