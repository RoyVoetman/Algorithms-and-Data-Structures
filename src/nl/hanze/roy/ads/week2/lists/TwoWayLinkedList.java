package nl.hanze.roy.ads.week2.lists;

import java.util.AbstractSequentialList;
import java.util.Iterator;
import java.util.ListIterator;

public class TwoWayLinkedList<E> extends AbstractSequentialList<E> {
    @Override
    public int size() {
        return 0;
    }

    private Node<E> head, tail;

    public TwoWayLinkedList() {
    }

    public TwoWayLinkedList(E[] objects) {
        for (E object : objects) add(object);
    }

    public E getFirst() {
        return null;
    }

    public E getLast() {
        return null;
    }

    public void addFirst(E e) {

    }

    public void addLast(E e) {

    }

    @Override
    public void add(int index, E e) {

    }

    public E removeFirst() {
        return null;
    }

    public E removeLast() {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(Object e) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    public int indexOf(Object e) {
        return -1;
    }

    public int lastIndexOf(Object e) {
        return -1;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public E set(int index, E e) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new TwoWayLinkedListIterator();
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    private class TwoWayLinkedListIterator implements Iterator<E> {
        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
           return null;
        }

        @Override
        public void remove() {

        }
    }

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        public Node(E element) {
            this.element = element;
        }
    }
}
