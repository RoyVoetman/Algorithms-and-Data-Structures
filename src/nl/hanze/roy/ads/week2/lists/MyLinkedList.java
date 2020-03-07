package nl.hanze.roy.ads.week2.lists;

import java.util.Iterator;
import java.util.LinkedList;

public class MyLinkedList<E> extends MyAbstractList<E> {
    private Node<E> head, tail;

    public MyLinkedList() {
    }

    public MyLinkedList(E[] objects) {
        super(objects);
    }

    public E getFirst() {
        if (size == 0) {
            return null;
        } else {
            return head.element;
        }
    }

    public E getLast() {
        if (size == 0) {
            return null;
        } else {
            return tail.element;
        }
    }

    public void addFirst(E e) {
        Node<E> node = new Node<>(e);
        node.next = head;
        head = node;
        size++;

        if (tail == null)
            tail = head;
    }

    public void addLast(E e) {
        if (tail == null) {
            head = tail = new Node<>(e);
        } else {
            tail.next = new Node<>(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public void add(int index, E e) {
        if (index == 0) addFirst(e);
        else if (index >= size) addLast(e);
        else {
            Node<E> current = head;
            for (int i = 0; i < index; i++)
                current = current.next;

            Node<E> temp = current.next;
            current.next = new Node<>(e);
            (current.next).next = temp;
            size++;
        }
    }

    public E removeFirst() {
        if (size == 0) return null;
        Node<E> temp = head;
        head = head.next;
        size--;
        if (head == null) tail = null;
        return temp.element;
    }

    public E removeLast() {
        if (size==0) return null;

        Node<E> temp;
        if (size == 1) {
            temp = head;
            head = tail = null;
            size = 0;
        } else {
            Node<E> current = head;
            for (int i = 0; i < size; i++)
                current = current.next;

            temp = tail;
            tail = current;
            tail.next = null;
            size--;
        }

        return temp.element;
    }

    @Override
    public void clear() {
        size = 0;
        head = tail = null;
    }

    @Override
    public boolean contains(E e) {
        Node<E> current = head;

        while (current != null) {
            if(current.element.equals(e))
                return true;

            current = current.next;
        }

        return false;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) return null;

        Node<E> current = head;

        int i = 0;
        while (current != null) {
            if(i == index)
                return current.element;

            current = current.next;
            i++;
        }

        return null;
    }

    @Override
    public int indexOf(E e) {
        Node<E> current = head;

        int i = 0;
        while (current != null) {
            if(current.element.equals(e))
                return i;

            current = current.next;
            i++;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        Node<E> current = head;

        int i = 0;
        int indexOf = -1;
        while (current != null) {
            if(current.element.equals(e))
                indexOf = i;

            current = current.next;
            i++;
        }

        return indexOf;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) return null;
        if (index == 0) return removeFirst();
        if (index == size-1) return removeLast();

        Node<E> previous = head;
        for (int i = 0; i < index; i++)
            previous = previous.next;

        Node<E> current = previous.next;
        previous.next = current.next;
        size--;

        return current.element;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append("," );
            }
        }

        result.append("]");
        return result.toString();
    }

    @Override
    public E set(int index, E e) {
        if (index < 0 || index >= size) return null;

        Node<E> previous = head;
        for (int i = 0; i < index; i++)
            previous = previous.next;

        Node<E> current = previous.next;
        Node<E> newNode = new Node<>(e);
        previous.next = newNode;
        newNode.next = current.next;

        return current.element;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current = head;


        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public E next() {
            E e = current.element;
            current = current.next;
            return e;
        }

        @Override
        public void remove() {
            Node<E> temp = current.next;
            MyLinkedList.this.remove(current.element);
            current = temp;
        }
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }
}
