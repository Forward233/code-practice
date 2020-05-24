package com.structure.hash;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author: yhl
 * @DateTime: 2020/2/28 9:20
 * @Description: 不特别说明的一致性哈希算法一般都是指的带虚拟节点的算法
 * [对一致性Hash算法及java实现（转） - 琴剑书酒 - 博客园](https://www.cnblogs.com/bootdo/p/10437346.html)
 */
public class ConsistencyHash {

    /**
     * 待添加入Hash环的服务器列表
     */
    private static String[] servers = {"192.168.0.0:111", "192.168.0.1:111", "192.168.0.2:111",
            "192.168.0.3:111", "192.168.0.4:111"};


    /**
     * 15      * key表示服务器的hash值，value表示服务器的名称
     * 16
     */
    private static SortedMap<Integer, String> sortedMap = new TreeMap<>();

    /**
     * 程序初始化，将所有的服务器放入sortedMap中
     */
    static {
        for (int i = 0; i < servers.length; i++) {
            int hash = HashUtils.getHash(servers[i]);
            System.out.println("[" + servers[i] + "]加入集合中, 其Hash值为" + hash);
            sortedMap.put(hash, servers[i]);
        }
        System.out.println();
    }

    /**
     * 56      * 得到应当路由到的结点
     * 57
     */
    private static String getServer(String node) {
        // 得到带路由的结点的Hash值
        int hash = HashUtils.getHash(node);
        // 得到大于该Hash值的所有Map
        SortedMap<Integer, String> subMap = sortedMap.tailMap(hash);
        // 第一个Key就是顺时针过去离node最近的那个结点
        Integer i = subMap.firstKey();
        // 返回对应的服务器名称
        return subMap.get(i);
    }

    public static void main(String[] args) {
        String[] nodes = {"127.0.0.1:1111", "221.226.0.1:2222", "10.211.0.1:3333"};
        for (String node : nodes)
            System.out.println("[" + node + "]的hash值为" +
                    HashUtils.getHash(node) + ", 被路由到结点[" + getServer(node) + "]");

    }

}
