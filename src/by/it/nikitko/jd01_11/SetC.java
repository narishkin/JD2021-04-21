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
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            stringToPrint.append(delimiter).append(elements[i]);
            delimiter = ", ";
        }
        stringToPrint.append("]");
        return stringToPrint.toString();
    }

    @Override
    public boolean add(T t) {
        if (t == null) {
            t = (T) "null";
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
        if (o == null) {
            o = "null";
        }
        for (T element : elements) {
            if (element == null) {
                element = (T) "null";
            }
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
        return size == 0;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {

        T[] addPart = (T[]) new Object[c.size()];
        addPart = c.toArray(addPart);
        boolean flagAdd = false;
        for (int i1 = 0; i1 < c.size(); i1++) {
            boolean flagContains = false;

            if (addPart[i1] == null) {
                addPart[i1] = (T) "null";
            }
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    elements[i] = (T) "null";
                }
                if (addPart[i1].equals(elements[i])) {
                    flagContains = true;
                }
            }
            if (!flagContains) {
                add(addPart[i1]);
                flagAdd = true;
            }
        }
        return flagAdd;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        T[] addPart = (T[]) new Object[c.size()];
        addPart = c.toArray(addPart);


        for (int i1 = 0; i1 < c.size(); i1++) {
            if (addPart[i1] == null) {
                addPart[i1] = (T) "null";
            }
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    elements[i] = (T) "null";
                }
                if (addPart[i1].equals(elements[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        T[] addPart = (T[]) new Object[c.size()];
        addPart = c.toArray(addPart);
        boolean flagRemove = false;
        for (int i = 0; i < c.size(); i++) {
            if (addPart[i] == null) {
                addPart[i] = (T) "null";
            }
            remove(addPart[i]);
            flagRemove = true;
        }
        return flagRemove;
    }


    @Override
    public void clear() {
        elements = (T[]) new Object[0];
        size = 0;

//Arrays.copyOf(elements,0);
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
    public boolean retainAll(Collection<?> c) {
        return false;
    }
}
