package com.chinazhouwy.algolab.datastructure;

public class SeqList {
    
    int[] data;
    
    int size = 0;

    public SeqList(int capacity) {
        if (capacity < 0) throw new RuntimeException("");
        data = new int[capacity];
    }

    void add(int index,int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity();
        //data[size] = value;
        // for(int i = index -1 ; i< size+1;i++){
        //     data[i] = data[i+1];
        // }
        for(int i = size ; i > index;i--){
            data[i] = data[i-1];
        }
        data[index] = value;
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
        //
        //for(int i = index; i < size; i++) {
        for(int i = index; i < size-1; i++) {
            data[i] = data[i + 1];
        }
        //size--;
        data[size--]=0;
        return removedValue;
    }

    int indexOf(int value) {
        for(int i = 0;i<size;i++){
            if(data[i] == value){
                return i;
            }
        }
        return -1;
    }



    void ensureCapacity() {
        if (size >= data.length) {
            int[] newData = new int[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
    }

}
