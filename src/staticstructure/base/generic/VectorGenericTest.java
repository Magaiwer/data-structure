package staticstructure.base.generic;

/**
 * @author Magaiver Santos
 */
public class VectorGenericTest {
    public static void main(String[] args) {
        VectorGeneric<String> vector = new VectorGeneric<>(2);
        vector.add("element 1");
        vector.add("element 2");
        vector.add("element 3");
        vector.add("element 4");
        vector.add("element 5");
        vector.add("element 3");
        vector.add("element 6");

        System.out.println(vector.toString());
        System.out.println("Size = " + vector.getSize());
        System.out.println("Contains element 4 = " + vector.contains("element 4"));
        System.out.println("Search element  position 2 = " + vector.search(2));
        System.out.println("Index of element 3 = " + vector.indexOf("element 3"));

        System.out.println("Add item hi position 3  = " + vector.add(3, "hi"));
        System.out.println(vector.toString());

        System.out.println("Remove element position 3 = " +vector.remove(3));
        System.out.println(vector.toString());

        System.out.println("Remove element 5 = " + vector.remove("element 5"));
        System.out.println(vector.toString());

        System.out.println("Last index of element 3 = " + vector.lastIndexOf("element 3"));
        System.out.println(vector.toString());

        System.out.println("Remove all = ");
        vector.removeAll();
        System.out.println(vector.toString());
    }
}
