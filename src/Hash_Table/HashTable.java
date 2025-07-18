package Hash_Table;

import java.util.TreeMap;

public class HashTable<K, V> {
    private TreeMap<K, V>[] hashtable;
    private int M;
    private int size;

    public HashTable(int M) {
        this.M = M;
        size = 0;
        hashtable = new TreeMap[M];
        for(int i = 0; i < M; i++) {
            hashtable[i] = new TreeMap<>();
        }
    }
    public HashTable() {
        this(97);
    }
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }
    public int getSize() {
        return size;
    }

    public void add(K key, V value) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if(map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;
        }
    }

    public V remove(K key) {
        TreeMap<K, V> map = hashtable[hash(key)];
        V res = null;
        if(map.containsKey(key)) {
            res = map.remove(key);
            size--;
        }
        return res;
    }

    public void set(K key, V value) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if(!map.containsKey(key)) {
            throw new IllegalArgumentException(key + "doesn't exist!");
        }
        map.put(key, value);
    }

    public boolean contains(K key) {
        return hashtable[hash(key)].containsKey(key);
    }

    public V get(K key) {
        TreeMap<K, V> map = hashtable[hash(key)];
        return map.get(key);
    }
}
