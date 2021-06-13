package by.it.nikitko.jd01_11;

import java.util.*;


public class ListA <T> implements List <T> {

    private T[] elements = (T[]) new  Object[] {};
   

    private int size=0;

    @Override
    public String toString() {
        StringBuilder stringToPrint = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            stringToPrint.append(delimiter).append(elements[i]);
            delimiter=", ";
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
    public T get(int index) {
        return elements[index];
    }


    @Override
    public int size() {
        return 0;
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
    public void add(int index, T element) {

    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
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

        public T set(int index, T element) {
            T delElement= elements[index];
            elements[index]=element;
            return delElement;
        }


    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }
    @SuppressWarnings("ConstantConditions")
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
