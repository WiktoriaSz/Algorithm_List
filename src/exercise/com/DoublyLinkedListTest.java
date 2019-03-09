package exercise.com;

public class DoublyLinkedListTest {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        System.out.println("List size is = " + list.size() + " and is empty? - " + list.isEmpty());
        list.addFirst(1);
        System.out.println(list.toString());
        list.addFirst(2);
        System.out.println(list.toString());
        list.addFirst(3);
        System.out.println(list.toString());
        list.addFirst(4);
        System.out.println(list.toString());
        System.out.println("List size is = " + list.size());
        System.out.println(list.get(0));
        System.out.println(list.get(3));
        list.addLast(5);
        System.out.println(list.toString());
        list.delete(3);
        System.out.println(list.toString());
        list.set(2, 11);
        System.out.println(list.toString());
        list.clear();
        System.out.println(list.toString());
        list.delete(77);

    }
}
