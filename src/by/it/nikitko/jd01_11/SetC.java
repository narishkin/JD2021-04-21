package by.it.nikitko.jd01_11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SetC<T> implements Set<T> {

    private T[] elements = (T[]) new Object[]{};

    private int size = 0;


    @Override
    public String toString() {
        StringBuilder stringToPrint = new StringBuilder("[");
        String delimeter = "";
        for (int i = 0; i < size; i++) {
            stringToPrint.append(delimeter).append(elements[i]);
            delimeter = ", ";
        }
        stringToPrint.append("]");
        return stringToPrint.toString();
    }

    @Override
    public boolean add(T t) {
        if (t==null){
            t= (T) "null";
        }
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(t)) {
                return false;
            }
        }
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, (size * 3) / 2 + 1);
        }
        elements[size] = t;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                elements = Arrays.copyOf(elements, size - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (T element : elements) {
            if (element.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {

        T[] addPart = (T[]) new Object[c.size()];
        addPart = c.toArray(addPart);
        for (int i = 0; i < size; i++) {
            if (elements[i]==null){
                elements[i]= (T) "null";
            }
            for (int i1 = 0; i1 < c.size(); i1++) {
                if (addPart[i1]==null){
                    addPart[i1]= (T) "null";
                }
                if (addPart[i1].equals(elements[i])) {
                    return false;
                }
            }
        }
        elements = Arrays.copyOf(elements, size + c.size());
        System.arraycopy(addPart, 0, elements, size, c.size());
        size += c.size();
        return true;
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
        return (T1[]) elements;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
