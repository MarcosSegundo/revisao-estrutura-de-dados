package com.segundo.binarytree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(20);
        tree.add(5);
        tree.add(30);
        tree.add(6);

        tree.inOrder();
        System.out.println();
        tree.preOrder();
        System.out.println();
        tree.posOrder();
        System.out.println();

        tree.remove(20);
        tree.inOrder();
    }
}
