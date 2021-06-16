package by.it.sapazhkou.jd01_11;

import java.util.*;

public class SetC<T> implements List<T> {

    private T[] elements = (T[]) new Object[16];
    private int size;

    @Override
    public boolean add(T element) {
        if (elements.length <= size) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        elements[size++] = element;
        return true;
    }

    @Override
    public T set(int index, T element) {
        T returnValue = elements[index];
        elements[index] = element;
        return returnValue;
    }


    @Override
    public void add(int index, T element) {
        if (elements.length <= size) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        elements[size++] = null;
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
    }


    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public T remove(int index) {
        T returnValue = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return returnValue;
    }


    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {

        if (c instanceof ArrayList) {
            T[] arrayPartTwo = (T[]) c.toArray();
            if (elements.length <= size) {
                elements = Arrays.copyOf(elements, elements.length * 3 / 2 + arrayPartTwo.length);
            }
            System.arraycopy(arrayPartTwo, 0, elements, size, arrayPartTwo.length);
            size = size + arrayPartTwo.length;
        }

        return true;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimeter = "";
        for (int i = 0; i < size; i++) {
            sb.append(delimeter).append(elements[i]);
            delimeter = ", ";
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }


    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }


    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }


}
