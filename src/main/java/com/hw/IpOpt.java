package com.hw;

import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2020/5/14 7:00
 * @Description:
 */
public class IpOpt {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String binaryIP = in.nextLine();
            String decIp = in.nextLine();
            String[] binaryIPs = binaryIP.split("\\.");
            long IP2 = Long.parseLong(decIp);
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf((IP2 >> 24) & 255)).append(".").append(String.valueOf((IP2 >> 16) & 255))
                    .append(".").append(String.valueOf((IP2 >> 8) & 255)).append(".").append(String.valueOf(IP2 & 255));
            System.out.println(Long.parseLong(binaryIPs[0]) << 24 | Long.parseLong(binaryIPs[1]) << 16 |
                    Long.parseLong(binaryIPs[2]) << 8 | Long.parseLong(binaryIPs[3]));
            System.out.println(sb.toString());
        }
    }
}
