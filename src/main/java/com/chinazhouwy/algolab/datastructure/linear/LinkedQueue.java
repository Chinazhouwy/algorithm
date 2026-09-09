package com.chinazhouwy.algolab.datastructure.linear;

/**
 * 2.2 链队列
    带头节点的链队列令 head.next 指向队头，
    tail 指向队尾；
    空队列时二者都落在头节点
 * LinkedQueue
 */
public class LinkedQueue {
    private static final class Node {
        int value;
        Node next;
        Node(int value) { this.value = value; }
    }

    private final Node head = new Node(0);
    private Node tail = head;
    private int size;

    void enqueue(int value) {
       tail.next = new Node(value);
       tail = tail.next;
       size ++;
    }

    int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        Node ret = head.next;
        head.next = ret.next; 

        size --;

        // !!!!! 
        if(ret == tail){
            tail = head; // !!!
        }

        return ret.value;
    }

    int peek() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return head.next.value;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return  size;
    }
}
