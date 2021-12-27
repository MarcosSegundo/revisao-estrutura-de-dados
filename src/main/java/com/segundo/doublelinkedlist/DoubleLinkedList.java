package com.segundo.doublelinkedlist;

public class DoubleLinkedList<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private Node<T> find(int index) {
        if(index >= this.size()) throw new IndexOutOfBoundsException();

        Node<T> tempNode = firstNode;

        for (int i = 0; i < index; i++) {
            tempNode = tempNode.getNext();
        }
        return tempNode;
    }

    public T get(int index) {
        return this.find(index).getContent();
    }

    public void add(T content) {
        Node<T> newNode = new Node<>(content);

        if(firstNode == null) firstNode = newNode;
        if(lastNode != null) lastNode.setNext(newNode);

        newNode.setPrevious(lastNode);
        lastNode = newNode;
        this.size++;
    }

    public void add(T content, int index) {
        Node<T> tempNode = find(index);
        Node<T> newNode = new Node<>(content);

        if(index == 0) {
            newNode.setNext(tempNode);
            tempNode.setPrevious(newNode);
            firstNode = newNode;
        } else {
            tempNode.getPrevious().setNext(newNode);
            newNode.setPrevious(tempNode.getPrevious());
            tempNode.setPrevious(newNode);
            newNode.setNext(tempNode);
        }

        this.size++;
    }

    public void remove(int index) {
        if(index == 0) {
            firstNode = firstNode.getNext();
            if(firstNode != null) firstNode.setPrevious(null);

        } else {
            Node<T> tempNode = this.find(index);
            tempNode.getPrevious().setNext(tempNode.getNext());

            if(tempNode != lastNode && tempNode.getNext() != null) {
                tempNode.getNext().setPrevious(tempNode.getPrevious());
            } else {
                lastNode = tempNode;
            }

        }

        this.size--;
    }

    @Override
    public String toString() {
        if(isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder("[");
        Node<T> tempNode = firstNode;

        while(tempNode != null) {
            sb.append(tempNode.getContent()).append(", ");
            tempNode = tempNode.getNext();
        }

        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");

        return sb.toString();
    }
}
