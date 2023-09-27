public class ArrayDeque<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;

    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
        nextFirst = 7;
        nextLast = 0;
    }

    public void DoubleDeque() {
        T[] p = (T []) new Object[items.length];
        System.arraycopy(items, nextFirst + 1, p, 0, items.length - nextFirst);
        System.arraycopy(items, 0, p, items.length - 1, nextLast + 1);
        items = p;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    public void addFirst(T item) {
        if(size == items.length) {
            DoubleDeque();
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst + items.length - 1) % items.length;
        size++;
    }

    public void addLast(T item) {
        if(size == items.length) {
            DoubleDeque();
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for(int i = 0; i < size; i++) {
            System.out.println(items[(nextFirst + 1 + i) % items.length] + " ");
        }
    }

    public T removeFirst() {
        if(isEmpty()) {
            return null;
        }
        nextFirst = (nextFirst + 1) % items.length;
        size--;
        return items[nextFirst];
    }

    public T removeLast() {
        if(isEmpty()) {
            return null;
        }
        nextLast = (nextLast - 1 + items.length) % items.length;
        size--;
        return items[nextLast];
    }

    public T get(int index) {
        if(index < size) {
            return items[(nextFirst + 1 + index) % items.length];
        }
        return null;
    }
}
