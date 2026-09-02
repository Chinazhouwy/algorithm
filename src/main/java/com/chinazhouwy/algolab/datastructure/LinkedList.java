package com.chinazhouwy.algolab.datastructure;

public class LinkedList {
    static final class Node {
        int value;
        Node next;
        Node(int value) { this.value = value; }
    }

    int size = 0;

    Node dummpNode = new Node(-1);

    void add(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        //dummpNode.next = newNode;
        Node tempNode = dummpNode;
        for(int i =0 ; i< index-1;i++){
            tempNode = tempNode.next; 
        }
        Node newNode = new Node(value);
        // tempNode.next = newNode;
        // newNode.next = tempNode.next;
        newNode.next = tempNode.next;
        tempNode.next = newNode;
        size ++;
    }

    int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node tempNode = dummpNode.next;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }
        return tempNode.value;
    }


    int removeBad(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node tempNodePre = dummpNode;
        Node tempNode = dummpNode.next;
       // for (int i = 0; i < index-1; i++) {
        for (int i = 0; i < index; i++) {
            tempNodePre = tempNode;
            tempNode = tempNode.next;
        }
        /**
         * 
         */
        tempNodePre.next = tempNode.next;
        int ret = tempNode.value;
        tempNode = null;
        size --;
        return ret;
    }

    int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node tempNodePre = dummpNode.next;
        for (int i = 0; i < index-1; i++) {
            tempNodePre = tempNodePre.next;
        }
        Node removed = tempNodePre.next;
        tempNodePre.next = tempNodePre.next;
        size --;
        return removed.value;
    }

}
