package com.segundo.queue;

import com.segundo.stack.Node;

public class Queue<T> {
    private Node<T> lastNode;

    public boolean isEmpty() {
        return lastNode == null;
    }

    public void enqueue(T value) {
        Node<T> node = new Node<>(value);
        node.setNext(lastNode);
        lastNode = node;
    }

    public T first() {
        if (this.isEmpty()) return null;

        Node<T> firstNode = lastNode;

        while(firstNode.getNext() != null) {
            firstNode = firstNode.getNext();
        }

        return firstNode.getContent();
    }

    public T dequeue() {

        if (this.isEmpty()) return null;

        if (first() == lastNode.getContent()) {
            T value = lastNode.getContent();
            lastNode = null;
            return value;
        }

        Node<T> firstNode = lastNode;
        Node<T> previusNode = lastNode;

        while(firstNode.getNext() != null) {
            previusNode = firstNode;
            firstNode = firstNode.getNext();
        }

        previusNode.setNext(null);

        return firstNode.getContent();
    }

    @Override
    public String toString() {

        if (this.isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder("[");

        Node<T> tempNode = lastNode;

        while(tempNode != null) {
            sb.append(tempNode.getContent()).append(", ");
            tempNode = tempNode.getNext();
        }

        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");

        return sb.toString();
    }
}
