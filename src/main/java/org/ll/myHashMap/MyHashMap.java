package org.ll.myHashMap;

import java.util.Arrays;

public class MyHashMap<K, V> {
    private int size;
    private int max;
    private Node<K, V>[] table;


    static class Node<K, V> {
        final K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }
    }

    public MyHashMap() {
        this.size = 0;
        this.max = 16;
        this.table = new Node[max];
    }


    private int hash(K key) {
        return key.hashCode() % max;
    }

    private void resize() {
        Node<K, V>[] oldTable = table;
        max *= 2;
        Node<K, V>[] newTable = Arrays.copyOf(oldTable, max);
    }


    public int size() {
        return size;
    }

    public V put(K key, V value) {
        if (size >= max - 1)
            resize();

        int hash = hash(key);

        if (table[hash] == null) {
            Node<K, V> newNode = new Node<>(key, value);
            table[hash] = newNode;
            size++;
            return null;
        } else {
            V oldValue = table[hash].getValue();
            table[hash].setValue(value);
            return oldValue;
        }
    }

    public V get(K key) {
        int hash = hash(key);
        return table[hash].getValue();
    }

    public V remove(K key) {
        int hash = hash(key);
        if (table[hash] == null) {
            return null;
        } else {
            V oldValue = table[hash].getValue();
            table[hash] = null;
            size--;
            return oldValue;
        }
    }

    public boolean containsKey(K key) {
        int hash = hash(key);
        return table[hash] != null;
    }


    public boolean containsValue(V value) {
        for (Node<K, V> node : table) {
            if (node == null)
                continue;
            if (node.getValue().equals(value))
                return true;
        }
        return false;
    }

    public void clear() {
        for (int i = 0; i < max; i++) {
            table[i] = null;
        }
        size = 0;
    }

    public boolean isEmpty() {
        if (size == 0)
            return true;
        else
            return false;
    }
}

