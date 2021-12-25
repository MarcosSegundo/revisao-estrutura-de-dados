package com.segundo.stack;

import com.segundo.node.Node;

public class Stack<T> {
    private Node<T> top;

    public boolean isEmpty() {
        return top == null;
    }

    public T top() {
        return this.top.getContent();
    }

    public void push(T value) {
        Node<T> node = new Node<>(value);
        Node<T> temp = top;
        top = node;
        top.setNext(temp);
    }

    public T pop() {
        if (this.isEmpty()) return null;

        Node<T> popedNode = top;
        top = top.getNext();

        return popedNode.getContent();
    }

    @Override
    public String toString() {

        if (this.isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder("[");
        Node<T> tempNode = top;

        while(tempNode != null) {
            sb.append(tempNode.getContent()).append(", ");
            tempNode = tempNode.getNext();
        }
        sb.delete(sb.length() - 2, sb.length()); // deleta a vírgula e o espaço do último elemento.
        sb.append("]");

        return sb.toString();
    }
}
