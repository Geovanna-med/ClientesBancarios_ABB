package dataStructure;

import dataStructure.Tree;

public class TreeTest {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(25);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.traverse(1);
        tree.traverse(2);
        tree.traverse(3);
    }

}
