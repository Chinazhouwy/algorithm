package com.chinazhouwy.algolab.datastructure.linear;

public class ArrayStack {

    private char[] data;

    private int top;

    public ArrayStack(int initialSize){
        if (initialSize < 0) {
            throw new IllegalArgumentException();
    }
        data = new char[initialSize];
    }

    void push(char value) {
        // if(top>data.length){
        if(top >= data.length){
            throw new RuntimeException();
        }
        data[top++] = value;
    }

    char pop() {
        if(top <= 0){
            throw new RuntimeException();
        }
        return data[--top];
    }

    char peek() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return data[top-1];   
    }

    boolean isEmpty() {
        return top == 0;
    }

    boolean isFull(){
        return top == data.length;
    }

    int size() {
        return top;
    }


    public static int getPriort(char c ){
        if(c == '+' || c == '-'){
            return 1;
        }

        if(c == '*' || c == '/'){
            return 2;
        }

        return 0;
    }


    public static String toPostfixt(String s){
        StringBuilder sb = new StringBuilder();
        ArrayStack arrayStack = new ArrayStack(s.length());
        for(char c : s.toCharArray()){
             if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }

            else if(c == '('){
                arrayStack.push(c);
            }

            else if(c == ')'){
                while(arrayStack.peek()!='('){
                        sb.append(arrayStack.pop());
                }
                arrayStack.pop();
            }

            // + - * /
            else{
                while(!arrayStack.isEmpty()
                    && arrayStack.peek()!='('
                    && getPriort(arrayStack.peek()) >= getPriort(c)){
                    sb.append(arrayStack.pop());
                }
                arrayStack.push(c);
            }
        }

        while (!arrayStack.isEmpty()) {
            sb.append(arrayStack.pop());
        }

        return sb.toString();
    }

}
