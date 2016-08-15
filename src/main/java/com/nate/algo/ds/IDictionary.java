package com.nate.algo.ds;

public interface IDictionary<K, V> {

    void clear();
    V get(K key);
    void put(K key, V value);
    void remove(K key);
    int size();
    boolean empty();
}
