package com.shreyas;

public class DoublyLinkedList<T> {
    private int size = 0;

    private Node<T> head;

    private Node<T> tail;

    public int size(){
        return this.size;
    }

    public T pop(){
        if(head==null){
            throw new IllegalArgumentException("List is empty.");
        }
        T temp = tail.data;
        tail = tail.prev;
        size--;
        if (size==0){
            head = tail;
        }
        return temp;
    }

    public void push(T data){
        Node<T> temp = new Node<>(data);
        if(head==null){
            head = temp;
            tail = head;
        }else {
            temp.prev = tail;
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    public void add(T data){
        push(data);
    }

    public void add(int index, T data){
        Node<T> temp = new Node<>(data);
        if(index==0){
            temp.next = head;
            head = temp;
            tail = tail==null?head:tail;
            size++;
            return;
        }
        if(index>=size){
            throw new IllegalArgumentException("IndexOutOfBounds");
        }
        Node<T> pointer = head;
        for (int i = 0; i < index; i++) {
            pointer = pointer.next;
        }
        temp.prev = pointer.prev;
        temp.next = pointer;
        pointer.prev = temp;
        size++;
    }

    public T remove(){
        if (head==null){
            throw new IllegalArgumentException("IndexOutOfBounds");
        }
        T temp = head.data;
        head = head.next;
        size--;
        if (size<=0){
            tail = head;
        }
        return temp;
    }

    public T remove(int index){
        if(index==0){
            T result = head.data;
            head = head.next;
            head.prev = null;
            size--;
            return result;
        }
        Node<T> pointer = head;
        if (index>=size){
            throw new IllegalArgumentException("IndexOutOfBounds");
        }
        for (int i = 0; i < index; i++) {
            pointer = pointer.next;
        }
        Node<T> temp = pointer;
        pointer.prev.next = temp.next;
        size--;
        return temp.data;
    }
    private class Node<R>{
        R data;
        Node next;
        Node prev;

        Node(R data){
            this.data = data;
        }
    }
}

