package com.hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2021/4/3 23:29
 * @Description:
 */
public class FindPartnerWord {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int nums = sc.nextInt();
            List<String> strs = new ArrayList<>();
            for (int i = 0; i < nums; i++) {
                strs.add(sc.next());
            }
            // 4 abc bca cab aab abc 1
            String findStr = sc.next();
            int nTh = sc.nextInt();
            List<String> res = new ArrayList<>();
            for (String str : strs) {
                if (!str.equals(findStr) && str.length() == findStr.length()) {
                    char[] chStr = str.toCharArray();
                    char[] chFindStr = findStr.toCharArray();
                    int count = 0;
                    for (char cs : chStr) {
                        for (int i = 0; i < chFindStr.length; i++) {
                            if (cs == chFindStr[i]) {
                                chFindStr[i] = '0';
                                count++;
                                break;
                            }
                        }
                    }
                    if (chStr.length == count) {
                        res.add(str);
                    }
                }
            }
            System.out.println(res.size());
            if (nTh > 0 && nTh <= res.size()) {
                Collections.sort(res);
                System.out.println(res.get(nTh - 1));
            }


        }

    }
}
