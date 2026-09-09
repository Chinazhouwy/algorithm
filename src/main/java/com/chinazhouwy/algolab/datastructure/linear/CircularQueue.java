package com.chinazhouwy.algolab.datastructure.linear;

// 循环队列
public class CircularQueue {
   private int[] data;
   // 队头位置，指向下一个要出队的元素
   private int front;
   // 队尾位置，指向下一个要入队的位置
   private int rear;

    // 408 里常见的循环队列确实不使用 size 字段
    // 而是只使用 front 和 rear。最常见的实现是牺牲数组一个位置：
   //private int size;

    CircularQueue(int capacity){
        if (capacity <= 0) throw new IllegalArgumentException("negative capacity");
        data =  new int[capacity+1];
        front = 0;
        rear = 0;
        //size = 0;
    }

    //
    void enqueue(int value) {
        if (isFull()) {
            throw new IllegalStateException("queue is full");
        }
       data[rear] = value;
       rear = (rear+1)%data.length;
       //size ++;
    }

    int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("queue is empty");
        }
        int ret = data[front];
        //size --;
        front = (front+1)%data.length;
        return ret;
    }

    int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("queue is empty");
        }
       return data[front];
    }

    boolean isEmpty() {
       //return size == 0;
       return rear == front;
    }

    boolean isFull(){
       // return size == data.length;
       return (rear+1) % data.length == front;
    }

    int size() {
       return (rear - front + data.length) % data.length;
    }


}
