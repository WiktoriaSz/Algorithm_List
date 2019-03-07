package exercise.com;

public class Main {
    public static void main(String[] args) {

        LnkdList list = new LnkdList();
        list.add("Ala");
        list.add("Basia");
        list.add("Kasia");
        System.out.println("Is the list empty? " + list.isEmpty());
        System.out.println("Size of the list = " + list.size());
        System.out.println("Element under the index 1 = " + list.get(1));
        list.set(1, "Barbara Kowalska");
        System.out.println("New element under the index 1 = " + list.get(1));
        list.delete("Ala");
        System.out.println("Size of the list after delete = " + list.size());
        list.clear();
        System.out.println("Size of the list after clear = " + list.size());

    }
}
