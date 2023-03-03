package uppgift3;

public class SingleLinkedList<E> {

    private static class Node<E> {

        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

    }

    private Node<E> head;

    public SingleLinkedList() {
        head = null;
    }

    public void add(int index, E item) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            addFirst(item);
        } else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    public void addFirst(E item) {
        head = new Node<>(item, head);
    }

    private Node<E> getNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    private void addAfter(Node<E> node, E item) {
        node.next = new Node<>(item, node.next);
    }

    public E get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    public boolean add(E item) {
        add(size(), item);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> p = head;
        if (p != null) {
            while (p.next != null) {
                sb.append(p.data.toString());
                sb.append(" ==> ");
                p = p.next;
            }
            sb.append(p.data.toString());
        }
        sb.append("]");
        return sb.toString();
    }


    private E removeFirst() {
        Node<E> node = head;
        head = head.next;
        return node.data;
    }

    public E remove(int index) {
        if (size() == 0) return null;
        if (index >= size() || index < 0) throw new IndexOutOfBoundsException();
        Node<E> node;
        if (index == 0) {
            return removeFirst();
        }
        node = getNode(index - 1);
        Node<E> toRemove = node.next;
        node.next = toRemove.next;
        return toRemove.data;
    }

    public int size(){
        return size(head);
    }

    private int size(Node<E> node) {
        if (node != null) {
            return 1 + size(node.next);
        }
        return 0;
    }

}

