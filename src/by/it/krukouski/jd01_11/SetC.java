package by.it.krukouski.jd01_11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SetC<T> implements Set<T> {

    private T[] array = (T[]) new Object[]{};
    private int size = 0;


    @Override
    public boolean add(T t) {
        for (int i = 0; i < size; i++) {
            if (t.equals(array[i])) {
                return false;
            }
        }
        if (size == array.length) {
            array = Arrays.copyOf(array, (size * 3) / 2 + 1);
        }
        array[size++] = t;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = 0;
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    index = i;
                    System.arraycopy(array, index + 1, array, index, size - index - 1);
                    size--;
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(array[i])) {
                    index = i;
                    System.arraycopy(array, index + 1, array, index, size - index - 1);
                    size--;
                    return true;
                }
            }
        }

        return false;
    }


    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        int resultSize = 0;
        for (int i = 0; i < size; i++) {
            resultSize++;
        }
        return resultSize;
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
        boolean i = false;
        for (T elementCollection : c) {
            if (add(elementCollection)) {
                i = true;
            }

        }
        return i;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean i = false;
        for (Object elementCollection : c) {
            if (contains(elementCollection)) {
                i = true;
            }
        }
        return i;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean i = false;
        for (Object elementCollection : c) {
            if (contains(elementCollection)) {
                remove(elementCollection);
                i = true;
            }
        }
        return i;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            sb.append(delimiter).append(array[i]);
            delimiter = ", ";
        }
        sb.append("]");
        return sb.toString();
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
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
