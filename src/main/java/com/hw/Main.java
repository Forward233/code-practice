package com.hw;

import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2020/5/31 14:19
 * @Description:
 */
public class Main {


    private static char letter = 'A';


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int nums = sc.nextInt();
            Main one = new Main();
            one.new PrintABC(one,nums).start();
            one.new PrintABC(one,nums).start();
            one.new PrintABC(one,nums).start();
            one.new PrintABC(one,nums).start();
        }

    }

    public void print() {
        System.out.print(letter);
//        if ('C' == letter) {
//            System.out.println();
//        }
    }

    public void nextLetter() {
        switch (letter) {
            case 'A':
                letter = 'B';
                break;
            case 'B':
                letter = 'C';
                break;
            case 'C':
                letter = 'D';
                break;
            case 'D':
                letter = 'A';
        }
    }

    /**
     * @return the letter
     */
    public char getLetter() {
        return letter;
    }



    class PrintABC extends Thread {

        private final Main abc;

        private int nums;

        PrintABC(Main abc, int nums) {
            this.nums = nums;
            this.abc = abc;
        }

        @Override
        public void run() {
            for (int i = 0; i < nums; i++) {
                synchronized (abc) {
                    while (letter != abc.getLetter()) {
                        try {
                            abc.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    abc.print();
                    abc.nextLetter();
                    abc.notifyAll();
                }
            }
        }
    }
}
