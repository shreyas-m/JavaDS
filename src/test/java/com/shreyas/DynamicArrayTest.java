package com.shreyas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DynamicArrayTest {

    private DynamicArray<Integer> test;

    @BeforeEach
    void init(){
        this.test = new DynamicArray<>();
    }

    @Test
    void get() {
        test.add(1);
        Assertions.assertEquals(1, test.get(0));
    }

    @Test
    void getWhenIndexGreaterThanSize() {
        test.add(1);
        Assertions.assertThrows(IllegalArgumentException.class, ()->test.get(1));
    }

    @Test
    void add() {
        Assertions.assertEquals(0, test.size());
        this.test.add(1);
        this.test.add(12);
        this.test.add(13);
        this.test.add(14);
        this.test.add(15);
        this.test.add(16);
        this.test.add(162);
        this.test.add(126);
        this.test.add(14);
        Assertions.assertEquals(9, test.size());
    }

    @Test
    void delete() {
        this.test.add(0);
        Assertions.assertEquals(1, test.size());
        this.test.delete(0);
        Assertions.assertEquals(0, test.size());
    }

    @Test
    void deleteWhenIndexIsNotTop() {
        this.test.add(0);
        this.test.add(1);
        Assertions.assertEquals(2, test.size());
        this.test.delete(0);
        Assertions.assertEquals(1, test.size());
        Assertions.assertEquals(1, test.get(0));
    }

    @Test
    void deleteWhenArrayIndexGreaterThanSize() {
        this.test.add(0);
        Assertions.assertThrows(IllegalArgumentException.class, ()->test.delete(2));
    }

    @Test
    void deleteWhenArrayIndexGLessThanZero() {
        this.test.add(0);
        Assertions.assertThrows(IllegalArgumentException.class, ()->test.delete(-2));
    }

    @Test
    void size() {
        this.test.add(0);
        Assertions.assertEquals(1, test.size());
    }
}