package com.shreyas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    private DoublyLinkedList<Integer> linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new DoublyLinkedList();
    }

    @Test
    void size() {
        linkedList.add(1);
        assertEquals(1, linkedList.size());
        linkedList.add(2);
        assertEquals(2, linkedList.size());
        linkedList.add(3);
        assertEquals(3, linkedList.size());
        linkedList.add(4);
        assertEquals(4, linkedList.size());
        linkedList.add(5);
        assertEquals(5, linkedList.size());
    }

    @Test
    void pop() {
        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(3);
        linkedList.push(4);
        linkedList.push(5);
        assertEquals(5, linkedList.pop());
        assertEquals(4, linkedList.pop());
        assertEquals(3, linkedList.pop());
        assertEquals(2, linkedList.pop());
        assertEquals(1, linkedList.pop());
        assertThrows(IllegalArgumentException.class, ()->linkedList.pop());
    }

    @Test
    void push() {
        linkedList.push(1);
        assertEquals(1, linkedList.size());
        linkedList.push(2);
        assertEquals(2, linkedList.size());
        linkedList.push(3);
        assertEquals(3, linkedList.size());
        linkedList.push(4);
        assertEquals(4, linkedList.size());
        linkedList.push(5);
        assertEquals(5, linkedList.size());
    }

    @Test
    void add() {
        linkedList.add(1);
        assertEquals(1, linkedList.size());
        linkedList.add(2);
        assertEquals(2, linkedList.size());
        linkedList.add(3);
        assertEquals(3, linkedList.size());
        linkedList.add(4);
        assertEquals(4, linkedList.size());
        linkedList.add(5);
        assertEquals(5, linkedList.size());
    }

    @Test
    void testAdd() {
        linkedList.add(0,1);
        assertEquals(1, linkedList.size());
        linkedList.add(0,2);
        assertEquals(2, linkedList.size());
        linkedList.add(1,3);
        assertEquals(3, linkedList.size());
        assertThrows(IllegalArgumentException.class,()->linkedList.add(3,4));
        linkedList.add(1,3);
        assertEquals(4, linkedList.size());
        linkedList.add(5);
        assertEquals(5, linkedList.size());
    }

    @Test
    void remove() {

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        assertEquals(1, linkedList.remove());
        assertEquals(2, linkedList.remove());
        assertEquals(3, linkedList.remove());
        assertEquals(4, linkedList.remove());
        assertEquals(5, linkedList.remove());
        assertThrows(IllegalArgumentException.class,()-> linkedList.remove());

    }

    @Test
    void testRemove() {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        assertEquals(1, linkedList.remove(0));
        assertEquals(2, linkedList.remove(0));
        assertEquals(3, linkedList.remove(0));
        assertThrows(IllegalArgumentException.class,()->linkedList.remove(3));
        assertEquals(5, linkedList.remove(1));
        assertEquals(1, linkedList.size());
    }
}