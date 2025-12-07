package com.example.stack_queue_visualization.dto;

public class StructureState {

    private String type;
    private String impl;
    private Integer size;
    private Integer capacity;
    private Integer topIndex;
    private Integer frontIndex;
    private Integer rearIndex;
    private String lastOperation;
    private String message;
    private int[] elements;
    private Integer[] fullArray;      // e.g. "Pushed 10", "Stack Overflow"

    public StructureState() {
    }

    // --- getters & setters ---

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImpl() {
        return impl;
    }

    public void setImpl(String impl) {
        this.impl = impl;
    }

    public int[] getElements() {
        return elements;
    }

    public void setElements(int[] elements) {
        this.elements = elements;
    }

    public Integer getTopIndex() {
        return topIndex;
    }

    public void setTopIndex(Integer topIndex) {
        this.topIndex = topIndex;
    }

    public Integer getFrontIndex() {
        return frontIndex;
    }

    public void setFrontIndex(Integer frontIndex) {
        this.frontIndex = frontIndex;
    }

    public Integer getRearIndex() {
        return rearIndex;
    }

    public void setRearIndex(Integer rearIndex) {
        this.rearIndex = rearIndex;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getLastOperation() {
        return lastOperation;
    }

    public void setLastOperation(String lastOperation) {
        this.lastOperation = lastOperation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer[] getFullArray() {
        return fullArray;
    }

    public void setFullArray(Integer[] fullArray) {
        this.fullArray = fullArray;
    }
}
