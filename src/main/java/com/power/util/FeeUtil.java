package com.power.util;

import com.alibaba.fastjson.JSON;
import org.junit.Assert;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/27.
 * 费用结算工具
 */
public class FeeUtil {
    private static final double day =  24*60*60d;
//    Free time
//    Settlement 结算
    //Cap封顶
    //Price 单价
    /**
     * 计算费用
     * @param orderFreeTime 订单免费时长
     * @param dayFreeTime 日免费时长
     * @param currDayFreeTime 订单产生日剩余日免费时长
     * @param price 单价
     * @param capFee 封顶租金
     * @param currCapFee 当前封顶租金
     * @param startTime 起始时间
     * @param endTime 结束时间
     * @return
     */
    public static long[] feeSettlement(long orderFreeTime,int dayFreeTime,int currDayFreeTime,long price,long capFee,long currCapFee,long startTime,long endTime,long buffTime){
        Map<String,Object> timeSlice = timeSlice(startTime,endTime - buffTime*60);
        //单位分
        long time1 = (long)timeSlice.get("time1");
        long time3 = (long)timeSlice.get("time3");
        //单位天
        int time2 = (int)timeSlice.get("time2");
        boolean flag1 = (boolean)timeSlice.get("flag1");
        boolean flag2 = (boolean)timeSlice.get("flag2");
        boolean flag3 = (boolean)timeSlice.get("flag3");

//        Logger.debug("三个时间片段分别为:%s,%s,%s",time1,time2,time3);
        //当天免费时长 精确到分钟
        long freeTime = orderFreeTime+currDayFreeTime;
        //当前封顶时间 //计算封顶时间精确到分钟
        long capTime = (long) Math.ceil(((double)capFee/(double) price) * 60);
        //首日
        long currCapTime = (long) Math.ceil(((double)currCapFee/(double) price) * 60);
//        Logger.debug("当前所得当天免费时长为：%s",capTime);
        //当天封顶总时长 精确到分钟
        //剩余日免费时长
        long surplusDayTime = currDayFreeTime;
        //剩余日免费费用
        long surplusCapFee = currCapFee;
        //剩余免费时长
        long surplusOrderTime = orderFreeTime;


        ///////////////////计算第一天所有费用////////////////////////////

        long tmpFee1 = (long) Math.ceil((time1 - freeTime)/60d) * price;


        long fee1 =
                time1 > surplusOrderTime ?
                        time1 - surplusOrderTime > surplusDayTime ?
                                Math.ceil(time1 - surplusOrderTime - surplusDayTime) > Math.ceil(currCapTime) ?
                                        surplusCapFee : tmpFee1 < 0 ?
                                        0 :
                                        tmpFee1 > surplusCapFee ? surplusCapFee : tmpFee1 :
                                0 :
                        0;
        ///////////////////计算第一天所有费用////////////////////////////

        ///////////////////计算第一天剩余免费时间////////////////////////////
        //如果计费时间大于订单免费时长  扣除完全 //时间梯度计算  time> 剩余订单免费时长
        surplusOrderTime = time1 - surplusOrderTime >0 ? 0 : surplusOrderTime - time1;

        //订单第一天免费时长结算  剩余免费时长计算   //梯度计算
        surplusDayTime = time1>orderFreeTime? (time1>surplusDayTime + orderFreeTime ? 0 : surplusDayTime+orderFreeTime-time1) : surplusDayTime ;
        ///////////////////计算第一天剩余免费时间////////////////////////////
        ////////////////////////第一天封顶费用////////////////////////////////
        surplusCapFee = surplusCapFee - fee1<0?0:surplusCapFee - fee1;


//        long fee1 = time1> totalCapTime ? capFee : (tmpFee1 <0 ? 0:tmpFee1);
        //第一天费用为0的情况下 计算剩余时间
//        if (fee1==0){
//            surplusDayTime = freeTime - time1;
//        }
        //计算中间天所有费用
        long fee2 = time2 * capFee;
        //surplusDayTime  跨天重置
        if (flag1||time2>0) {
            surplusDayTime = dayFreeTime;
            surplusCapFee = capFee;
        }
        //假如第二天天数不为0  将剩余日免费时长
        surplusDayTime = time2>0 ? 0:surplusDayTime;
        //假如第二天天数不为0  计算剩余订单免费时长
        surplusOrderTime = time2>0 ? (surplusOrderTime-time2*24*60>0?surplusOrderTime-time2*24*60:0):surplusOrderTime;

        //跨天重置
        if (flag2||time3>0) {
            surplusDayTime = dayFreeTime;
            surplusCapFee = capFee;
        }
        //计算最终天所有费用
        long tmpFee3 =(long) Math.ceil((time3 - surplusDayTime)/60d) * price;
        //如果第二天为0  计算时需考虑剩余订单免费时长不为0的情况 梯度计算
                        //订单免费阶段
        long fee3 = time3>surplusOrderTime?(time3>(surplusOrderTime+surplusDayTime)?((Math.ceil(time3-surplusOrderTime-dayFreeTime)>Math.ceil(capTime)?surplusCapFee:(tmpFee3<0?0:tmpFee3))):0):0;
//        long fee3 = time3>surplusOrderTime?(time3>(surplusOrderTime+dayFreeTime)?(time3>(surplusOrderTime+dayFreeTime+capTime)?capFee:(tmpFee3<0?0:tmpFee3)):0):0;
//        long fee3 = time3> capTime ? capFee : (tmpFee3<0?0:tmpFee3);
        //最后一天费用为0 计算剩余时间 假如跨天覆盖第一天剩余时间
            //跨天考虑订单免费时长不为0的情况 费用3为0的情况下  两种情况 1、time3小于剩余订单免费时长  2  time3小于剩余日免费时长+剩余订单免费时长
        surplusDayTime = time3>surplusOrderTime?(time3>surplusDayTime?0:surplusDayTime-time3):surplusDayTime;
        fee3 = fee3>capFee?capFee:fee3;
        surplusCapFee = surplusCapFee - fee3<0?0:surplusCapFee - fee3;
        if (flag3) {
            surplusDayTime = dayFreeTime;
            surplusCapFee = capFee;
        }
        //最终确认费用 单位 分
        long totalFee = fee1 + fee2 +fee3;
        return new long[]{totalFee,surplusDayTime,surplusCapFee<0?0:surplusCapFee};
    }

