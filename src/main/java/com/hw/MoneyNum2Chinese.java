package com.hw;

import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2021/4/4 21:39
 * @Description:
 */
public class MoneyNum2Chinese {

    private static String[] chiNum = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    private static String[] chiUnit = {null, "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            String zs;
            String xs = null;
            if (str.contains(".")) {
                String[] s = str.split("\\.");
                zs = s[0];
                xs = s[1];
            } else {
                zs = str;
            }
            String res = format(zs);
            StringBuilder sb = new StringBuilder(res);
            if (!"人民币".equals(res)) {
                sb.append("元");
            }
            if (xs == null || "00".equals(xs))
                sb.append("整");
            else {
                int jn = Integer.parseInt(String.valueOf(xs.charAt(0)));
                if (jn != 0) {
                    sb.append(chiNum[jn]);
                    sb.append("角");
                }
                int fn = Integer.parseInt(String.valueOf(xs.charAt(1)));
                if (fn != 0) {
                    sb.append(chiNum[fn]);
                    sb.append("分");
                }
            }
            System.out.println(sb.toString());
        }
    }

    public static String format(String zs) {
        StringBuilder sb = new StringBuilder("人民币");
        if ("0".equals(zs)) {
            return sb.toString();
        }
        boolean has0 = false;
        for (int i = 0; i < zs.length(); i++) {
            int unitIndex = zs.length() - i - 1;
            int n = Integer.parseInt(String.valueOf(zs.charAt(i)));
            switch (n) {
                case 0:
                    if (!has0 && unitIndex != 4) {
                        sb.append(chiNum[0]);
                        has0 = true;
                    }
                    break;
                case 1:
                    if (!"拾".equals(chiUnit[unitIndex])) {
                        sb.append(chiNum[1]);
                    }
                    has0 = false;
                    break;
                default:
                    sb.append(chiNum[n]);
                    has0 = false;
                    break;
            }
            if (chiUnit[unitIndex] != null) {
                if (!has0)
                    sb.append(chiUnit[unitIndex]);
            }
        }
        if (sb.charAt(sb.length() - 1) == '零') {
            return sb.substring(0, sb.length() - 1);
        } else {
            return sb.toString();
        }
    }
}
