package com.shreyas;

public class DynamicArray<T> {

    private T[] list;
    private int capacity;

    private int currentSize;

    public DynamicArray(){
        this(8);
    }
    public DynamicArray(int initialCapacity){
        this.capacity = initialCapacity;
        this.list = (T[]) new Object[this.capacity];
        this.currentSize = 0;
    }

    public int size(){
        return this.currentSize;
    }
    public T get(int i){
        if(i>=currentSize){
            throw new IllegalArgumentException("ArrayIndexOutOfBounds");
        }else{
            return list[i];
        }
    }

    public void add(T element){
        if (currentSize>=capacity){
            increaseCapacity();
        }
        list[currentSize] = element;
        currentSize++;
    }

    public void add(int position, T element){
        if (currentSize>=capacity){
            increaseCapacity();
        }
        copyUp(position);
        list[position] = element;
        currentSize++;
    }


    public void delete(int index){
        if(currentSize<=index || index<0){
            throw new IllegalArgumentException("ArrayIndexOutOfBounds");
        }
        if (index < currentSize-1) {
            copyDown(index);
        }
        currentSize--;
    }

    private void increaseCapacity() {
        capacity = capacity*2;
        T[] temp = this.list;
        this.list = (T[]) new Object[capacity];
        for (int i = 0; i < currentSize; i++) {
            this.list[i] = temp[i];
        }
    }

    private void copyDown(int index) {
        for (int i = index; i < currentSize; i++) {
            this.list[i] = this.list[i+1];
        }
    }

    private void copyUp(int index) {
        for (int i = currentSize; i < index; i++) {
            this.list[i] = this.list[i-1];
        }
    }
}
