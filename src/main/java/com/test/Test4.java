package com.test;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * @author: yhl
 * @DateTime: 2021/4/5 15:30
 * @Description:
 */
public class Test4 {
    public static void main(String[] args) throws IOException {

        System.out.println(
                Stream.of(2,4,6,7,9,11)
                        .reduce(Integer::sum)
                        .get());

    }
}
