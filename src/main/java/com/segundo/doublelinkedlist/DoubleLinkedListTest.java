package com.segundo.doublelinkedlist;

public class DoubleLinkedListTest {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        System.out.println(list.isEmpty());

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list.isEmpty());

        System.out.println(list);
        System.out.println(list.size());

        System.out.println("------------");

        list.add(300, 2);
        list.add(400, 4);
        list.add(500, 5);

        System.out.println(list);
        System.out.println(list.size());

        list.remove(0);
        list.remove(0);
//        list.remove(0);
//        list.remove(0);
//        list.remove(0);
//        list.remove(0);
//        list.remove(0);
        System.out.println(list);
        System.out.println(list.size());

        list.remove(2);
        list.remove(2);
        list.remove(2);
        list.remove(1);
        list.remove(0);

        System.out.println(list);
        System.out.println(list.size());

    }
}
