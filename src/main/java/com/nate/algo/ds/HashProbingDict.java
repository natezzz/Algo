package com.nate.algo.ds;

import com.nate.algo.util.Utils;


/**
 * A hash table.
 * Use sequential probing to resolve collision.
 */
public class HashProbingDict<K, V> implements IDictionary<K, V> {

    private Object[] table; // use unchecked casting
    private int tableSize;
    private int size;

    public HashProbingDict() {
        tableSize = DEFAULT_TABLE_SIZE;
        size = 0;
        initTable();
    }

    public HashProbingDict(int tableSize) {
        this.tableSize = tableSize;
        size = 0;
        initTable();
    }

    private void initTable() {
        table = new Object[tableSize];
        for (int i = 0; i < table.length; i++) {
            table[i] = new Entry<K, V>(null, null, EntryFlag.EMPTY);
        }
    }

    public void clear() {
        initTable();
        size = 0;
    }

    public V get(K key) {
        Entry<K, V> entry = getEntry(key);
        return (entry == null) ? null : entry.value;
    }

    private int hash(K key) {
        int hash = Utils.hash(key);
        hash = (hash > 0) ? hash : (-hash);
        hash %= tableSize;
        return hash;
    }

    private Entry<K, V> getEntry(K key) {
        int i = hash(key);

        for (; i < table.length; i++) {
            Entry<K, V> curEntry = (Entry<K, V>) table[i];
            if (curEntry.flag == EntryFlag.EMPTY) {
                // no need to track anymore
                return null;
            }

            if (curEntry.flag == EntryFlag.ACTIVE) {
                if (curEntry.key.equals(key)) {
                    return curEntry;
                }
            }
        }

        return null;
    }

    private Entry<K, V> getAvailEntryToPut(K key) {
        Entry<K, V> entry = getEntry(key);
        if (entry != null) {
            return entry;
        }

        // now no entry with same key exists
        int i = hash(key);

        for (; i < table.length; i++) {
            Entry<K, V> cur = (Entry<K, V>) table[i];
            if (cur.flag == EntryFlag.DELETED || cur.flag == EntryFlag.EMPTY) {
                return cur;
            }
        }

        return null;
    }

    public void put(K key, V value) {
        Entry<K, V> entry = getAvailEntryToPut(key);
        if (entry != null) {
            entry.key = key;
            entry.value = value;
            entry.flag = EntryFlag.ACTIVE;
            size++;
        } else {
            System.err.println("Hash table full.");
        }
    }

    public void remove(K key) {
        Entry<K, V> entry = getEntry(key);
        if (entry != null) {
            entry.flag = EntryFlag.DELETED;
            size--;
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
        EntryFlag flag;

        Entry(K key, V value, EntryFlag flag) {
            this.key = key;
            this.value = value;
            this.flag = flag;
        }
    }

    private enum EntryFlag {
        ACTIVE, EMPTY, DELETED
    }

    private static final int DEFAULT_TABLE_SIZE = 1000000;
}
