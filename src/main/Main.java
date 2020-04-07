package main;

import definition.MyLinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.print();
        linkedList.add("badal ");
        linkedList.add("bhatt ");
        linkedList.add("kanhaiya ");
        linkedList.add("bhatt");
        linkedList.print();
        String s = linkedList.remove(0);
        linkedList.print();
        System.out.println(s);
    }
}
