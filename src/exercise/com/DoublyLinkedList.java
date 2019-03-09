package exercise.com;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private Node2 head = new Node2(null);
    private Node2 tail = new Node2(null);
    private int size;

    /**
     * Delegates construction to the clear method.
     */
    public DoublyLinkedList() {
        clear();
    }

    /**
     * The method clears whole list.
     */
    public void clear() {
        head.setPrevious(null);
        head.setNext(tail);
        tail.setPrevious(head);
        tail.setNext(null);
        size = 0;
    }

    /**
     * The method checks the state of list and adds passed value at the very beginning of the list.
     * @param value object passed to the method.
     */
    public void addFirst(Object value) {
        Node2 firstElement = new Node2(value, head, null);
        if (head.getNext() == null) {
            head.setNext(firstElement);
        } else {
            firstElement.setNext(head.getNext());
            head.getNext().setPrevious(firstElement);
            head.setNext(firstElement);
        }
        ++size;
    }

    /**
     * The method checks the state of list and adds passed value at the very end of the list.
     * @param value object passed to the method.
     */
    public void addLast(Object value) {
        Node2 lastElement = new Node2(value, null, tail);
        if (tail.getPrevious() == null) {
            tail.setPrevious(lastElement);
        } else {
            lastElement.setPrevious(tail.getPrevious());
            tail.getPrevious().setNext(lastElement);
            tail.setPrevious(lastElement);
        }
        ++size;
    }

    /**
     * The method search from both ends of the list for indicated element and deletes it.
     * @param object value of node we wants to delete.
     * @throws NoSuchElementException when list is empty and when the method didn't find such element.
     */
    public void delete(Object object) throws NoSuchElementException {
        Node2 start = head.getNext();
        if (start == null) {
            throw new NoSuchElementException("The list is empty.");
        }
        if (start.getValue().equals(object)) {
            head.setNext(start.getNext());
            start.getNext().setPrevious(head);
            --size;
            return;
        }
        Node2 end = tail.getPrevious();
        if (end.getValue().equals(object)) {
            tail.setPrevious(end.getPrevious());
            end.getPrevious().setNext(tail);
            --size;
            return;
        }
        while (start.getNext().getValue() != null && end.getPrevious().getValue() != null) {
            if(end.getPrevious() == start.getNext()){
                break;
            }
            if (start.getNext().getValue().equals(object)) {
                start.setNext(start.getNext().getNext());
                start.getNext().setPrevious(start.getPrevious());
                --size;
                return;
            }
            if (end.getPrevious().getValue().equals(object)) {
                end.setPrevious(end.getPrevious().getPrevious());
                end.getPrevious().setNext(end.getPrevious());
                --size;
                return;
            }
            end = end.getPrevious();
            start = start.getNext();
        }
        throw new NoSuchElementException("There is no such element.");
    }

    /**
     * @return field size.
     */
    public int size() {
        return size;
    }

    /**
     * @return if size is 0 (true) or not (false).
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Iterates elements according to their links one after another until the index.
     * The method search from the beginning or from the end, depending on the index value.
     *
     * @param index indicator of node's position within the list.
     * @return a node under indicated index.
     * @throws IndexOutOfBoundsException when there is no node with such index.
     */
    private Node2 searchForNode(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Incorrect index value.");
        }
        Node2 search;
        if (size - index > index) {
            search = head.getNext();
            for (int i = 1; i <= index; i++) {
                search = search.getNext();
            }
        } else {
            search = tail.getPrevious();
            for (int i = (size - 1); i > index; i--) {
                search = search.getPrevious();
            }
        }
        return search;
    }

    /**
     * It search for a node under indicated index and overwrites its object with the new one.
     *
     * @param index indicator of position within the list.
     * @see DoublyLinkedList#searchForNode(int)
     */
    public void set(int index, Object value) {
        searchForNode(index).setValue(value);
    }

    /**
     * It search for a node under indicated index and returns its object.
     *
     * @param index indicator of position within the list.
     * @return object contained within the node on this position.
     * @see DoublyLinkedList#searchForNode(int)
     */
    public Object get(int index) {
        return searchForNode(index).getValue();
    }

    /**
     * @return each element of the list or proper communicate if empty.
     */
    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "The list is empty.";
        } else {
            StringBuilder string = new StringBuilder();
            for (int i = 0; i < size; i++) {
                string = string.append(" ").append(this.get(i)).append(",");
            }
            string.deleteCharAt(string.lastIndexOf(","));
            return "The list =" + string;
        }
    }

    private static final class Node2 {
        private Object value; // actual element
        private Node2 previous; // reference to previous element
        private Node2 next; // reference to next element

        /**
         * Constructor for actual object and its reference to the next one.
         *
         * @param object actual object.
         * @param n      reference to next object.
         * @param p      reference to previous element
         */
        Node2(Object object, Node2 p, Node2 n) {
            this.value = object;
            previous = p;
            next = n;
        }

        /**
         * Constructor for actual object added as the last of the list.
         *
         * @param value value of actual object.
         */
        Node2(Object value) {
            this(value, null, null);
        }

        Node2 getNext() {
            return next;
        }

        void setNext(Node2 node) {
            this.next = node;
        }

        Object getValue() {
            return value;
        }

        void setValue(Object value) {
            this.value = value;
        }

        Node2 getPrevious() {
            return previous;
        }

        void setPrevious(Node2 previous) {
            this.previous = previous;
        }
    }
}
