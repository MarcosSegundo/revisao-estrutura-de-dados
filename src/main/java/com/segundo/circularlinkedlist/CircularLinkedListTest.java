package com.segundo.circularlinkedlist;

public class CircularLinkedListTest {
    public static void main(String[] args) {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();

        System.out.println(list);
        System.out.println(list.isEmpty());

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list);
//        list.remove(3);
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
    }
}
