package com.chinazhouwy.algolab.datastructure;

public class LinkedStack {
    static class Node {
        
        int value;
        
        Node prev;
        
        Node(int value, Node prev) {
            this.value = value;
            this.prev = prev;
        }
    }

    Node top;

    int size;

    void push(int value) {
        Node newNode = new Node(value, top);
        top = newNode;
        size ++;
    }

    int pop() {
        if(size <= 0){
            throw new RuntimeException();
        }
        int value = top.value;
        top = top.prev;
        size --;
        return value;
    }

    int peek() {
        if(size <= 0){
            throw new RuntimeException();
        }
        return top.value;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    
}
