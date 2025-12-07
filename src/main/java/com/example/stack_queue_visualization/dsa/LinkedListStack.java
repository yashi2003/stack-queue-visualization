package com.example.stack_queue_visualization.dsa;


public class LinkedListStack {

    private Node head; // top of stack
    private int size;

    public void push(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack Underflow");
        }
        int value = head.value;
        head = head.next;
        size--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is Empty");
        }
        return head.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public int[] getElementsTopToBottom() {
        int[] result = new int[size];
        Node current = head;
        int idx = 0;
        while (current != null) {
            result[idx++] = current.value;
            current = current.next;
        }
        return result;
    }
}

