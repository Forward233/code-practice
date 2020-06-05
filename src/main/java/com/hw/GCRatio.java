package com.hw;

import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2020/5/27 23:41
 * @Description:
 */
public class GCRatio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String dna = sc.next();
            int len = sc.nextInt();
            int maxCount = 0;
            int maxIndex = 0;
            for (int i = 0; i < dna.length() - len; i++) {
                int count = 0;
                for (int j = i; j < i + len; j++) {
                    if (dna.charAt(j) == 'G' || dna.charAt(j) == 'C') {
                        count++;
                    }
                }

                if (count > maxCount) {
                    maxCount = count;
                    maxIndex = i;
                }
            }
            System.out.println(dna.substring(maxIndex, maxIndex + len));
        }
    }
}
