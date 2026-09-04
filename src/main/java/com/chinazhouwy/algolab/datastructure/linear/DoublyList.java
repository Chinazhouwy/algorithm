package com.chinazhouwy.algolab.datastructure.linear;

public class DoublyList {
    static final class Node {
        int value;
        Node prev;
        Node next;
        Node(int value) { this.value = value; }
    }

    Node head;


    void add(int index, int value) {
        if(index < 0){
            throw new RuntimeException();
        }
        Node temp = new Node(value);
        
        if(index == 0){
            temp.next = head;
            if(head != null){
                head.prev = temp;
            }
            head = temp;
            return;
        }

        Node bNode =  getNode(index-1);

        temp.next = bNode.next;
        temp.prev = bNode;

        if(bNode.next!= null){
            bNode.next.prev = temp;
        }
        bNode.next = temp;
    }

    int remove(int index) {
        Node removNode =  getNode(index);
        int removed = removNode.value;
        if(head == removNode){
            head = removNode.next;
        }
        if(removNode.prev != null){
            removNode.prev.next = removNode.next;
        }
        if(removNode.next != null){
            removNode.next.prev = removNode.prev;
        }
        return removed;
    }

    int set(int index, int value) {
        Node cur = getNode(index);
        int oldValue = cur.value;
        cur.value = value;
        return oldValue;
    }

    int get(int index) {
        return getNode(index).value;
    }

    Node getNode(int index) {
        if(index < 0){
            throw new RuntimeException();
        }
        int i = 0;
        Node node = head;
        while (i<index && node != null) {
            node = node.next;
            i++;
        }
        if(node == null){
            throw new RuntimeException();
        }
        return node;
    }

}
