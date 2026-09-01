package com.chinazhouwy.algolab.datastructure;

public class LinkedList {
    
    static final class Node {
        int value;
        Node next;
        Node(int value) { this.value = value; }
    }

    int size = 0;

    Node head = null;

    void add(int index, int value) {
        Node newNode = new Node(value);
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        
    }

}
