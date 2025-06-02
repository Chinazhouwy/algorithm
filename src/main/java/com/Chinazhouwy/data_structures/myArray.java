package com.chinazhouwy.data_structures;

public class myArray<E> {

    // 当前的数据个数
    private int size;

    // 存放数据的数组
    private E[] data;

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // 在index的位置新增一个参数e
    public void add(int index, E e){
        if(index < 0 ){
            throw new IndexOutOfBoundsException();
        }
    }

    public void addFirst(E e){

    }

    public void addLast(E e){

    }








}
