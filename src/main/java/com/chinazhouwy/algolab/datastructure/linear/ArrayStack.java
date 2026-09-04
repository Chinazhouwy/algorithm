package com.chinazhouwy.algolab.datastructure.linear;

public class ArrayStack {

    private int[] data;

    private int top;

    public ArrayStack(int initialSize){
        data = new int[initialSize];
    }

    void push(int value) {
        // if(top>data.length){
        if(top >= data.length){
            throw new RuntimeException();
        }
        data[top++] = value;
    }

    int pop() {
        if(top <= 0){
            throw new RuntimeException();
        }
        return data[--top];
    }

    int peek() {
        return data[top-1];   
    }

    boolean isEmpty() {
        return top == 0;
    }

    boolean isFull(){
        return top == data.length - 1;
    }

    int size() {
        return top;
    }



}
