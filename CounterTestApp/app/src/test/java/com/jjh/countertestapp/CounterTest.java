package com.jjh.countertestapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CounterTest {

    private Counter counter;

    @Before
    public void setup() {
        counter = new Counter();
    }

    @After
    public void after() {
        counter = null;
    }

    @Test
    public void test_one_increment_operation() {
        counter.increment();
        assertEquals("counter should be 1", 1, counter.getCount());
    }

    @Test
    public void test_two_increment_operations() {
        counter.increment();
        counter.increment();
        assertEquals("counter should be 2", 2, counter.getCount());
    }

    @Test
    public void test_one_decrement_operation() {
        counter.decrement();
        assertEquals("counter should be -1", -1, counter.getCount());
    }

    @Test()
    @Ignore("Test is ignored as a demonstration")
    public void test_one_increment_and_one_decrement_operations() {
        counter.increment();
        counter.decrement();
        assertEquals("counter should be 0", 0, counter.getCount());
    }
}