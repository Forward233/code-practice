package com.hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2020/5/30 20:49
 * @Description:
 */
public class MP3Player {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int nums = sc.nextInt();
            String opt = sc.next();
            int nowSing = 1;
            int[] step = new int[opt.length()];
            int flag = 0;
            for (int i = 0; i < opt.length(); i++) {
                if (opt.charAt(i) == 'U') {
                    if (nowSing == 1) {
                        nowSing = nums;
                        flag = 1;
                    } else {
                        nowSing--;
                    }
                }
                if (opt.charAt(i) == 'D') {
                    if (nowSing == nums) {
                        nowSing = 1;
                        flag = 2;
                    } else {
                        nowSing++;
                    }
                }
                step[i] = nowSing;
            }

//            System.out.println(Arrays.toString(step));
            List<Integer> list = new ArrayList<>();
            for (int i = step.length - 1; i >= 0; i--) {
                if (list.size() == 4) {
                    break;
                }
                if (list.contains(step[i])) {
                    continue;
                }
                list.add(step[i]);
            }

            boolean isContais = list.contains(1) && list.contains(nums);

            if (isContais && list.indexOf(1) < list.indexOf(nums) && nums > 4) {
                System.out.print("1 2 3 4");
            } else if (isContais && list.indexOf(1) > list.indexOf(nums)) {
                System.out.print((nums - 3) + " " + (nums - 2) + " " + (nums - 1) + " " + nums);
            } else {
                Collections.sort(list);
                for (Integer integer : list) {
                    System.out.print(integer + " ");
                }
            }
            System.out.println("");
            System.out.println(nowSing);
        }
    }
}
