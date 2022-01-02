package com.segundo.binarytree;

import java.util.Objects;

public class Node<T> {
    private T content;
    private Node<T> left;
    private Node<T> right;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node<?> node = (Node<?>) o;
        return content.equals(node.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    public Node(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return String.format("%s", this.content);
    }
}
