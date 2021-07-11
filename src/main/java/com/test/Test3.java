package com.test;

/**
 * @author: yhl
 * @DateTime: 2021/4/5 14:43
 * @Description:
 */
public class Test3 {

    public static void main(String[] args) {
        String s = "def";
        // dabc
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i <= 10; i++) {
            char temp = chars[0];
            for (int j = 1; j < length; j++) {
                if (j == length - 1) {
                    chars[0] = chars[j];
                    chars[j] = temp;
                    break;
                }
                char c = chars[j];
                chars[j] = temp;
                temp = c;

            }
        }
        System.out.println(new String(chars));
    }
}
