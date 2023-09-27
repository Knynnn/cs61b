public class LinkedListDeque<T> {
    private DequeNode sentinel;
    private int size;

    public class DequeNode {
        public DequeNode prev;
        public T item;
        public DequeNode next;

        public DequeNode(DequeNode prev, T item, DequeNode next) {
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

    public void addFirst(T item) {
        DequeNode p = sentinel.next;
        sentinel.next = new DequeNode(sentinel, item, sentinel.next);
        p.prev = sentinel.next;
        size++;
    }

    public void addLast(T item) {
        DequeNode p = sentinel.prev;
        sentinel.prev = new DequeNode(sentinel.prev, item, sentinel);
        p.next = sentinel.prev;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        DequeNode p = sentinel.next;
        while(p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

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

    public T get(int index) {
        DequeNode p = sentinel.next;
        if(size > index) {
            for(int i = 0; i < index; i++) {
                p = p.next;
            }
            return p.item;
        }
        return null;
    }

    public T getRecursive(int index) {
        DequeNode p = sentinel.next;
        if(size > index) {
            return p.getRecursive(index);
        }
        return null;
    }
}
