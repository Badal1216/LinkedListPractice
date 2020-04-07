package definition;

import adt.LinkedListADT;

public class MyLinkedList<E> implements LinkedListADT<E> {

    private Node<E> head = null;
    private int size = 0;

    private void addFirst(E item){
        //head = new Node<E>(item,head);
        head = new Node<>(item,head);
        size++;
    }

    private void addAfter(Node<E> node,E item) {
        //node.next = new Node<E>(item,node.next);
        node.next = new Node<>(item,node.next);
        size++;
    }

    public void add(int index,E item){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        } else if (index == 0) {
            addFirst(item);
        } else {
            addAfter(getNode(index - 1), item);
        }
    }

    private Node<E> getNode(int index) {
        /*Node<E> response = null;
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        } else {*/
            Node<E> temp = head;
            for (int i = 0; i < index && temp != null; i++) {
                temp = temp.getNext();
            }
            return temp;
       /* }
        return response;*/
    }

    @Override
    public void add(E item) {
        add(size,item);
    }

    private E removeFirst(){
        E response = null;
        Node<E> temp = head;
        if (temp != null) {
            head = head.getNext();
            size--;
            response = temp.getData();
        }
        return response;
    }

    private E removeAfter(Node<E> node) {
        E response = null;
        Node<E> temp = node.getNext();
        if (temp != null) {
            node.next = temp.getNext();
            size--;
            response = temp.getData();
        }
        return response;
    }

    public E remove(int index) {
        E response = null;
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        } else if (index == 0) {
            response = removeFirst();
        } else {
            response = removeAfter(getNode(index - 1));
        }
        return response;
    }

    @Override
    public E remove() {
        return remove(size-1);
    }

    @Override
    public int search(Object item) {
        int response = -1;
        for (int i = 0; i < size; i++) {
            E data = this.getNode(i).getData();
            if (item.equals(data)) {
                response = i;
                break;
            }

        }
        return response;
    }


    @Override
    public void sort() {

    }

    @Override
    public void print() {
        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            E data = getNode(i).getData();
            System.out.print(data + (i < size - 1 ? ", " : ""));
        }
        System.out.println(" ]");
    }

    private  static class Node<E>{

        private E data;

        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }
    }
}
