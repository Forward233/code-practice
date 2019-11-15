package com.thread;

/**
 * @author: yhl
 * @DateTime: 2019/11/14 11:13
 * @Description:
 */
public class OneClassPrintABC {


    static int printTimes = 10;

    private static char letter = 'A';


    public static void main(String[] args) {
        OneClassPrintABC one = new OneClassPrintABC();
        one.new PrintABC(one).start();
        one.new PrintABC(one).start();
        one.new PrintABC(one).start();
    }

    public void print() {
        System.out.print(letter);
        if ('C' == letter) {
            System.out.println();
        }
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
                letter = 'A';
                break;
        }
    }

    /**
     * @return the letter
     */
    public char getLetter() {
        return letter;
    }



    class PrintABC extends Thread {

        private final OneClassPrintABC abc;

        PrintABC(OneClassPrintABC abc) {
            this.abc = abc;
        }

        @Override
        public void run() {
            for (int i = 0; i < printTimes; i++) {
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
