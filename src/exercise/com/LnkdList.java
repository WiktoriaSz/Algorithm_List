package exercise.com;

public class LnkdList {
    private Node head = new Node(null);
    private int size;

    /**
     * Constructor uses method clear to create empty list (next = null, size = 0).
     */
    public LnkdList() {
        clear();
    }

    /**
     * Sets next to null so there are no more links to the next element. Now list contains only 1 element, but it is null.
     */
    public void clear() {
        head.setNext(null);
        size = 0;
    }

    /**
     * Checks if the list is empty. If true it sets the value as list's first element.
     * If not the method creates a node with first element of the list and then iterates to the last.
     * In last element's null node it sets new node with passed value. Now our objects is set within the last element.
     *
     * @param value an object we wont to add.
     */
    public void add(Object value) {
        if (head.getNext() == null) {
            head.setNext(new Node(value));
        } else {
            Node lastElement = head.getNext();
            while (lastElement.getNext() != null) {
                lastElement = lastElement.getNext();
            }
            lastElement.setNext(new Node(value));
        }
        ++size;
    }

    /**
     * First it checks if the list is empty.
     * If not it checks the first element and further if needed.
     * If it has an object we want to delete, it overwrites this node with the next one and sizes down the list.
     * @param object an object we want to delete from the list.
     * @return  1. if the list is empty returns false.
     *          2. it returns true if the first element had the object we wanted to delete.
     *          3. it returns true if it found the object we want to delete.
     *          4. it returns false if it does not find the object we want to delete.
     */
    public boolean delete(Object object) {
        Node start = head.getNext();
        if (start == null) {
            return false;
        }
        if (start.getValue().equals(object)) {
            start.setNext(start.getNext());
            --size;
            return true;
        }
        while (start.getNext() != null) {
            if (start.getNext().getValue().equals(object)) {
                start.setNext(start.getNext().getNext());
                --size;
                return true;
            }
            start = start.getNext();
        }
        return false;
    }

    /**
     * It search for a node under indicated index and returns its object.
     * @param index indicator of position within the list.
     * @return object contained within the node on this position.
     * @see LnkdList#searchForNode(int)
     */
    public Object get(int index) {
        return searchForNode(index).getValue();
    }

    /**
     * Iterates elements according to their links one after another until the index.
     * @param index indicator of node's position within the list.
     * @return a node under indicated index.
     * @throws IndexOutOfBoundsException when there is no node with such index.
     */
    private Node searchForNode(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node search = head.getNext();
        for (int i = 1; i <= index; i++) {
            search = search.getNext();
        }

        return search;
    }

    /**
     * It search for a node under indicated index and overwrites its object with the new one.
     * @param index indicator of position within the list.
     * @see LnkdList#searchForNode(int)
     */
    public void set(int index, Object value){
        searchForNode(index).setValue(value);
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


    private static final class Node {
        private Object value; // actual element
        private Node next; // reference to next element

        /**
         * Constructor for actual object and its reference to the next one.
         *
         * @param object actual object.
         * @param n      reference to next object.
         */
        Node(Object object, Node n) {
            this.value = object;
            next = n;
        }

        /**
         * Constructor for actual object added as the last of the list.
         *
         * @param value value of actual object.
         */
        Node(Object value) {
            this(value, null);
        }

        Node getNext() {
            return next;
        }

        void setNext(Node node) {
            this.next = node;
        }

        Object getValue() {
            return value;
        }

        void setValue(Object value) {
            this.value = value;
        }
    }
}
