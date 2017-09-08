package com.test.boot.sms;

/**
 * Created by Administrator on 2017/9/8.
 */
public class Test {
    public static void main(String[] args) {
        for (int i = 10200; i < 10500; i++) {
            System.out.printf("A%07X\n",i);//按16进制输出
        }
    }

}
