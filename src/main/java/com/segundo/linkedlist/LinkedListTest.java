package com.segundo.linkedlist;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list);
        System.out.println(list.size());

        System.out.println(list.remove(1));
        System.out.println(list);
        System.out.println(list.size());

        System.out.println("--------------");
        list.add(7, 0);
        list.add(8, 3);
        list.add(9);
        System.out.println(list);
    }
}
