package com.structure.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: yhl
 * @DateTime: 2021/3/15 13:50
 * @Description:
 */
public class LRUCache {

    private LinkedHashMap<Integer, Integer> cache;
    public int capacitySize;

    public LRUCache(int capacity) {
        this.capacitySize = capacity;
        cache = new LinkedHashMap(16,0.75f,true){
            private static final long serialVersionUID = 4498647962678969965L;

            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return cache.size() > capacitySize;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
