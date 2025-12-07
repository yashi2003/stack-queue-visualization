package com.example.stack_queue_visualization.service;

import com.example.stack_queue_visualization.dsa.ArrayQueue;
import com.example.stack_queue_visualization.dsa.ArrayStack;
import com.example.stack_queue_visualization.dsa.LinkedListQueue;
import com.example.stack_queue_visualization.dsa.LinkedListStack;
import com.example.stack_queue_visualization.dto.StructureState;
import org.springframework.stereotype.Service;

@Service
public class PlaygroundService {

    private final ArrayStack arrayStack = new ArrayStack(5);
    private final ArrayQueue arrayQueue = new ArrayQueue(5);
    private final LinkedListStack linkedListStack = new LinkedListStack();
    private final LinkedListQueue linkedListQueue = new LinkedListQueue();

    // ---- STACK ----

    public StructureState pushToStack(String impl, int value) {
        StructureState state = baseState("STACK", impl);
        try {
            if (isArray(impl)) {
                arrayStack.push(value);
                fillStackArrayState(state, "PUSH " + value);
            } else {
                linkedListStack.push(value);
                fillStackLinkedState(state, "PUSH " + value);
            }
            state.setMessage("Success");
        } catch (IllegalStateException ex) {
            state.setMessage(ex.getMessage());
        }
        return state;
    }

    public StructureState popFromStack(String impl) {
        StructureState state = baseState("STACK", impl);
        try {
            int value;
            if (isArray(impl)) {
                value = arrayStack.pop();
                fillStackArrayState(state, "POP " + value);
            } else {
                value = linkedListStack.pop();
                fillStackLinkedState(state, "POP " + value);
            }
            state.setMessage("Popped " + value);
        } catch (IllegalStateException ex) {
            state.setMessage(ex.getMessage());
        }
        return state;
    }

    public StructureState getStackState(String impl) {
        StructureState state = baseState("STACK", impl);
        if (isArray(impl)) {
            fillStackArrayState(state, "STATE");
        } else {
            fillStackLinkedState(state, "STATE");
        }
        state.setMessage("OK");
        return state;
    }

    // ✅ UPDATED - Use getElementsTopToBottom()
    private void fillStackArrayState(StructureState state, String op) {
        state.setElements(arrayStack.getElementsTopToBottom()); // Changed here
        state.setTopIndex(arrayStack.getTopIndex());
        state.setSize(arrayStack.size());
        state.setCapacity(arrayStack.capacity());
        state.setLastOperation(op);
    }

    private void fillStackLinkedState(StructureState state, String op) {
        state.setElements(linkedListStack.getElementsTopToBottom());
        state.setTopIndex(null);
        state.setSize(linkedListStack.size());
        state.setCapacity(null);
        state.setLastOperation(op);
    }

    // ---- QUEUE ----

    public StructureState enqueueToQueue(String impl, int value) {
        StructureState state = baseState("QUEUE", impl);
        try {
            if (isArray(impl)) {
                arrayQueue.push(value);
                fillQueueArrayState(state, "ENQUEUE " + value);
            } else {
                linkedListQueue.enqueue(value);
                fillQueueLinkedState(state, "ENQUEUE " + value);
            }
            state.setMessage("Success");
        } catch (IllegalStateException ex) {
            state.setMessage(ex.getMessage());
        }
        return state;
    }

    public StructureState dequeueFromQueue(String impl) {
        StructureState state = baseState("QUEUE", impl);
        try {
            int value;
            if (isArray(impl)) {
                value = arrayQueue.pop();
                fillQueueArrayState(state, "DEQUEUE " + value);
            } else {
                value = linkedListQueue.dequeue();
                fillQueueLinkedState(state, "DEQUEUE " + value);
            }
            state.setMessage("Dequeued " + value);
        } catch (IllegalStateException ex) {
            state.setMessage(ex.getMessage());
        }
        return state;
    }

    public StructureState getQueueState(String impl) {
        StructureState state = baseState("QUEUE", impl);
        if (isArray(impl)) {
            fillQueueArrayState(state, "STATE");
        } else {
            fillQueueLinkedState(state, "STATE");
        }
        state.setMessage("OK");
        return state;
    }

    // ✅ UPDATED - Add fullArray
    private void fillQueueArrayState(StructureState state, String op) {
        state.setElements(arrayQueue.getElementsFrontToRear());
        state.setFullArray(arrayQueue.getFullArrayState()); // Added this line
        state.setFrontIndex(arrayQueue.getFrontIndex());
        state.setRearIndex(arrayQueue.getRearIndex());
        state.setSize(arrayQueue.size());
        state.setCapacity(arrayQueue.capacity());
        state.setLastOperation(op);
    }

    private void fillQueueLinkedState(StructureState state, String op) {
        state.setElements(linkedListQueue.getElementsFrontToRear());
        state.setFrontIndex(null);
        state.setRearIndex(null);
        state.setSize(linkedListQueue.size());
        state.setCapacity(null);
        state.setLastOperation(op);
    }

    // ---- helpers ----

    private boolean isArray(String impl) {
        return "array".equalsIgnoreCase(impl);
    }

    private StructureState baseState(String type, String impl) {
        StructureState state = new StructureState();
        state.setType(type);
        state.setImpl(isArray(impl) ? "ARRAY" : "LINKED_LIST");
        return state;
    }
}