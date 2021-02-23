package com.leetcode;

/**
 * @author: yhl
 * @DateTime: 2020/12/28 20:48
 * @Description:
 */
public class PrizeNum {

    public static void main(String[] args) {
        System.out.println();
        long toUnsignedLong = Integer.toUnsignedLong(ip2Int("255.255.255.255"));
        System.out.println(toUnsignedLong);
    }


    static int ip2Int(String ipString) {
        String[] ips = ipString.split("\\.");
        int rs = 0;
        for (int i = 0; i < ips.length; i++) {
            int temp = Integer.parseInt(ips[i]) << 8 * i;
            rs = rs | temp;
        }
        return rs;
    }
}
