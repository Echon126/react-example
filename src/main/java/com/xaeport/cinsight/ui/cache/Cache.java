package com.xaeport.cinsight.ui.cache;

/**
 * Created by Administrator on 2017/5/26.
 */
public class Cache {
    private String key;//缓存ID
    private Object value;//缓存数据
    private long timeOut;//更新时间
    private boolean expired; //是否终止
    private int count = 1;

    public Cache() {
        super();
    }

    public Cache(String key, Object value, long timeOut, boolean expired, int count) {
        this.key = key;
        this.value = value;
        this.timeOut = timeOut;
        this.expired = expired;
        this.count = count;
    }

    public String getKey() {
        return key;
    }

    public long getTimeOut() {
        return timeOut;
    }

    public Object getValue() {
        return value;
    }

    public void setKey(String string) {
        key = string;
    }

    public void setTimeOut(long l) {
        timeOut = l;
    }

    public void setValue(Object object) {
        value = object;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean b) {
        expired = b;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
