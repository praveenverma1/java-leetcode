package com.leetcode.linkedlist;

public class MyHashSet {

    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75f;

    private int capacity;
    private int size;
    private Node[] buckets;

    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public MyHashSet() {
        capacity = DEFAULT_CAPACITY;
        buckets = new Node[capacity];
        size = 0;
    }

    private int hash(int key) {
        return Math.abs(key) % capacity;
    }

    public void add(int key) {
        if (contains(key))
            return;
        if (size >= capacity * LOAD_FACTOR)
            resize();
        int hash = hash(key); // <-- Compute hash *after* resizing
        Node newNode = new Node(key);
        newNode.next = buckets[hash];
        buckets[hash] = newNode;
        size++;
    }

    public void remove(int key) {
        int hash = hash(key);
        Node node = buckets[hash];
        Node previous = null;
        while (node != null) {
            if (node.val == key) {
                if (previous == null) {
                    buckets[hash] = node.next;
                } else {
                    previous.next = node.next;
                }
                size--;
                return;
            }
            previous = node;
            node = node.next;
        }
    }

    public boolean contains(int key) {
        int hash = hash(key);
        Node node = buckets[hash];
        while (node != null) {
            if (node.val == key) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    private void resize() {
        Node[] oldBuckets = buckets;
        int oldCapacity = capacity;

        capacity *= 2;
        buckets = new Node[capacity];
        size = 0;
        for (int i = 0; i < oldCapacity; i++) {
            Node current = oldBuckets[i];
            while (current != null) {
                int hash = hash(current.val);
                Node newNode = new Node(current.val);
                newNode.next = buckets[hash];
                buckets[hash] = newNode;
                current = current.next;
            }
        }
    }
}
