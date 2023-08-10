package javaapplication1;
/**
 *
 * @author Walaa Alfahmi
 */
public class CircularLinkedList<E> {

    class Node<E> {

        E data;
        Node next;

        public Node() {
            next = null;
        }

        public Node(E e) {
            data = e;
            next = null;
        }
    }

    Node tail;
    int size = 0;

    public CircularLinkedList() {
        tail = null;
        size = 0;
    }

    public void addFirst(E e) {

        Node newest = new Node(e);

        if (tail == null) {
            newest.next = newest;
            tail = newest;
        } else {
            newest.next = tail.next;
            tail.next = newest;
        }

        size++;

    }

    public void insert(Integer e) {
        Node newest = new Node(e);
        if (tail == null) {
            newest.next = newest;
            tail = newest;
            size++;
        } else if ((Integer) newest.data < (Integer) tail.next.data) {
            addFirst((E) e);
        } else {
            Node c = tail.next;

            while (c.next != tail.next && (Integer) newest.data > (Integer) c.next.data) {
                c = c.next;
            }

            if ((Integer) newest.data > (Integer) c.next.data) {
                addLast((E) e);
            } else {
                newest.next = c.next;
                c.next = newest;
                size++;
            }

        }

    }

    public void addLast(E e) {
        addFirst(e);
        tail = tail.next;
    }

    public void removeFirst() {
        if (tail != null) {
            if (tail.next == tail) {
                tail = null;
                size--;
            } else {
                Node temp = tail.next;
                tail.next = temp.next;
                size--;
            }
        }
    }

    public void remove(E e) {
        if (tail != null) {
            if (tail.next.data == e) {
                removeFirst();
            } else if (tail.data == e) {
                removeLast();
            } else {
                Node c = tail.next;
                while (c.next != tail.next && c.next.data != e) {
                    c = c.next;
                }
                if (c.next != tail.next) {
                    System.out.println(c.next.data);
                    Node temp = c.next;
                    c.next = temp.next;
                    size--;
                }
            }
        }
    }

    public void removeLast() {
        if (tail != null) {
            if (tail.next == tail) {
                tail.next = null;
                tail = null;
                size--;
            } else {
                Node secondLast = tail.next;
                Node last = secondLast.next;
                while (last.next != tail.next) {
                    secondLast = secondLast.next;
                    last = last.next;
                }
                secondLast.next = tail.next;
                tail = secondLast;
                size--;
            }
        }

    }

    void print() {
        System.out.println("head " + tail.next.data);
        System.out.println("tail " + tail.data);
        Node c = tail.next;

        do {
            System.out.print(c.data + "\t");
            c = c.next;
        } while (c != tail.next);
        System.out.println("");
    }

    public static void main(String[] args) {
        // TODO code application logic here
        CircularLinkedList list = new CircularLinkedList();

        list.addLast(50);

        list.addFirst(5);

        list.addLast(10);

        list.addFirst(8);

        list.print();

        list.removeFirst();
        list.removeLast();
        list.removeFirst();
        System.out.println(list.size);
        list.insert(8);
        list.print();
        list.insert(5);
        list.print();

        list.insert(1);
        list.print();

        list.insert(0);
        list.print();

        list.insert(7);
        list.print();

        list.insert(9);
        list.print();

        list.insert(2);

        list.remove(50);

        list.print();

    }

}
