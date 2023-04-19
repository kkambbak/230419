package org.ll.MyArrayList;

import java.util.Arrays;

public class MyArrayList<T> {
    private T[] array;
    private int size;
    private int max = 10;

    public MyArrayList() {
        this.size = 0;
        this.array = (T[]) new Object[max];
    }

    public MyArrayList(T[] array) {
        this.array = array;
        this.max = array.length;
        this.size = max;
    }

    private void expand() {
        Object[] newArray = new Object[size * 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        this.array = (T[]) newArray;
        this.max*=2;
    }


    public boolean add(T element) {
        if (size+1 > max) {
            expand();
        }
        array[size] = element;
        this.size++;
        return true;
    }

    public int size() {
        return size;
    }

    public T get(int i) {
        return array[i];
    }

    public T remove(int i) {
        T temp = array[i];
        for (int j = i; j < size - 1; j++) {
            array[j] = array[j + 1];
        }
        array[size] = null;
        size--;
        return temp;
    }


    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        this.array = (T[]) new Object[max];
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
