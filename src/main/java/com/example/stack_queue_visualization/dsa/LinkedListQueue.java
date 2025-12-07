package com.example.stack_queue_visualization.dsa;


public class LinkedListQueue {

    private Node head; // front
    private Node tail; // rear
    private int size;

    public void enqueue(int value) {
        Node node = new Node(value);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue Underflow");
        }
        int value = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is Empty");
        }
        return head.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public int[] getElementsFrontToRear() {
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