    private static Map<String,Object> timeSlice(long startTime, long endTime) {
        Map<String,Object> rtnMap = new HashMap<>();
        long time1 = 0;
        //起始时间的0时
        long nextTime = timeOffset(startTime);

        rtnMap.put("nextTime",nextTime);
        if (endTime < nextTime){
            //当前情况为第一天借还
            //单位分
            time1 = (long)Math.ceil((endTime-startTime)/60d);
            rtnMap.put("time1",time1);
            //时间1的结束点是不是整点
            rtnMap.put("time2",0);
            rtnMap.put("time3",0L);
            rtnMap.put("flag1",(endTime-8*60*60)%day==0);
            rtnMap.put("flag2",false);
            rtnMap.put("flag3",false);

            return rtnMap;
        }
        //时间片1为 借时间到当天晚上23:59:59
        time1 = (long)Math.ceil((nextTime-startTime)/60d);
        //结束时间的0时
        long lastTime = timeOffset(endTime) - 24*60*60;
        int time2 = (int) ((lastTime - nextTime)/day);

        long time3 = (long)Math.ceil((endTime-lastTime)/60d);

        //设置当前年月日时间的0:0:0
        rtnMap.put("time1",time1);
        rtnMap.put("time2",time2<0?0:time2);
        rtnMap.put("time3",time3);
        rtnMap.put("flag1",!(time2>0));
        rtnMap.put("flag2",time2>0&&(!(time3>0)));
        rtnMap.put("flag3",(endTime-8*60*60)%day==0);

        return rtnMap;
    }

    /**
     * 时间偏移运算
     * @param time
     * @return
     */
    public static long timeOffset(long time){
        //东八区偏移量
        long tmpStartTime = time + 8*60*60+1;
        //起始时间的0时
        long nextTime = ((long)Math.ceil(tmpStartTime/day))*(24*60*60);
        //东八区偏移量
        nextTime -= 8 * 60 *60;
        return nextTime;
    }


    public static long[] feeSettlement24(long orderFreeTime, int dayFreeTime, int currFreeTime, long fee, long cap,long currCapFee, long start, long end, long buffTime){
        long next = FeeUtil.timeOffset(start);
        //结束时间+偏移量
        long last = (next-start) + end;
        long[] rtnFee = FeeUtil.feeSettlement(
                orderFreeTime,
                dayFreeTime,
                currFreeTime,
                fee,
                cap,
                currCapFee,
                next, last,buffTime);
        return rtnFee;
    }


}
