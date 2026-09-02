package com.chinazhouwy.algolab.datastructure;


/**
 * 数组 nodes:
┌─────┬─────┐
│idx  │ 值  │ prev
├─────┼─────┼──────┐
│ 0   │ 10  │  1   │
│ 1   │ 20  │  2   │
│ 2   │ 30  │ -1   │  ← -1 表示链表结束
└─────┴─────┴──────┘

top = 2  (栈顶指向idx=2)
 * StaticLinkedList
 */
public class StaticLinkedList {
    static class Node {
        
        int value;
        
        int  prev;  // 指向前一个节点的下标
        
        Node(int value, int prev) {
            this.value = value;
            this.prev = prev;
        }
    }

    Node[] data = new Node[10];

    int top = -1;
    
    int size ;

    void push(int value) {
        Node newNode = new Node(value, top);
        data[size] = newNode;
        top = size;
        size++;
    }

    int pop() {
        if(isEmpty()) return -1;
        Node removed = data[top];
        top = data[top].prev;
        size --;
        return removed.value;
    }

    int peek() {
        if(isEmpty()) return -1;
        return data[top].value;
    }

    boolean isEmpty() {
        return size == 0;// return top == -1;  // ✓✓ 更直观
    }

    int size() {
       return size;
    }

}
