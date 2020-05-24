package com.structure.hash;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;

/**
 * @author: yhl
 * @DateTime: 2020/2/28 9:20
 * @Description: 不特别说明的一致性哈希算法一般都是指的带虚拟节点的算法
 */
public class ConsistencyHashWithVirtual {

    /**
     * 待添加入Hash环的服务器列表
     */
    private static String[] servers = {"192.168.0.0:111", "192.168.0.1:111", "192.168.0.2:111",
            "192.168.0.3:111", "192.168.0.4:111"};

    private static List<String> realNodes = Lists.newLinkedList();

    private static SortedMap<Integer, String> virtualNodes = Maps.newTreeMap();

    private static final int VIRTUAL_NODES = 5;

    static {
        Collections.addAll(realNodes, servers);
        for (String realNode : realNodes) {
            for (int i = 0; i < VIRTUAL_NODES; i++) {
                String virtualNodeName = realNode + "&&" + i;
                int nodeHash = HashUtils.getHash(virtualNodeName);
                virtualNodes.put(nodeHash, virtualNodeName);
                System.out.println("虚拟节点[" + virtualNodeName + "]被添加, hash值为" + nodeHash);
            }
        }
        System.out.println("虚拟hash环：" + virtualNodes);
    }

    private static String getServer(String node) {
        int nodeHash = HashUtils.getHash(node);
        final SortedMap<Integer, String> tailMap = virtualNodes.tailMap(nodeHash);
        final Integer firstKey = tailMap.firstKey();
        final String virtualNode = tailMap.get(firstKey);
        return virtualNode.substring(0, virtualNode.length() - 3);
    }


    public static void main(String[] args) {
        String[] nodes = {"127.0.0.1:1111", "221.226.0.1:2222", "10.211.0.1:3333"};
        for (String node : nodes)
            System.out.println("[" + node + "]的hash值为" +
                    HashUtils.getHash(node) + ", 被路由到结点[" + getServer(node) + "]");


        List<String> arrayList = Collections.synchronizedList(new ArrayList<>());

    }


}
