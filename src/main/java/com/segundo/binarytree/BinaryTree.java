package com.segundo.binarytree;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    private Node<T> add(Node<T> current, Node<T> newNode) {

        if(current == null) {
            return newNode;
        } else if(newNode.getContent().compareTo(current.getContent()) < 0) {
            current.setLeft(add(current.getLeft(), newNode));
        } else {
            current.setRight(add(current.getRight(), newNode));
        }

        return current;
    }

    public void add(T content) {
        Node<T> newNode = new Node<>(content);
        this.root = add(this.root, newNode);
    }

    private void inOrder(Node<T> current) {
        if(current != null) {
            inOrder(current.getLeft());
            System.out.printf("%s ", current);
            inOrder(current.getRight());
        }
    }

    public void inOrder() {
        inOrder(this.root);
    }

    private void posOrder(Node<T> current) {
        if(current != null) {
            inOrder(current.getLeft());
            inOrder(current.getRight());
            System.out.printf("%s ", current);
        }
    }

    public void posOrder() {
        posOrder(this.root);
    }

    private void preOrder(Node<T> current) {
        if(current != null) {
            System.out.printf("%s ", current);
            inOrder(current.getLeft());
            inOrder(current.getRight());
        }
    }

    public void preOrder() {
        preOrder(this.root);
    }

    public void remove(T content) {
        deleteNode(this.root, content);
    }

    private Node<T> deleteNode(Node<T> root, T value) {
        if(root == null) return null;
        if(root.getContent().equals(value)) {

            if(root.getRight() == null && root.getLeft() == null) return null;
            if(root.getLeft() == null && root.getRight() != null) return root.getRight();
            if(root.getRight() == null && root.getLeft() != null) return root.getLeft();

            Node<T> node = helper(root.getRight(), root);
            root.setContent(node.getContent());
        } else if(root.getContent().compareTo(value) < 0) {
            root.setRight(deleteNode(root.getRight(), value));
        } else {
            root.setLeft(deleteNode(root.getLeft(), value));
        }
        return root;
    }

    private Node<T> helper(Node<T> root, Node<T> parent) {
        Node<T> previous = parent;
        Node<T> current = root;
        
        while(current.getLeft() != null) {
            previous = current;
            current = current.getLeft();
        }
        deleteNode(previous, current.getContent());
        return current;
    }
}
