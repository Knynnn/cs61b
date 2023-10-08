public class LinkedListDeque<T> implements Deque<T> {
    private DequeNode sentinel;
    private int size;

    private class DequeNode {
        private DequeNode prev;
        private T item;
        private DequeNode next;

        private DequeNode(DequeNode prev, T item, DequeNode next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }

        public T getRecursive(int index) {
            if (index == 0) {
                return item;
            }
            return next.getRecursive(index - 1);
        }

    }

    public LinkedListDeque() {
        sentinel = new DequeNode(null, null, null);
        size = 0;
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    @Override
    public void addFirst(T item) {
        DequeNode p = sentinel.next;
        sentinel.next = new DequeNode(sentinel, item, sentinel.next);
        p.prev = sentinel.next;
        size++;
    }

    @Override
    public void addLast(T item) {
        DequeNode p = sentinel.prev;
        sentinel.prev = new DequeNode(sentinel.prev, item, sentinel);
        p.next = sentinel.prev;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        DequeNode p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    @Override
    public T removeFirst() {
        DequeNode p = sentinel.next;
        if (p == sentinel) {
            return null;
        }
        sentinel.next = p.next;
        sentinel.next.prev = sentinel;
        p.prev = null;
        p.next = null;
        size--;
        return p.item;
    }

    @Override
    public T removeLast() {
        DequeNode p = sentinel.prev;
        if (p == sentinel) {
            return null;
        }
        sentinel.prev = p.prev;
        sentinel.prev.next = sentinel;
        p.prev = null;
        p.next = null;
        size--;
        return p.item;
    }

    @Override
    public T get(int index) {
        DequeNode p = sentinel.next;
        if (size > index) {
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
            return p.item;
        }
        return null;
    }

    public T getRecursive(int index) {
        DequeNode p = sentinel.next;
        if (size > index) {
            return p.getRecursive(index);
        }
        return null;
    }
}
