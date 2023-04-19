package org.ll.MyArrayList;

import java.util.Arrays;

public class MyArrayList<T> {
    private T[] array;
    private int size;

    public MyArrayList() {
        this.size = 0;
        this.array = (T[]) new Object[0];
    }

    public MyArrayList(T[] array) {
        this.array = array;
    }

    public boolean add(T element) {
        Object[] newArray = new Object[size + 1];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        newArray[size] = element;
        this.array = (T[]) newArray;
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
        Object[] newArray = new Object[size - 1];

        for (int j = 0; j < i; j++) {
            newArray[j] = array[j];
        }

        T temp = array[i];

        for (int j = i; j < size - 1; j++) {
            newArray[j] = array[j + 1];
        }
        this.array = (T[]) newArray;
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
        this.array = (T[]) new Object[0];
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
