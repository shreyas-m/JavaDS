package com.shreyas;

public class HashMap<K,V> {

    private DynamicArray<DoublyLinkedList<Entry<K,V>>> list;
    private int capacity;

    public HashMap(){
        this.capacity = 8;
        this.list = new DynamicArray<>(capacity);
    }

    public void put(K key, V value){
        Entry<K,V> entry = new Entry<>(key, value);
        int bucket = this.hashCode()%capacity;
        if (list.get(bucket)!=null){
            list.get(bucket).add(entry);
        }else {
            DoublyLinkedList<Entry<K,V>> llist = new DoublyLinkedList<>();
            llist.add(entry);
            list.add(bucket, llist);
        }
    }
    private class Entry<K,V>{
        K key;
        V value;

        Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
}
