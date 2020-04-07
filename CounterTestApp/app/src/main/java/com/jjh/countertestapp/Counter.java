package com.jjh.countertestapp;

public class Counter {
    private int count = 0;

    public void increment() {
        count++;
    }

    public void decrement() {
        count --;
    }

    public int getCount() {
        return count;
    }
}
