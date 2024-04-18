package com.dengwn.leetcode.weeklyComp;

/**
 * @author: dengwn
 * @date: 2024-04-15
 **/
public class WeeklyComp706 {

}

class MyHashMap {
    Node[] map;
    int size = 16;

    public MyHashMap() {
        map = new Node[16];
    }

    public void put(int key, int value) {
        int hash = key & (size - 1);
        Node root = map[hash];
        if (root == null) {
            map[hash] = new Node(key, value);
        } else {
            while (root != null) {
                if (root.key == key) {
                    root.value = value;
                    return;
                }
                if (root.next == null) {
                    root.next = new Node(key, value);
                    return;
                }
                root = root.next;
            }
        }
    }

    public int get(int key) {
        int hash = key & (size - 1);
        Node root = map[hash];
        while (root != null) {
            if (root.key == key) {
                return root.value;
            }
            root = root.next;
        }
        return -1;
    }

    public void remove(int key) {
        int hash = key & (size - 1);
        Node root = map[hash];
        while (root != null) {
            if (root.key == key) {
                root.value = -1;
            }
            root = root.next;
        }
    }
}

class Node {
    int key;
    int value;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
