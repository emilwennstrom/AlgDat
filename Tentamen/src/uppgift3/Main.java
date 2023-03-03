package uppgift3;

public class Main {

    public static void main(String[] args) {


        SingleLinkedList<String> list = new SingleLinkedList<>();
        System.out.println(list.size());
        for (int i = 0; i < 4; i++)
        {
            list.add("e" + i);
            System.out.println(list.size());
        }
        System.out.println(list.remove(2));
        System.out.println(list);
        System.out.println(list.get(2));
        System.out.println(list.remove(2));
        System.out.println(list);
        System.out.println(list.remove(0));
        System.out.println(list);
        System.out.println(list.remove(0));
        System.out.println(list);
    }

}