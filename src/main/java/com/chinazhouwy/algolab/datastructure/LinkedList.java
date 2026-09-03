package com.chinazhouwy.algolab.datastructure;

public class LinkedList {
    static final class Node {
        int value;
        Node next;
        Node(int value) { this.value = value; }
    }

    int size = 0;

    Node dummyNode = new Node(-1);

    void add(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        //dummyNode.next = newNode;
        Node tempNode = dummyNode;
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
        Node tempNode = dummyNode.next;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }
        return tempNode.value;
    }


    int removeBad(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node tempNodePre = dummyNode;
        Node tempNode = dummyNode.next;
        // for (int i = 0; i < index-1; i++) {
        for (int i = 0; i < index; i++) {
            tempNodePre = tempNode;
            tempNode = tempNode.next;
        }
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
        Node tempNodePre = dummyNode;
        int i = 0;
        while (i<index) {
            tempNodePre = tempNodePre.next;
            i++;
        }
        Node removed = tempNodePre.next;
        tempNodePre.next = removed.next;
        size --;
        return removed.value;
    }


     int indexOf(int value) {
        Node current = dummyNode.next;
        for(int i = 0;i<size;i++){
            if(current.value == value){
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    Node reverse() {
        Node slow = null;
        Node fast = dummyNode.next;
        // slow  fast fast.next
        //  0  1  2
        while (fast != null) {
            Node temp = fast.next;
            fast.next = slow;
            slow = fast;
            fast = temp;
        }
        dummyNode.next = slow;
        return slow;
    }

    
    // 将两个已经按升序排列的链表合并成一个升序链表，并返回新链表的头节点。 
    Node mergeSorted(Node first, Node second) {
        Node dummyNode = new Node(-1);
        Node walk = dummyNode; 

        // if (first == null) {
        //     return second;
        // }
        // if (second == null) {
        //     return first;
        // }

        // if(first.value < second.value){
        //     ret = first; 
        //     walk = first;
        //     first = first.next;
        // }else{
        //     ret = second;
        //     walk = second;
        //     second = second.next;
        // }
        
        while (first != null &&  second != null ) {
            if(first.value < second.value){
                walk.next = first;
                // walk = first;
                first = first.next;
            }else{
                walk.next = second;
                // walk = second;
                second = second.next;
            }
            walk = walk.next;
        }
        if(first != null){
            walk.next = first;
        }
        if(second != null){
            walk.next = second;
        }
        return dummyNode.next;
    }

    //对一个已经升序排列的链表去重。
    void deduplicateSortedComplex(Node head) {
        if(head == null) return;
        Node walk = head;
        int temp = head.value;
        Node curNode = walk;
        while (walk != null) {
            if(temp != walk.value){
                temp = walk.value;
                curNode.next = walk;
                curNode = curNode.next;
            }
            walk = walk.next;
        }
        curNode.next = null;//!!!
    }

    //对一个已经升序排列的链表去重。
    void deduplicateSorted(Node head) {
        Node current = head;
        while(current != null && current.next != null){
            if(current.value == current.next.value){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
    }

    // 删除链表中所有值等于 target 的节点。
    Node removeAll(Node head, int target) {
        Node dummyNode = new Node(-1);
        dummyNode.next = head;
        Node curNode = dummyNode;
        while(curNode.next != null){
            if(curNode.next.value == target){
                curNode.next = curNode.next.next;
            }else{
                curNode = curNode.next;
            }
        }
        return dummyNode.next;
    }

    //返回链表倒数第 k 个节点。
    Node kthFromEnd(Node head, int k) {
        Node fast = head;
        Node slow = head;

        for(int i=0;i<k;i++){
            fast = fast.next;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        } 

        return slow;
    }

}
