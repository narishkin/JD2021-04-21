package by.it.zhurauleu.jd01_11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

@SuppressWarnings("ConstantConditions")
public class SetC<T> implements Set<T> {

    private T[] elements = (T[]) new Object[16];

    private int size;

    public SetC() {
    }

    public String toString() {
        StringBuilder resultString = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            resultString.append(delimiter).append(elements[i]);
            delimiter = ", ";
        }
        resultString.append("]");
        return resultString.toString();
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i] != null) {
                if (elements[i].equals(o)) {
                    return true;
                }
            } else if (elements[i] == null) {
                if (o == null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean add(T element) {
        if (!contains(element)) {
            if (elements.length <= size) {
                elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
            }
            elements[size++] = element;
            return true;
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
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (o != null) {
                if (o.equals(elements[i])) {
                    System.arraycopy(elements, i + 1, elements, i, size - 1 - i);
                    elements[size--] = null;
                    return true;
                }
            } else {
                if (o == elements[i]) {
                    System.arraycopy(elements, i + 1, elements, i, size - 1 - i);
                    elements[size--] = null;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {

        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modifier = false;
        for (T element : c) {
            if (add(element)) {
                modifier = true;
            }
        }
        return modifier;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modifier = false;
        for (Object o : c) {
            if (remove(o)) {
                modifier = true;
            }
        }
        return modifier;
    }

    //not released
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
        Arrays.fill(elements, null);
        size = 0;
    }
}
