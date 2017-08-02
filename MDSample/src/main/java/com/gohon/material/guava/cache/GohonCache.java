package com.gohon.material.guava.cache;

import android.view.View;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import org.antlr.v4.misc.Graph;

import java.util.concurrent.TimeUnit;

/**
 * Created by liuyonglong on 16/6/1.
 */

public class GohonCache {

    private void init() {
        LoadingCache<Key, Graph> graphs = CacheBuilder.newBuilder()
                .maximumSize(10000)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .removalListener(new RemovalListener<Key, Graph>() {
                    @Override
                    public void onRemoval(RemovalNotification<Key, Graph> removalNotification) {

                    }
                })
                .build(
                        new CacheLoader<Key, Graph>() {
                            public Graph load(Key key) throws Exception {
                                return createExpensiveGraph(key);
                            }


                        });
    }

    private Graph createExpensiveGraph(Key key) {


        return null;
    }
}
