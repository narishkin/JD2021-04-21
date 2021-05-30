package by.it.nikitko.jd01_11;

import java.util.*;

public class ListB<T> implements List <T> {

    private T[] elements = (T[]) new  Object[] {};

    private int size=0;

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringToPrint = new StringBuilder("[");
        String delimeter = "";
        for (int i = 0; i < size; i++) {
            stringToPrint.append(delimeter).append(elements[i]);
            delimeter=", ";
        }
        stringToPrint.append("]");
        return stringToPrint.toString();
    }

    @Override
    public boolean add(T t) {
        if (size== elements.length){
            elements= Arrays.copyOf(elements,(size*3)/2+1);
        }
        elements[size++]=t;
        return true;
    }

    @Override
    public T remove(int index) {
        T delElement= elements[index];
        System.arraycopy(elements,index+1,elements,index,size-index-1);
        size--;
        return delElement;
    }


    @Override

    public T set(int index, T element) {
        T delElement= elements[index];
        elements[index]=element;
        return delElement;
    }


    @Override
    public void add(int index, T element) {
        System.arraycopy(elements,index,elements,index+1,size-index);
        elements[index]=element;
        size++;

    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        System.out.println(c.size());
        T[] elements2 = (T[]) new  Object[4];
        c.toArray(elements2);
        System.out.println(Arrays.deepToString(elements2));

//System.arraycopy(elements2,0,elements,elements.length,8);
        return true;
    }

    @Override
    public T get(int index) {
        return elements[index];
    }


    @Override
    public int size() {
       return getSize();
    }

    @Override
    public boolean remove(Object o) {
        return false;
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
