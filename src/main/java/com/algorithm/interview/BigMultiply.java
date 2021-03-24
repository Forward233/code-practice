package com.algorithm.interview;

/**
 * @author: yhl
 * @DateTime: 2021/1/15 9:46
 * @Description:
 */
public class BigMultiply {

    public static void main(String[] args) {
        System.out.println(bigMultiply("12", "123"));
    }

    public static String bigMultiply(String num1, String num2) {
        // 转换成char数组
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int[] result = new int[chars1.length + chars2.length];
        int[] n1 = new int[chars1.length];
        int[] n2 = new int[chars2.length];
        // char转换为 int
        for (int i = 0; i < chars1.length; i++) {
            n1[i] = chars1[i] - '0';
        }
        for (int i = 0; i < chars2.length; i++) {
            n2[i] = chars2[i] - '0';
        }

        /**
         *      1 2 3
         *        1 2
         *     ------
         *      2 4 6
         *    1 2 3
         *   --------
         */

        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                result[i + j] += n1[i] * n2[j];
            }
        }
        for (int i = result.length - 1; i > 0; i--) {
            if (result[i] > 9) {
                result[i - 1] += result[i] / 10;
                result[i] = result[i] % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length - 1; i++) {
            if (result[i] != 0 || sb.length() > 0) {
                sb.append(result[i]);
            }

        }
        return sb.length() > 0 ? sb.toString() : "0";
    }
}
