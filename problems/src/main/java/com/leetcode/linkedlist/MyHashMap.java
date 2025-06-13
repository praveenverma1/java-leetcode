package com.leetcode.linkedlist;

public class MyHashMap {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75f;

    private int capacity;
    private int size;
    private Node[] buckets;

    private static class Node {
        int key;
        int val;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    public MyHashMap() {
        capacity = DEFAULT_CAPACITY;
        buckets = new Node[capacity];
        size = 0;
    }

    private int hash(int key) {
        return Math.abs(key) % capacity;
    }

    public void put(int key, int value) {
        Node current = getNode(key);
        if (current != null) {
            current.val = value;
            return;
        }
        if (size >= capacity * LOAD_FACTOR)
            resize();
        int index = hash(key);
        Node newNode = new Node(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;
    }

    public int get(int key) {
        int index = hash(key);
        Node current = buckets[index];
        while (current != null) {
            if (current.key == key) {
                return current.val;
            }
            current = current.next;
        }
        return -1;
    }

    private Node getNode(int key) {
        int index = hash(key);
        Node current = buckets[index];
        while (current != null) {
            if (current.key == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void remove(int key) {
        int index = hash(key);
        Node current = buckets[index];
        Node previous = null;
        while (current != null) {
            if (current.key == key) {
                if (previous == null) {
                    buckets[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    private void resize() {
        Node[] oldBuckets = buckets;
        int oldCapacity = capacity;

        capacity *= 2;
        buckets = new Node[capacity];
        for (int i = 0; i < oldCapacity; i++) {
            Node current = oldBuckets[i];
            while (current != null) {
                Node newNode = new Node(current.key, current.val);
                int index = hash(current.key);
                newNode.next = buckets[index];
                buckets[index] = newNode;
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 2);
        hashMap.put(2, 2);
        hashMap.get(1);
        hashMap.get(3);
        hashMap.put(2, 1);
        hashMap.get(2);
        hashMap.remove(2);
        hashMap.get(2);
    }
}
