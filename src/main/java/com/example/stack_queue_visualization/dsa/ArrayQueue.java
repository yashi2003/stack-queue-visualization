package com.example.stack_queue_visualization.dsa;

public class ArrayQueue {
    private final int[] queue;
    private int start;   // front
    private int end;     // rear
    private int size;

    public ArrayQueue(int capacity) {
        this.queue = new int[capacity];
        this.start = -1;
        this.end = -1;
        this.size = 0;
    }

    // enqueue
    public void push(int x) {
        if (size == queue.length) {
            throw new IllegalStateException("Queue Overflow");
        }

        // first element
        if (end == -1) {
            start = 0;
            end = 0;
        } else {
            end = (end + 1) % queue.length; // circular move
        }

        queue[end] = x;
        size++;
    }

    // dequeue
    public int pop() {
        if (size == 0) {
            throw new IllegalStateException("Queue Underflow");
        }

        int el = queue[start];

        if (size == 1) {
            // queue becomes empty
            start = -1;
            end = -1;
        } else {
            start = (start + 1) % queue.length; // circular move
        }

        size--;
        return el;
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[start];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return queue.length;
    }

    public int getFrontIndex() {
        return start;
    }

    public int getRearIndex() {
        return end;
    }

    // 🔥 This is the correct version for ARRAY queue
    // returns elements in logical order: front → rear
    public int[] getElementsFrontToRear() {
        int[] result = new int[size];
        if (size == 0) {
            return result;
        }

        for (int i = 0; i < size; i++) {
            int idx = (start + i) % queue.length;
            result[i] = queue[idx];
        }

        return result;
    }

    // Returns the complete array with nulls for empty positions
    public Integer[] getFullArrayState() {
        Integer[] result = new Integer[queue.length];

        if (size == 0) {
            return result; // all nulls
        }

        // Mark only occupied positions
        for (int i = 0; i < size; i++) {
            int idx = (start + i) % queue.length;
            result[idx] = queue[idx];
        }

        return result;
    }
}
