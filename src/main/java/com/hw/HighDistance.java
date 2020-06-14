package com.hw;

import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2020/5/30 17:19
 * @Description:
 */
public class HighDistance {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            float meter = sc.nextFloat()/2;
            float sum = meter;
            for(int i = 0;i<4;i++){
                sum += 2 * getHighDistance(meter);
                meter =  meter/2;
            }
            System.out.println(sum);
            System.out.printf("%.5f",meter);
        }
    }
    public static float getHighDistance(float num){
        return num/2;
    }
}
