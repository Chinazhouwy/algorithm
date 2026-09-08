package com.chinazhouwy.algolab.datastructure.linear;

// 循环链表
public class CircularList {
    static final class Node {
        int value;
        Node next;
        Node(int value) { this.value = value; }
    }

    private Node tail;

    private int size;

    CircularList(){
        size = 0;
        tail = null;
    }

    void addFirst(int value) {
       if(tail ==  null){
            tail = new Node(value);
            tail.next = tail;
       }else{
            Node head = tail.next;
            tail.next = new Node(value);
            tail.next.next = head;
       }
       size ++;
    }

    void addLast(int value) {
        addFirst(value);
        tail = tail.next;
    }

    int removeFirst() {
        if(size <= 0){
            throw new RuntimeException("");
        }

        Node temp = tail.next;
        tail.next = temp.next;
        
        int ret = temp.value;
        size --;
        temp = null;

        if(size == 0){
            tail = null;
        }
        
        return ret;
    }

    int[] toArray() {
        if(size <= 0){
            return new int[0];
        }
        Node first = tail.next;
        int[] arr = new int[size];
        for(int i =0;i<size;i++){
            arr[i] = first.value;
            first = first.next;
        }
        return arr;
    }

    boolean isEmpty(){
        return size == 0;
    }

    int remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("index: " + index);
        }
        if(index == 0){
            return removeFirst();
        }
        Node first = tail.next;
        Node prev = tail;
        for(int i =0;i<index;i++){
            first = first.next;
            prev = prev.next;
        }
        prev.next = first.next;
        int ret = first.value;
        if(index == size -1){
            tail = prev;
        }
        size --;
        return ret;
    }

    /**
     * 
        josephusOrder(int n, int step) 用来解决约瑟夫问题：

        有 n 个人围成一个环；
        从某个人开始计数，每数到 step 个人就淘汰当前人；
        淘汰后从下一个人继续；
        返回完整的淘汰顺序。
     * @param n
     * @param step
     * @return
     */

    static int[] josephusOrder(int n, int step) {
        if (n < 0 || step <= 0) {
            throw new IllegalArgumentException();
        }
        CircularList circularList = new CircularList();
        for (int i = 0; i < n; i++) {
            circularList.addLast(i+1);
        }
        int[] arr = new int[circularList.size];
        int i = 0, removedIndex = 0;
        while(!circularList.isEmpty()){
            removedIndex = (removedIndex + step -1 ) % circularList.size;
            arr[i] = circularList.remove(removedIndex);
            i++;
        }
        return arr;
    }
    
}
