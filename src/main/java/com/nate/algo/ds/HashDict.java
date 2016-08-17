package com.nate.algo.ds;

import com.nate.algo.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class HashDict<K, V> implements IDictionary<K, V> {

    private Object[] table;  // use unchecked casting
    private int tableSize;
    private int size;

    public HashDict() {
        tableSize = DEFAULT_TABLE_SIZE;
        initTable();
    }

    public HashDict(int tableSize) {
        this.tableSize = tableSize;
        initTable();
    }

    private void initTable() {
        table = new Object[tableSize];
        size = 0;

        for (int i = 0; i < table.length; i++) {
            table[i] = new ArrayList<Entry<K, V>>();
        }
    }

    public void clear() {
        initTable();
    }

    public V get(K key) {
        Entry<K, V> entry = getEntry(key);
        return (entry == null) ? null : entry.value;
    }

    public void put(K key, V value) {
        Entry<K, V> entry = getEntry(key);
        if (entry != null) {
            // update entry
            entry.value = value;
        } else {
            // add new entry
            List<Entry<K, V>> entryList = getEntryList(key);
            entryList.add(new Entry<K, V>(key, value));
            size++;
            assert (size >= 0);
        }
    }

    private Entry<K, V> getEntry(K key) {
        List<Entry<K, V>> entryList = getEntryList(key);
        for (Entry<K, V> entry : entryList) {
            if (entry.key.equals(key)) {
                return entry;
            }
        }

        return null;
    }

    private int hash(K key) {
        int hash = Utils.hash(key);
        hash = (hash > 0) ? hash : (-hash);
        hash %= tableSize;
        return hash;
    }

    private List<Entry<K, V>> getEntryList(K key) {
        int hash = hash(key);
        hash = (hash >= 0) ? hash : -hash;   // make hash positive
        List<Entry<K, V>> entryList = (List<Entry<K, V>>) table[hash];
        return entryList;
    }

    public void remove(K key) {
        List<Entry<K, V>> entryList = getEntryList(key);
        for (int i = 0; i < entryList.size(); i++) {
            if (entryList.get(i).key.equals(key)) {
                entryList.remove(i);
                size--;
                assert (size >= 0);
                break;
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size != 0;
    }

    private class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int DEFAULT_TABLE_SIZE = 100;
}
