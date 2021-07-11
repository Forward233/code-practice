package com.test;

import java.util.*;

/**
 * @author: yhl
 * @DateTime: 2021/4/5 14:26
 * @Description:
 */
public class Test2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> legalSet = new HashSet<>();
        List<String> illegalStr = new ArrayList<>();
        List<String> leftMove = new ArrayList<>();
        while (sc.hasNextLine()) {
            String str = sc.next();
            boolean flag = true;
            for (int j = 0; j < str.length(); j++) {
                if (!Character.isLetterOrDigit(str.charAt(j))) {
                    flag = false;
                }
            }
            if (flag) {
                legalSet.add(str);
                // 左移
                leftMove.add(getLeftMoveStr(str));
            } else {
                illegalStr.add(str);
            }
            legalSet.forEach(a -> System.out.print(a + " "));
            System.out.println();
            illegalStr.forEach(a -> System.out.print(a + " "));
            System.out.println();
            Collections.sort(leftMove);
            leftMove.forEach(a -> System.out.print(a + " "));
        }

    }

//    abc def acd123 44234tjg abd 123 abcdef 123456789012345678901234567890123456789012345678901234567890123 EDFG SDFG ABC DEF cccc dd asdfas 234abc35 765rgfh4sd 1231
//            == aga'-= ad--s a*b=1 87&&^ ==
//    bca efd 23acd1 234tjg44 bda 231 efabcd 123456789012345678901234567890123456789012345678901231234567890 FGED FGSD BCA EFD cccc dd asasdf 4abc3523 765rgfh4sd 3112
//            123456789012345678901234567890123456789012345678901231234567890 231 234tjg44 23acd1 3112 4abc3523 765rgfh4sd BCA EFD FGED FGSD asasdf bca bda cccc dd efabcd efd


    private static String getLeftMoveStr(String s) {
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
        return new String(chars);
    }
}
