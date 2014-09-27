package me.grdryn.lisztomania;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class BalancedSubList<E> implements List<E> {

    private final List<E> backingList;

    public BalancedSubList(final List<E> originalList, final int percentage) {
        this.backingList = originalList;
    }

    public boolean add(final E arg0) {
        return backingList.add(arg0);
    }

    public void add(final int index, final E element) {
        backingList.add(index, element);
    }

    public boolean addAll(final Collection<? extends E> arg0) {
        return backingList.addAll(arg0);
    }

    public boolean addAll(final int arg0, final Collection<? extends E> arg1) {
        return backingList.addAll(arg0, arg1);
    }

    public void clear() {
        backingList.clear();

    }

    public boolean contains(final Object arg0) {
        return backingList.contains(arg0);
    }

    public boolean containsAll(final Collection<?> arg0) {
        return backingList.containsAll(arg0);
    }

    public E get(final int arg0) {
        return backingList.get(arg0);
    }

    public int indexOf(final Object arg0) {
        return backingList.indexOf(arg0);
    }

    public boolean isEmpty() {
        return backingList.isEmpty();
    }

    public Iterator<E> iterator() {
        return backingList.iterator();
    }

    public int lastIndexOf(final Object arg0) {
        return backingList.lastIndexOf(arg0);
    }

    public ListIterator<E> listIterator() {
        return backingList.listIterator();
    }

    public ListIterator<E> listIterator(final int arg0) {
        return backingList.listIterator(arg0);
    }

    public boolean remove(final Object arg0) {
        return backingList.remove(arg0);
    }

    public E remove(final int arg0) {
        return backingList.remove(arg0);
    }

    public boolean removeAll(final Collection<?> arg0) {
        return backingList.removeAll(arg0);
    }

    public boolean retainAll(final Collection<?> arg0) {
        return backingList.retainAll(arg0);
    }

    public E set(final int arg0, final E arg1) {
        return backingList.set(arg0, arg1);
    }

    public int size() {
        return backingList.size();
    }

    public List<E> subList(final int arg0, final int arg1) {
        return backingList.subList(arg0, arg1);
    }

    public Object[] toArray() {
        return backingList.toArray();
    }

    public <T> T[] toArray(final T[] arg0) {
        return backingList.toArray(arg0);
    }

}
