package com.chinazhouwy.algolab.datastructure;

public class SeqList {
    
    int[] data = new int[100];
    
    int size = 0;

    void add(int index,int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity();
        data[size] = value;
        size++;
    }

    int get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int removedValue = data[index];
        for(int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return removedValue;
    }


    void ensureCapacity() {
        if (size >= data.length) {
            int[] newData = new int[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
    }

}
