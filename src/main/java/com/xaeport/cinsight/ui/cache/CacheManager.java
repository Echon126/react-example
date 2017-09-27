package com.xaeport.cinsight.ui.cache;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zwj on 2017/5/26.
 */
@Component
public class CacheManager {
    private HashMap<String, Cache> cacheMap = new HashMap();
    private int mapSize = 100;

    public CacheManager() {
        super();
    }

    private synchronized Cache getCache(String key) {
        Cache cache = this.cacheMap.get(key);
        if (this.cacheMap.containsKey(key)) {
            cache.setCount(cache.getCount() + 1);
            this.cacheMap.put(key, cache);
        }
        return cache;
    }

    private synchronized boolean hasCache(String key) {
        return this.cacheMap.containsKey(key);
    }

    public synchronized void clearAll() {
        this.cacheMap.clear();
    }


    //清除指定的缓存
    public synchronized void clearOnly(String key) {
        this.cacheMap.remove(key);
    }

    //载入缓存
    public synchronized void putCache(String key, Cache obj) {
        if (this.cacheMap.size() > this.mapSize) {
            int minCount = 1;
            String minKey = null;
            boolean isFirst = true;
            for (Map.Entry<String, Cache> entry : this.cacheMap.entrySet()) {
                if (isFirst) {
                    minCount = entry.getValue().getCount();
                }
                if (entry.getValue().getCount() < minCount) {
                    minCount = entry.getValue().getCount();
                    minKey = entry.getKey();
                }
            }
            if (minKey != null) {
                this.cacheMap.remove(minKey);
            }
        }
        this.cacheMap.put(key, obj);
    }

    //获取缓存信息
    public Cache getCacheInfo(String key) {
        if (hasCache(key)) {
            Cache cache = getCache(key);
            if (cacheExpired(cache)) {
                cache.setExpired(true);
            }
            return cache;
        } else
            return null;
    }

    public void putCacheInfo(String key, Object obj, long dt, boolean expired) {
        Cache cache = new Cache();
        cache.setKey(key);
        cache.setTimeOut(dt + System.currentTimeMillis()); //设置多久后更新缓存
        cache.setValue(obj);
        cache.setExpired(expired); //缓存默认载入时，终止状态为FALSE
        cache.setCount(1);
        this.putCache(key, cache);
    }

    public void putCacheInfo(String key, Object obj, long dt) {
        Cache cache = new Cache();
        cache.setKey(key);
        cache.setTimeOut(dt + System.currentTimeMillis());
        cache.setValue(obj);
        cache.setExpired(false);
        cache.setCount(1);
        this.putCache(key, cache);
    }

    //判断缓存是否终止
    public boolean cacheExpired(Cache cache) {
        if (null == cache) {
            return false;
        }
        long nowDt = System.currentTimeMillis();
        long cacheDt = cache.getTimeOut();
        if (cacheDt <= 0 || cacheDt < nowDt) {
            return false;
        } else {
            return true;
        }
    }

    //获取缓存中的大小
    public int getCacheSize() {
        return this.cacheMap.size();
    }
}
