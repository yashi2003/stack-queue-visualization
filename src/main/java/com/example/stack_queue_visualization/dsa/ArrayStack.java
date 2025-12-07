package com.example.stack_queue_visualization.dsa;


public class ArrayStack {
    private final int[] stack;
    private int top;

    public ArrayStack(int capacity){
        this.stack = new int[capacity];
        this.top = -1;
    }

    public void push(int x){
        if(top == stack.length-1){
            throw new IllegalStateException("Stack Overflow");
        }
        top = top + 1;
        stack[top] = x;
    }

    public int pop(){
        if(top == -1){
            throw new IllegalStateException("Stack Underflow");
        }
        return stack[top--];
    }

    public int peek(){
        if(top == -1){
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public int size(){
        return top + 1;
    }

    public int capacity(){
        return stack.length;
    }

    public int[] getElements(){
        int[] res = new int[size()];
        for(int i=0; i<size(); i++){
            res[i] = stack[i];
        }
        return res;
    }

    public int getTopIndex() {
        return top;
    }

    public int[] getElementsTopToBottom(){
        int[] res = new int[size()];
        // Return in LIFO order: top element first
        for(int i = 0; i < size(); i++){
            res[i] = stack[top - i];  // ✅ Start from top, go down
        }
        return res;
    }
}
