package org.ll.myHashMap;

import java.util.Arrays;

public class MyHashMap<K, V> {
    private int size;
    private int max;
    private Node<K, V>[] table;


    static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
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
        size = 0;
        this.table = new Node[max];

        for (Node<K, V> node : oldTable) {
            while (node != null) {
                put(node.key, node.value);
                node = node.next;
            }
        }
    }


    public int size() {
        return size;
    }

    public V put(K key, V value) {
        if (size > max * 0.75)
            resize();

        int hash = hash(key);

        if (table[hash] == null) {
            Node<K, V> newNode = new Node<>(key, value, null);
            table[hash] = newNode;
            size++;
            return null;
        }
        else {
            Node<K, V> node = table[hash];
            while (node != null) {
                if (node.getKey().equals(key)) {
                    V oldValue = node.getValue();
                    node.setValue(value);
                    return oldValue;
                }
                node = node.next;
            }
            table[hash] = new Node<>(key, value, table[hash]);
            size++;
            return value;

        }
    }

    public V get(K key) {
        int hash = hash(key);
        Node<K, V> node = table[hash];

        while (node.next!=null) {
            if(node.getKey().equals(key)){
                return node.getValue();
            }
            node = node.next;
        }
        return node.getValue();
    }

    public V remove(K key) {
        int hash = hash(key);
        if (table[hash] == null) {
            return null;
        } else {
            V oldValue = table[hash].getValue();

            if (table[hash].getKey().equals(key)) {
                if (table[hash].next != null) {
                    table[hash] = table[hash].next;
                } else {
                    table[hash] = null;
                }
            }

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

