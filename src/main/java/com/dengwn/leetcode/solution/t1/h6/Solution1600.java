package com.dengwn.leetcode.solution.t1.h6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: dengwn
 * @date: 2024-04-09
 **/
public class Solution1600 {
    public static void main(String[] args) {
        ThroneInheritance throneInheritance = new ThroneInheritance("king");
        throneInheritance.birth("king", "andy");
        throneInheritance.birth("king", "bob");
        throneInheritance.birth("king", "catherine");
        throneInheritance.birth("andy", "matthew");
        throneInheritance.birth("bob", "alex");
        throneInheritance.birth("bob", "asha");
        System.out.println(throneInheritance.getInheritanceOrder());
        throneInheritance.death("bob");
        System.out.println(throneInheritance.getInheritanceOrder());
    }
}

class ThroneInheritance {

    String kingName;
    Node root;
    HashMap<String, Node> map;

    public ThroneInheritance(String kingName) {
        this.kingName = kingName;
        root = new Node(kingName);
        map = new HashMap<>();
        map.put(kingName, root);
    }

    public void birth(String parentName, String childName) {
        Node node = map.get(parentName);
        Node child = new Node(childName);
        node.addChild(child);
        map.put(childName, child);
    }

    public void death(String name) {
        Node node = map.get(name);
        node.setDeath();
    }

    public List<String> getInheritanceOrder() {
        List<String> ans = new ArrayList<>();
        preOrder(ans, root);
        return ans;
    }

    private void preOrder(List<String> ans, Node node){
        if (!node.death){
            ans.add(node.name);
        }
        for (Node child : node.children) {
            preOrder(ans, child);
        }
    }
}

class Node{
    String name;
    boolean death;
    List<Node> children;

    public Node(String name){
        this.name = name;
        this.death = false;
        this.children = new ArrayList<>();
    }

    public void setDeath() {
        this.death = true;
    }

    public void addChild(Node child){
        children.add(child);
    }
}


