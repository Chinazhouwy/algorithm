package com.chinazhouwy.algolab.datastructure.linear;


/**
 * 初始状态：nodes 全都在空闲链
┌─────┬─────┬─────────┐
│idx  │ 值  │ freeNext│
├─────┼─────┼─────────┤
│ 0   │ ?   │   1     │
│ 1   │ ?   │   2     │
│ 2   │ ?   │  -1     │
└─────┴─────┴─────────┘
freeTop = 0

push(10):
从空闲链取一个，比如 idx=0
┌─────┬─────┬─────────┬─────┐
│idx  │ 值  │ freeNext│ prev│
├─────┼─────┼─────────┼─────┤
│ 0   │ 10  │   -     │ -1  │  ← 加入数据链
│ 1   │ ?   │   2     │  -  │  ← 还在空闲链
│ 2   │ ?   │  -1     │  -  │
└─────┴─────┴─────────┴─────┘
freeTop = 1
top = 0

push(20):
从空闲链取 idx=1
┌─────┬─────┬─────────┬─────┐
│idx  │ 值  │ freeNext│ prev│
├─────┼─────┼─────────┼─────┤
│ 0   │ 10  │   -     │ 1   │  ← 20 的 prev 指向 10
│ 1   │ 20  │   -     │ 0   │  ← 新栈顶
│ 2   │ ?   │  -1     │  -  │
└─────┴─────┴─────────┴─────┘
freeTop = 2
top = 1

pop():
节点 idx=1 从数据链移回空闲链
┌─────┬─────┬─────────┬─────┐
│idx  │ 值  │ freeNext│ prev│
├─────┼─────┼─────────┼─────┤
│ 0   │ 10  │   -     │ -1  │  ← 栈顶
│ 1   │ 20  │   2     │  -  │  ← 回到空闲链
│ 2   │ ?   │  -1     │  -  │
└─────┴─────┴─────────┴─────┘
freeTop = 1
top = 0
 * StaticLinkedListComplex
 */
public class StaticLinkedListComplex {
    
    static class Node {
        
        int value;
        
        int  prev;  // 指向前一个节点的下标

        int freeNext = -1; // 
        
        Node(int value, int prev,int freeNext) {
            this.value = value;
            this.prev = prev;
            this.freeNext = freeNext;
        }
    }

    Node[] data ;

    int top;
    
    int size ;

    int free;


    public StaticLinkedListComplex(int capacity) {
        data = new Node[capacity];
        for (int i = 0; i < data.length-1; i++) {
            data[i] = new Node(-1, -1,i+1);
        }

        data[data.length-1] = new Node(-1, -1, -1);
        free = 0;
        top = -1;
    }

    void push(int value) {
        

        int index = free;
        ensureCapacity();
        Node newNode = data[free]; 
        newNode.value = value;
        newNode.prev = top;

        free = newNode.freeNext;
        newNode.freeNext = -1;
        
        //data[size] = newNode; 不需要了，已经取出来了，也成链了
        
        top = index; //!!
        size++;
    }

    int pop() {

        // Node removed = data[top];

        // data[free].freeNext = top;

        // top = data[top].prev;
        // size --;

        // return removed.value;

        int index = top;

        int ret = data[top].value;
        top = data[top].prev;

        data[index].freeNext = free;
        free = index;

        size --;
        return ret;

    }

    int peek() {
        return data[top].value;
    }

    boolean isEmpty() {
        return size == 0;// return top == -1;  // ✓✓ 更直观
    }

    int size() {
       return size;
    }

    void ensureCapacity() {
        if (size >= data.length) {
            Node[] newData = new Node[data.length * 2];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }


}
