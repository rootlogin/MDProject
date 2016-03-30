/*
 * Copyright (c) 2016.3.$today.day-$today.hour24:40:18
 */

package com.material.sdk.cache;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by liuyonglong on 16/2/24.
 */
public class CacheApi {
    /**
     * 用ConcurrentMap保存将不同数据类型的实例
     * 如果该数据类型实例不存在则创建新的实例
     */
    private static final ConcurrentMap<Class, CacheInstance> map = new ConcurrentHashMap<>();
    private static ACache aCache;

    public static <T extends Serializable> CacheInstance<T> getInstance(Class<T> type) {
        CacheInstance<T> s = map.get(type);
        if (s == null) {
            synchronized (map) {
                if ((s = map.get(type)) == null)
                    map.put(type, s = new CacheInstance<>());
            }
        }
        return s;
    }

    /**
     * 在application 对cache做初始化设置
     *
     * @param context
     * @param cacheName
     */
    public CacheApi(@NonNull Context context, @NonNull String cacheName) {
        aCache = ACache.get(context, cacheName);
    }


    /**
     * 缓存实例
     *
     * @param <T>
     */
    public static class CacheInstance<T extends Serializable> {
        private CacheInstance() {
        }

        /**
         * 保存
         *
         * @param key
         * @param e
         */
        public void save(@NonNull String key, @NonNull T e) {
            aCache.put(key, e);
        }

        /**
         * 读取
         *
         * @param key
         * @return
         */
        public T read(@NonNull String key) {
            return (T) aCache.getAsObject(key);
        }

        /**
         * 缓存大小
         *
         * @param cacheSizeNotify
         */
        public void getCacheSize(ACacheSizeNotify cacheSizeNotify) {
            aCache.getCacheSize(cacheSizeNotify);
        }

        /**
         * 清空缓存
         */
        public void clear() {
            aCache.clear();
        }

        /**
         * 删除
         *
         * @param key
         * @return
         */
        public boolean remove(@NonNull String key) {
            return aCache.remove(key);
        }

    }

    /**
     * 异步回调计算缓存大小
     */
    public interface ACacheSizeNotify {
        void cacheSize(int cacheSize);

        void cacheCount(int cacheCount);

    }

}
