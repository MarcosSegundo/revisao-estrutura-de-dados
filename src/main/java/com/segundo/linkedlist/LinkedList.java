package com.segundo.linkedlist;

import com.segundo.node.Node;

public class LinkedList<T> {
    private Node<T> head;
    private int size;

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return this.size;
    }

    public void add(T content) {
        Node<T> newNode = new Node<>(content);

        if(this.isEmpty()) {
            this.head = newNode;
        } else {
            Node<T> tempNode = this.head;

            while(tempNode.getNext() != null) {
                tempNode = tempNode.getNext();
            }

            tempNode.setNext(newNode);
        }
        this.size++;
    }

    public void add(T content, int index) {
        Node<T> newNode = new Node<>(content);

        if(index == 0) {
            Node<T> tempNode = this.head;
            newNode.setNext(this.head);
            this.head = newNode;
        } else {
            Node<T> previousNode = this.find(index - 1);
            Node<T> nextNode = this.find(index);
            previousNode.setNext(newNode);
            newNode.setNext(nextNode);
        }
        this.size++;
    }

    private Node<T> find(int index) {
        if(index >= this.size()) throw new IndexOutOfBoundsException();

        Node<T> startNode = this.head;
        Node<T> endNode = null;

        for (int i = 0; i <= index; i++) {
            endNode = startNode;
            startNode = startNode.getNext();
        }
        return endNode;
    }

    public T get(int index) {
        return find(index).getContent();
    }

    public T remove(int index) {
        Node<T> removedNode = this.find(index);

        if(index == 0){
            this.head = this.head.getNext();
            this.size--;
            return removedNode.getContent();
        }

        Node<T> previousNode = this.find(index - 1);
        previousNode.setNext(removedNode.getNext());
        this.size--;

        return removedNode.getContent();
    }

    @Override
    public String toString() {

        if(this.isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder("[");

        Node<T> tempNode = this.head;

        while(tempNode != null) {
            sb.append(tempNode.getContent()).append(", ");
            tempNode = tempNode.getNext();
        }

        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");

        return sb.toString();
    }
}
