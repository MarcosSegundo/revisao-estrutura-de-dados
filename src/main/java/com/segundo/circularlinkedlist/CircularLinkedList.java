package com.segundo.circularlinkedlist;

import com.segundo.node.Node;

public class CircularLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private Node<T> find(int index) {
        if(index == 0) return this.tail;

        Node<T> tempNode = this.tail;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.getNext();
        }
        return tempNode;
    }

    public T get(int index) {
        return this.find(index).getContent();
    }

    public void remove(int index) {
        if(index >= this.size()) throw new IndexOutOfBoundsException();

        Node<T> tempNode = this.tail;

        if(index == 0) {
            this.tail = this.tail.getNext();
            this.head.setNext(this.tail);
        } else if(index == 1) {
            this.tail.setNext(this.tail.getNext());
        } else {
            for (int i = 0; i < index - 1; i++) {
                tempNode = tempNode.getNext();
            }

            tempNode.setNext(tempNode.getNext().getNext());
        }

        this.size--;
    }

    public void add(T content) {
        Node<T> newNode = new Node<>(content);

        if(this.isEmpty()) {
            this.head = newNode;
            this.tail = this.head;
            this.head.setNext(this.tail);
        } else {
            newNode.setNext(this.tail);
            this.head.setNext(newNode);
            this.tail = newNode;
        }

        this.size++;
    }

    @Override
    public String toString() {
        if(this.isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder("[");
        Node<T> tempNode = this.tail;

        for (int i = 0; i < this.size(); i++) {
            sb.append(tempNode.getContent()).append(", ");
            tempNode = tempNode.getNext();
        }

        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");

        return sb.toString();
    }
}
