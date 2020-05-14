package com.hw;

import java.util.*;

/**
 * @author: yhl
 * @DateTime: 2020/5/15 7:12
 * @Description:
 */
public class Record {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> recordMap = new LinkedHashMap<>();
        while (in.hasNext()) {
            String fullFilePath = in.next();
            int line = in.nextInt();
            String fileName = fullFilePath.substring(fullFilePath.lastIndexOf("\\") + 1);
            if (fileName.length() > 16) {
                fileName = fileName.substring(fileName.length() - 16);
            }
            String key = fileName + " " + line;
            if (recordMap.containsKey(key)) {
                recordMap.put(key+"", recordMap.get(key) + 1);
            } else {
                recordMap.put(key, 1);
            }
        }

        int count = 0;
        Set<Map.Entry<String, Integer>> entries = recordMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            count++;
            if (count > (entries.size() - 8)) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }

}
