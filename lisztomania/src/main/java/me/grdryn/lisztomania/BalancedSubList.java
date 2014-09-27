package me.grdryn.lisztomania;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class BalancedSubList<E> implements List<E> {

    private final List<E> backingList;

    public BalancedSubList(final List<E> originalList, final int percentage) {

        backingList = new ArrayList<>();

        int indexOfOriginalList = 0;
        final double percentageValue = (originalList.size() * (percentage / 100.0));
        long elementsForPercentage;

        if (percentageValue < 1.0) {
            elementsForPercentage = 1;
        } else {
            elementsForPercentage = Math.round(percentageValue);
        }

        while (backingList.size() < elementsForPercentage) {
            backingList.add(originalList.get(indexOfOriginalList++));
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder((this.size() * 3) + 3);

        sb.append('[');
        for (final E e : this) {
            sb.append(e).append(", ");
        }

        final int indexOfTrailingComma = sb.lastIndexOf(", ");
        if (indexOfTrailingComma != -1) {
            sb.delete(indexOfTrailingComma, indexOfTrailingComma + 2);
        }
        sb.append(']');

        return sb.toString();
    }

    @Override
    public boolean add(final E arg0) {
        return backingList.add(arg0);
    }

    @Override
    public void add(final int index, final E element) {
        backingList.add(index, element);
    }

    @Override
    public boolean addAll(final Collection<? extends E> arg0) {
        return backingList.addAll(arg0);
    }

    @Override
    public boolean addAll(final int arg0, final Collection<? extends E> arg1) {
        return backingList.addAll(arg0, arg1);
    }

    @Override
    public void clear() {
        backingList.clear();

    }

    @Override
    public boolean contains(final Object arg0) {
        return backingList.contains(arg0);
    }

    @Override
    public boolean containsAll(final Collection<?> arg0) {
        return backingList.containsAll(arg0);
    }

    @Override
    public E get(final int arg0) {
        return backingList.get(arg0);
    }

    @Override
    public int indexOf(final Object arg0) {
        return backingList.indexOf(arg0);
    }

    @Override
    public boolean isEmpty() {
        return backingList.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return backingList.iterator();
    }

    @Override
    public int lastIndexOf(final Object arg0) {
        return backingList.lastIndexOf(arg0);
    }

    @Override
    public ListIterator<E> listIterator() {
        return backingList.listIterator();
    }

    @Override
    public ListIterator<E> listIterator(final int arg0) {
        return backingList.listIterator(arg0);
    }

    @Override
    public boolean remove(final Object arg0) {
        return backingList.remove(arg0);
    }

    @Override
    public E remove(final int arg0) {
        return backingList.remove(arg0);
    }

    @Override
    public boolean removeAll(final Collection<?> arg0) {
        return backingList.removeAll(arg0);
    }

    @Override
    public boolean retainAll(final Collection<?> arg0) {
        return backingList.retainAll(arg0);
    }

    @Override
    public E set(final int arg0, final E arg1) {
        return backingList.set(arg0, arg1);
    }

    @Override
    public int size() {
        return backingList.size();
    }

    @Override
    public List<E> subList(final int arg0, final int arg1) {
        return backingList.subList(arg0, arg1);
    }

    @Override
    public Object[] toArray() {
        return backingList.toArray();
    }

    @Override
    public <T> T[] toArray(final T[] arg0) {
        return backingList.toArray(arg0);
    }

}
