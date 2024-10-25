package com.dengwn.code.leetcode.solution.t0.h1.d4;

import java.util.HashMap;

/**
 * @author: dengwn
 * @date: 2024-03-22
 **/
public class Solution146 {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }
}

class LRUCache {

    private HashMap<Integer, DoubleLinkedNode> cache;
    private int size;
    private int capacity;
    private DoubleLinkedNode head;
    private DoubleLinkedNode tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            DoubleLinkedNode linkedNode = new DoubleLinkedNode(key, value);
            cache.put(key, linkedNode);
            addToHead(linkedNode);
            size++;
            if (size > capacity) {
                cache.remove(tail.prev.key);
                removeTail();
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(DoubleLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DoubleLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DoubleLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void removeTail() {
        DoubleLinkedNode last = tail.prev;
        removeNode(last);
    }
}

class DoubleLinkedNode {
    int key;
    int value;
    DoubleLinkedNode prev;
    DoubleLinkedNode next;

    public DoubleLinkedNode() {

    }

    public DoubleLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}