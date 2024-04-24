import java.util.Objects;

public class SinglyLinkedList<E> {
    private Node head;
    private Node last;
    private int size = 0;

    private class Node {
        private Node next;
        private E value;

        public Node(E value) {
            this.value = value;
        }
    }

    public void add(E e){
        if (Objects.isNull(head)){
            head = new Node(e);
            last = head;
        } else {
            last.next = new Node(e);
            last = last.next;
        }
        size++;
    }

    public E get(int index){
        Objects.checkIndex(index, size - 1);

        int c = 0;
        for (Node x = head; x != null; x = x.next){
            if (c == index){
                return x.value;
            }
            c++;
        }

        return null;
    }

    public void remove(int index){
        Objects.checkIndex(index, size);

        if (index == 0){
            head = head.next;
            size--;
            return;
        }

        int i = 1;
        Node prev = head;
        for (Node x = head.next; x != null; x = x.next){
            if (i == index){
                prev.next = x.next;
                size--;
                return;
            }
            i++;
            prev = x;
        }
    }

    public boolean contains(E e){
        for (Node x = head; x != null; x = x.next){
            if (Objects.equals(x.value, e)){
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for (Node x = head; x != null; x = x.next){
            sb.append(x.value).append(", ");
        }

        if (sb.length() > 1){
            sb.setLength(sb.length() - 2);
        }

        return sb.append("]").toString();
    }
}