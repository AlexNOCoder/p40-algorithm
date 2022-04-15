package common.advanced_data_structure;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 带过期策略的LRU
 * @date 2022-04-10 23:06:56
 */
public class LRUMap<K,V> extends LinkedHashMap<K,V> {
    protected final int _maxEntries;

    public LRUMap(int maxEntries){
        this(16,maxEntries);
    }
    public LRUMap(int initialEntries,int maxEntries){
       super(initialEntries,maxEntries);
       _maxEntries = maxEntries;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest){
        return size() > _maxEntries;
    }
}
